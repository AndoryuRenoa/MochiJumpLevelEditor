package com.mochijump.leveleditor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//^ if proper dependencies aren't setup at the beginning they can be adjusted in pom.xml

@Controller
public class LauchPage {
	@RequestMapping("/")
	public String index() {
		return"landing.html";
	}

}
