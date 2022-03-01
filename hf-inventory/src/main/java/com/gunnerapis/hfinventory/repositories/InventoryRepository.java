package com.gunnerapis.hfinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gunnerapis.hfinventory.entities.InventoryEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
	
	@Query(value = "select id from hf_inventory", nativeQuery = true)
	public List<Long> findAllIds();

}
