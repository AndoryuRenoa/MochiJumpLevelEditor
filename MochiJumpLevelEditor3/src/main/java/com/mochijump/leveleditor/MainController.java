package com.mochijump.leveleditor;

import java.io.IOException;

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
	
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable <Level> getAllUserInputs(){
		return uRepository.findAll();
	}
	
	
	@GetMapping(path="/return")
	public @ResponseBody Iterable <Level> getLevel (@RequestParam String name) {
		return uRepository.findByLevelName(name);
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
	
}
