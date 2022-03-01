package com.gunnerapis.hfinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunnerapis.hfinventory.entities.InventoryEntity;
import com.gunnerapis.hfinventory.repositories.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	InventoryRepository inventoryRepository;

	@GetMapping("/all")
	public ResponseEntity<List<InventoryEntity>> findAll() {
		List<InventoryEntity> list = inventoryRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/id={id}")
	public ResponseEntity<InventoryEntity> findById(@PathVariable long id) {
		return ResponseEntity.ok(inventoryRepository.findById(id).get());
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody InventoryEntity inventory) {
		inventoryRepository.deleteById(inventory.getId());
	}

	@PostMapping("/save")
	public ResponseEntity<InventoryEntity> save(@RequestBody InventoryEntity entity) {
		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setName(entity.getName());
		inventoryEntity.setDescription(entity.getDescription());
		inventoryEntity.setPrice(entity.getPrice());
		inventoryEntity.setSize(entity.getSize());
		inventoryEntity.setType(entity.getType());
		inventoryEntity.setAmount(entity.getAmount());
		inventoryEntity.setMark(entity.getMark());
		return ResponseEntity.ok(inventoryRepository.save(inventoryEntity));
	}

	@PatchMapping("/update")
	public ResponseEntity<?> update(@RequestBody InventoryEntity entity) {
		long id = entity.getId();
		List<Long> list = inventoryRepository.findAllIds();
		if (list.isEmpty()) {
			return ResponseEntity.badRequest().body("Não existem dados no banco!");
		} else if (!list.contains(id)) {
			return ResponseEntity.badRequest().body("Não exite no baco de dados o Id: " + id);
		}
		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setId(entity.getId());
		inventoryEntity.setName(entity.getName());
		inventoryEntity.setDescription(entity.getDescription());
		inventoryEntity.setPrice(entity.getPrice());
		inventoryEntity.setSize(entity.getSize());
		inventoryEntity.setType(entity.getType());
		inventoryEntity.setAmount(entity.getAmount());
		inventoryEntity.setMark(entity.getMark());
		return ResponseEntity.ok(inventoryRepository.save(inventoryEntity));
	}

}
