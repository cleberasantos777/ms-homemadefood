package com.gunnerapis.hfpartners.controllers;

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

import com.gunnerapis.hfpartners.entities.PartnerEntity;
import com.gunnerapis.hfpartners.repositories.PartnerRepository;

@RestController
@RequestMapping("/partners")
public class PartnerController {

	@Autowired
	PartnerRepository partnerRepository;

	@PostMapping("/save")
	public ResponseEntity<PartnerEntity> save(@RequestBody PartnerEntity partner) {
		PartnerEntity partnerEntity = new PartnerEntity();
		partnerEntity.setName(partner.getName());
		partnerEntity.setAddress(partner.getAddress());
		partnerEntity.setPhone(partner.getPhone());
		partnerEntity.setPostalCode(partner.getPostalCode());
		partnerEntity.setCity(partner.getCity());
		partnerEntity.setDistrict(partner.getDistrict());
		partnerEntity.setReference(partner.getReference());
		partnerEntity.setPartnerType(partner.getPartnerType());
		return ResponseEntity.ok(partnerRepository.save(partnerEntity));
	}

	@GetMapping("/all")
	public ResponseEntity<List<PartnerEntity>> findAll() {
		ResponseEntity<List<PartnerEntity>> response;
		response = ResponseEntity.ok(partnerRepository.findAll());
		return response;
	}

	@GetMapping("/id={id}")
	public ResponseEntity<PartnerEntity> findById(@PathVariable Long id) {
		ResponseEntity<PartnerEntity> response;
		response = ResponseEntity.ok(partnerRepository.findById(id).get());
		return response;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody PartnerEntity partner) {
		partnerRepository.deleteById(partner.getId());
	}

	@PatchMapping("/update")
	public ResponseEntity<?> update(@RequestBody PartnerEntity partner) {
		Long id = partner.getId();
		List<Long> listIds = partnerRepository.findAllIds();
		if (listIds.isEmpty()) {
			return ResponseEntity.badRequest().body("Não existem dados na base para atualizar!");
		} else if (!listIds.contains(id)) {
			return ResponseEntity.badRequest().body("Não existe nenhum registro com o Id: " + id);
		}
		PartnerEntity partnerEntity = new PartnerEntity();
		partnerEntity.setId(partner.getId());
		partnerEntity.setName(partner.getName());
		partnerEntity.setAddress(partner.getAddress());
		partnerEntity.setPhone(partner.getPhone());
		partnerEntity.setPostalCode(partner.getPostalCode());
		partnerEntity.setCity(partner.getCity());
		partnerEntity.setDistrict(partner.getDistrict());
		partnerEntity.setReference(partner.getReference());
		partnerEntity.setPartnerType(partner.getPartnerType());
		return ResponseEntity.ok(partnerRepository.save(partnerEntity));

	}

}
