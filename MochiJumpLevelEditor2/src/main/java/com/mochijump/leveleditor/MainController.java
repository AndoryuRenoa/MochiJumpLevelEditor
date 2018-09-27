package com.mochijump.leveleditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private LevelRepository uRepository;
	
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
		return uRepository.findAll();
	}
	
	
	@GetMapping(path="/return")
	public @ResponseBody Iterable <Level> getLevel (@RequestParam String name) {
		return uRepository.findByLevelName(name);
	}
	
	@GetMapping(path="/email")
	public @ResponseBody String sendEmail() {
		String output;
		String output2="";
		try {
			
			URL url = new URL("http://localhost:8090/email/test");
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
			return "unable to check new releases due to connection";
		}	
	}
	

	
	@PostMapping(path="/json")	
	public @ResponseBody void recieverTest(@RequestBody String s){
		try {
		Level i = mapper.readValue(s, Level.class);
		Level exists = null;
		try {
			exists = uRepository.findByLevelName(i.getLevelName()).get(0);
		}catch (Exception e) {
			//this Exception will be thrown every time a new level is made
		}
		if (exists != null){
			i.setId(exists.getId());
		}
		uRepository.save(i);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	@PostMapping(path="/message")
	public @ResponseBody String sendMessage (@RequestBody String s) {
		String output;
		String output2="";
		// this needs to send (s), research format;
		try {
			
			URL url = new URL("http://localhost:8090/email/test");
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
			return "unable to check new releases due to connection";
		}	
	}
	}
	
}
