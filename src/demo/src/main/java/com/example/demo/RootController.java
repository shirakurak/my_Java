package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@RequestMapping("/")
	public String home() {
		
		logger.info("here is RootController");
		
		return "Hello, World!";
	}
}
