package com.mochijump.leveleditor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/tinyMCE") 
public class TinyMCEExample {
	
	@RequestMapping("")
	public String tinyMCEExample() {
		return "tinyMCE.html";
	}

}
