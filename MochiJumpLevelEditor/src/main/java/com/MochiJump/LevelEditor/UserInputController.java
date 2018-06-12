package com.MochiJump.LevelEditor;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MochiJump.LevelEditor.UserInput;
import com.MochiJump.LevelEditor.UserInputRepo;
import com.fasterxml.jackson.annotation.JsonProperty;

@Controller
@RequestMapping(path="/test")
public class UserInputController {
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
	
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable<UserInput> getAllUserInputs(){
		return UserInputRepo.findAll();
	}
	//With the format as it currently is should be able to use @Request Param and return corresponding objects as POJOs
	@PostMapping(path="/json")	
	public @ResponseBody void jsonConTest(@RequestBody @JsonProperty String x){
		System.out.println(x);
	}
	
}
