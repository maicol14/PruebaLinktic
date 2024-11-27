package com.PruebaLinktic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PruebaLinktic.model.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	 Customer findByEmail(String email);
}
