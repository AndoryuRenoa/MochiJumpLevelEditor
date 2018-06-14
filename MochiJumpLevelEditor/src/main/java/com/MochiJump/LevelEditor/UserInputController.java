package com.MochiJump.LevelEditor;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MochiJump.LevelEditor.UserInput;
import com.MochiJump.LevelEditor.UserInputRepo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(path="/test")
public class UserInputController {
	ObjectMapper mapper = new ObjectMapper();

	
	@Autowired
	private UserInputRepo UserInputRepo;
	
//	@GetMapping(path="/add")
	//could do something like:
	/* 
	 * public void @ResponseBody String addNewUserInput (@RequestBody Map<String, Object> Incoming) throws Exception{
	 * 
	 * UserInput i = new UserInput();
	 * 
	 * for (Incoming.Entry<String, String> entry : Incoming.entrySet()){
	 *   if (entry.key.equals(tableName){
	 *   
	 * 	}
	 * }
	 * 
	 * could convert below to something simple that just outputs plain text and returns it to see what you're looking at!
	 *
	public @ResponseBody String addNewUserInput (@RequestParam String tableName,
			@RequestParam Integer startX,
			@RequestParam Integer startY,
			@RequestParam Integer width,
			@RequestParam Integer height) {
		UserInput i = new UserInput();
		i.setTableName(tableName);
		i.setStartX(startX);
		i.setStartY(startY);
		i.setWidth(width);
		i.setHeight(height);
		UserInputRepo.save(i);
		return "LevelSaved";
		
	} */
	
	
	//output here looks identical to what I'm trying to put in format-wise
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable <UserInput> getAllUserInputs(){
		return UserInputRepo.findAll();
	}
	//ok well at least I'm know the setter is being called
	@PostMapping(path="/json")	
	public @ResponseBody void RecieverTest(@RequestBody String s){
		try {
		UserInput i = mapper.readValue(s, UserInput.class);
		UserInputRepo.save(i);
//		System.out.println(i.getStartX());
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
