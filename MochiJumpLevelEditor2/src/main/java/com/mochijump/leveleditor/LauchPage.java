package com.mochijump.leveleditor;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LauchPage {
	@RequestMapping("/")
	public String home(Model model) {
              return "forward:/index.html";
       }
	
	@GetMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
	
	@RequestMapping ("/user")
	@ResponseBody
	public Principal user (Principal user) {
		return user;
	}

}
