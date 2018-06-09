package com.MochiJump.LevelEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MochiJump.LevelEditor.UserInput;
import com.MochiJump.LevelEditor.UserInputRepo;

@Controller
@RequestMapping(path="/test")
public class UserInputController {
	@Autowired
	private UserInputRepo UserInputRepo;
	
	@GetMapping(path="/add")
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
		
	}
	
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable<UserInput> getAllUserInputs(){
		return UserInputRepo.findAll();
	}
}
