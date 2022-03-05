package com.gunnertech.hfsalle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunnertech.hfsalle.entities.HfSalleEntity;
import com.gunnertech.hfsalle.entities.HfInventoryEntity;
import com.gunnertech.hfsalle.feignclients.InventoryFeignClient;
import com.gunnertech.hfsalle.services.HfSalleService;

@RestController
@RequestMapping("/salle")
public class HfSalleController {

	@Autowired
	InventoryFeignClient inventoryFeignClient;

	@Autowired
	HfSalleService salleService;

	@GetMapping("/f/idInventory={idInventory}/amount={amount}")
	public HfSalleEntity testFeign(@PathVariable long idInventory, @PathVariable double amount) {
		HfInventoryEntity hfInventoryEntity = inventoryFeignClient.findById(idInventory).getBody();
		return new HfSalleEntity(hfInventoryEntity.getName(), hfInventoryEntity.getPrice(), amount);
	}

}