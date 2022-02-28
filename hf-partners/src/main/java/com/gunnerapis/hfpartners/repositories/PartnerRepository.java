package com.gunnerapis.hfpartners.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gunnerapis.hfpartners.entities.CustomerEntity;

@Repository
public interface PartnerRepository extends JpaRepository<CustomerEntity, Long>{
	
	@Query(value = "select id from hf_partners", nativeQuery = true)
	public List<Long> findAllIds();

}
