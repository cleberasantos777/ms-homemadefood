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

import com.gunnerapis.hfpartners.entities.CustomerEntity;
import com.gunnerapis.hfpartners.repositories.PartnerRepository;

@RestController
@RequestMapping("/partners")
public class PartnerController {

	@Autowired
	PartnerRepository partnerRepository;

	@PostMapping("/save")
	public ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customer.getName());
		customerEntity.setAddress(customer.getAddress());
		customerEntity.setPhone(customer.getPhone());
		customerEntity.setPostalCode(customer.getPostalCode());
		customerEntity.setCity(customer.getCity());
		customerEntity.setDistrict(customer.getDistrict());
		customerEntity.setReference(customer.getReference());
		customerEntity.setPartnerType(customer.getPartnerType());
		return ResponseEntity.ok(partnerRepository.save(customerEntity));
	}

	@GetMapping("/all")
	public ResponseEntity<List<CustomerEntity>> findAll() {
		ResponseEntity<List<CustomerEntity>> response;
		response = ResponseEntity.ok(partnerRepository.findAll());
		return response;
	}

	@GetMapping("/id={id}")
	public ResponseEntity<CustomerEntity> findById(@PathVariable Long id) {
		ResponseEntity<CustomerEntity> response;
		response = ResponseEntity.ok(partnerRepository.findById(id).get());
		return response;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody CustomerEntity customer) {
		partnerRepository.deleteById(customer.getId());
	}

	@PatchMapping("/update")
	public ResponseEntity<?> update(@RequestBody CustomerEntity customer) {
		Long id = customer.getId();
		List<Long> listIds = partnerRepository.findAllIds();
		if (listIds.isEmpty()) {
			return ResponseEntity.badRequest().body("Não existem dados na base para atualizar!");
		} else if (!listIds.contains(id)) {
			return ResponseEntity.badRequest().body("Não existe nenhum registro com o Id: " + id);
		}
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customer.getId());
		customerEntity.setName(customer.getName());
		customerEntity.setAddress(customer.getAddress());
		customerEntity.setPhone(customer.getPhone());
		customerEntity.setPostalCode(customer.getPostalCode());
		customerEntity.setCity(customer.getCity());
		customerEntity.setDistrict(customer.getDistrict());
		customerEntity.setReference(customer.getReference());
		customerEntity.setPartnerType(customer.getPartnerType());
		return ResponseEntity.ok(partnerRepository.save(customerEntity));

	}

}
