package com.gunnerapis.hfpartners.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunnerapis.hfpartners.entities.CustomerEntity;
import com.gunnerapis.hfpartners.repositories.PartnerRepository;

@RestController
@RequestMapping("/test")
public class PartnerController {
	
	@Autowired
	PartnerRepository partnerRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<CustomerEntity>> findAll(){
				
		return ResponseEntity.ok(partnerRepository.findAll());
	}
	
}
