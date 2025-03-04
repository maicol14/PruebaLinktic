package com.PruebaLinktic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PruebaLinktic.model.*;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	
	 Service findByName(String name);
	 
}