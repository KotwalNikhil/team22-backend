package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security,Long> {
	
	List<Security> findByMaturityDateBetween(Date from_date, Date to_date);
}
