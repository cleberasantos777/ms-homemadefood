package com.gunnertech.hfpartner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gunnertech.hfpartner.entities.HfPartnerEntity;

@Repository
public interface HfPartnerRepository extends JpaRepository<HfPartnerEntity, Long>{
	
	@Query(value = "select id from hf_partner", nativeQuery = true)
	public List<Long> findAllIds();

}
