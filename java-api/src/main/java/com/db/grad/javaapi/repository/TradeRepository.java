package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade,Long> {
	
	List<Trade> findBySecurityId(long securityId);
}
