package com.gunnertech.hfpartner.controllers;

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

import com.gunnertech.hfpartner.entities.HfPartnerEntity;
import com.gunnertech.hfpartner.repositories.HfPartnerRepository;

@RestController
@RequestMapping("/partner")
public class HfPartnerController {

	@Autowired
	HfPartnerRepository hfPartnerRepository;

	@PostMapping("/save")
	public ResponseEntity<HfPartnerEntity> save(@RequestBody HfPartnerEntity partner) {
		HfPartnerEntity hfPartnerEntity = new HfPartnerEntity();
		hfPartnerEntity.setName(partner.getName());
		hfPartnerEntity.setAddress(partner.getAddress());
		hfPartnerEntity.setPhone(partner.getPhone());
		hfPartnerEntity.setPostalCode(partner.getPostalCode());
		hfPartnerEntity.setCity(partner.getCity());
		hfPartnerEntity.setDistrict(partner.getDistrict());
		hfPartnerEntity.setReference(partner.getReference());
		hfPartnerEntity.setPartnerType(partner.getPartnerType());
		return ResponseEntity.ok(hfPartnerRepository.save(hfPartnerEntity));
	}

	@GetMapping("/all")
	public ResponseEntity<List<HfPartnerEntity>> findAll() {
		ResponseEntity<List<HfPartnerEntity>> response;
		response = ResponseEntity.ok(hfPartnerRepository.findAll());
		return response;
	}

	@GetMapping("/id={id}")
	public ResponseEntity<HfPartnerEntity> findById(@PathVariable Long id) {
		ResponseEntity<HfPartnerEntity> response;
		response = ResponseEntity.ok(hfPartnerRepository.findById(id).get());
		return response;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody HfPartnerEntity partner) {
		hfPartnerRepository.deleteById(partner.getId());
	}

	@PatchMapping("/update")
	public ResponseEntity<?> update(@RequestBody HfPartnerEntity partner) {
		Long id = partner.getId();
		List<Long> listIds = hfPartnerRepository.findAllIds();
		if (listIds.isEmpty()) {
			return ResponseEntity.badRequest().body("Não existem dados na base para atualizar!");
		} else if (!listIds.contains(id)) {
			return ResponseEntity.badRequest().body("Não existe nenhum registro com o Id: " + id);
		}
		HfPartnerEntity hfPartnerEntity = new HfPartnerEntity();
		hfPartnerEntity.setId(partner.getId());
		hfPartnerEntity.setName(partner.getName());
		hfPartnerEntity.setAddress(partner.getAddress());
		hfPartnerEntity.setPhone(partner.getPhone());
		hfPartnerEntity.setPostalCode(partner.getPostalCode());
		hfPartnerEntity.setCity(partner.getCity());
		hfPartnerEntity.setDistrict(partner.getDistrict());
		hfPartnerEntity.setReference(partner.getReference());
		hfPartnerEntity.setPartnerType(partner.getPartnerType());
		return ResponseEntity.ok(hfPartnerRepository.save(hfPartnerEntity));

	}

}
