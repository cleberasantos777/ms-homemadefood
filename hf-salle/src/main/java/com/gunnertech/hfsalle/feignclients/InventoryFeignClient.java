package com.gunnertech.hfsalle.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gunnertech.hfsalle.entities.HfInventoryEntity;

@FeignClient(name = "hf-inventory", url = "http://localhost:8081", path = "/inventory")
@Component
public interface InventoryFeignClient {

	@GetMapping("/id={id}")
	ResponseEntity<HfInventoryEntity> findById(@PathVariable long id);
	
}