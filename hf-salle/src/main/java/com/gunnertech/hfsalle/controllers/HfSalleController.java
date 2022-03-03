package com.gunnertech.hfsalle.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salle")
public class HfSalleController {
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
}