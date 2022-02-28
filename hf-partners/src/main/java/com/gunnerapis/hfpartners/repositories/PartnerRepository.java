package com.gunnerapis.hfpartners.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gunnerapis.hfpartners.entities.CustomerEntity;

@Repository
public interface PartnerRepository extends JpaRepository<CustomerEntity, Long>{

}
