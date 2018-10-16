package com.mochijump.leveleditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mochijump.leveleditor.Level;
import com.mochijump.leveleditor.LevelRepository;

@Controller    
@RequestMapping(path="/test") 
public class MainController {
	ObjectMapper mapper = new ObjectMapper();
	
	
	@Autowired
	private LevelRepository levelRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("")
	public String drawPageLaunch() {
		return"draw.html";
	}
	
	@GetMapping(path = "/version")
	public @ResponseBody String getVersion(){
			return "0.2.4";
	}
	
	
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable <Level> getAllUserInputs(){
		return levelRepository.findAll();
	}
	
	
	// this obviously will need to be changed later
	@GetMapping(path="/returnAllUsers")
	public @ResponseBody Iterable <User> getListOfAllUsers(){
		return userRepository.getAllExceptPassword();
	}
	
	@RequestMapping(path="/addUser")
	public @ResponseBody String addUser(@RequestParam String firstName, @RequestParam String userName,
			@RequestParam String emailAddress, @RequestParam String password){
		User newUser = new User ();
		newUser.setUserFirstName(firstName);
		newUser.setUserName(userName);
		newUser.setEmailAddress(emailAddress);
		newUser.setPassword(password);
		userRepository.save(newUser);
		return "User added";
	}
	
	
	@GetMapping(path="/return")
	public @ResponseBody Iterable <Level> getLevel (@RequestParam String name) {
		return levelRepository.findByLevelName(name);
	}
	
	@GetMapping(path="/emailTest")
	public @ResponseBody String sendEmail() {
		String output;
		String output2="";
		try {
			
			URL url = new URL("http://mochijumpemailer-env.evyk8k3wmq.us-east-2.elasticbeanstalk.com/email/test");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                output2 = output;
            }
            return output2;
		}
		catch (Exception e) {
			return "error" + e;
		}	
	}
	

	
	@PostMapping(path="/json")	
	public @ResponseBody void recieverTest(@RequestBody String s){
		try {
		Level i = mapper.readValue(s, Level.class);
		Level exists = null;
		try {
			exists = levelRepository.findByLevelName(i.getLevelName()).get(0);
		}catch (Exception e) {
			//this Exception will be thrown every time a new level is made
		}
		if (exists != null){
			i.setId(exists.getId());
		}
		levelRepository.save(i);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
	@PostMapping(path="/message")
	public @ResponseBody String sendRestMessage (@RequestBody String s) {
		HttpHeaders headers = new HttpHeaders();
		RestTemplate rest = new RestTemplate();
		HttpStatus status;
		HttpEntity <String> requestEntity = new HttpEntity (s, headers);
		ResponseEntity<String> responseEntity = rest.exchange("http://mochijumpemailer-env.evyk8k3wmq.us-east-2.elasticbeanstalk.com/email/message", 
				HttpMethod.POST, requestEntity, String.class);
		status = responseEntity.getStatusCode();
		return responseEntity.getBody();
	
	}
	
	
}
