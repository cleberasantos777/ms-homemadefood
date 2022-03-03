package com.gunnertech.hfinventory.controllers;

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

import com.gunnertech.hfinventory.entities.HfInventoryEntity;
import com.gunnertech.hfinventory.repositories.HfInventoryRepository;

@RestController
@RequestMapping("/inventory")
public class HfInventoryController {

	@Autowired
	HfInventoryRepository hfInventoryRepository;

	@GetMapping("/all")
	public ResponseEntity<List<HfInventoryEntity>> findAll() {
		List<HfInventoryEntity> list = hfInventoryRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/id={id}")
	public ResponseEntity<HfInventoryEntity> findById(@PathVariable long id) {
		return ResponseEntity.ok(hfInventoryRepository.findById(id).get());
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody HfInventoryEntity inventory) {
		hfInventoryRepository.deleteById(inventory.getId());
	}

	@PostMapping("/save")
	public ResponseEntity<HfInventoryEntity> save(@RequestBody HfInventoryEntity entity) {
		HfInventoryEntity hfInventoryEntity = new HfInventoryEntity();
		hfInventoryEntity.setName(entity.getName());
		hfInventoryEntity.setDescription(entity.getDescription());
		hfInventoryEntity.setPrice(entity.getPrice());
		hfInventoryEntity.setSize(entity.getSize());
		hfInventoryEntity.setType(entity.getType());
		hfInventoryEntity.setAmount(entity.getAmount());
		hfInventoryEntity.setMark(entity.getMark());
		return ResponseEntity.ok(hfInventoryRepository.save(hfInventoryEntity));
	}

	@PatchMapping("/update")
	public ResponseEntity<?> update(@RequestBody HfInventoryEntity entity) {
		long id = entity.getId();
		List<Long> list = hfInventoryRepository.findAllIds();
		if (list.isEmpty()) {
			return ResponseEntity.badRequest().body("Não existem dados no banco!");
		} else if (!list.contains(id)) {
			return ResponseEntity.badRequest().body("Não exite no baco de dados o Id: " + id);
		}
		HfInventoryEntity hfInventoryEntity = new HfInventoryEntity();
		hfInventoryEntity.setId(entity.getId());
		hfInventoryEntity.setName(entity.getName());
		hfInventoryEntity.setDescription(entity.getDescription());
		hfInventoryEntity.setPrice(entity.getPrice());
		hfInventoryEntity.setSize(entity.getSize());
		hfInventoryEntity.setType(entity.getType());
		hfInventoryEntity.setAmount(entity.getAmount());
		hfInventoryEntity.setMark(entity.getMark());
		return ResponseEntity.ok(hfInventoryRepository.save(hfInventoryEntity));
	}

}
