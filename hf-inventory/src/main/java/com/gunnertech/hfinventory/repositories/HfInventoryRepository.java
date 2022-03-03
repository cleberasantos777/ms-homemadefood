package com.gunnertech.hfinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gunnertech.hfinventory.entities.HfInventoryEntity;

@Repository
public interface HfInventoryRepository extends JpaRepository<HfInventoryEntity, Long>{
	
	@Query(value = "select id from hf_inventory", nativeQuery = true)
	public List<Long> findAllIds();

}
