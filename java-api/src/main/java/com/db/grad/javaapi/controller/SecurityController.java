package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.TradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = ["http://localhost:3000","https://pets-webapp-dot-db-grads-173c-group-22.nw.r.appspot.com"])

public class SecurityController {
	
	 @Autowired
	 private TradeRepository tradeRepository;
	    
	 @Autowired
	 private SecurityRepository securityRepository;
	 
	 @GetMapping("/security")
	    public List<Security> getAllsecurities() {
	        return securityRepository.findAll();
	    }

	    @GetMapping("/security/{id}")
	    public ResponseEntity< Security > getSecurityById(@PathVariable(value = "id") Long id)
	            throws ResourceNotFoundException {
	    	Security security = securityRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));
	        return ResponseEntity.ok().body(security);
	    }

	    @PostMapping("/security")
	    public Security createSecurity(@Valid @RequestBody Security security) {
	        return securityRepository.saveAndFlush(security);
	    }

	    @PutMapping("/security/{id}")
	    public ResponseEntity < Security > updateSecurity(@PathVariable(value = "id") Long id,
	                                             @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {
	    	Security getSecurity = securityRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));

	    	getSecurity.setCoupon(securityDetails.getCoupon());
	    	getSecurity.setCusip(securityDetails.getCusip());
	    	getSecurity.setFaceValue(securityDetails.getFaceValue());
	    	getSecurity.setIsin(securityDetails.getIsin());
	    	getSecurity.setIssuer(securityDetails.getIssuer());
	    	getSecurity.setMaturityDate(securityDetails.getMaturityDate());
	    	getSecurity.setStatus(securityDetails.getStatus());
	    	getSecurity.setType(securityDetails.getType());

	        final Security updatedSecurity = securityRepository.save(getSecurity);
	        return ResponseEntity.ok(updatedSecurity);
	    }

	    @DeleteMapping("/security/{id}")
	    public Map< String, Boolean > deleteSecurity(@PathVariable(value = "id") Long id)
	            throws Exception {
	    	Security security = securityRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("security not found for this id :: " + id));

	        securityRepository.delete(security);
	        Map < String, Boolean > response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    @GetMapping("/tradesfor/{securityId}")
	    public List<Trade> getSecuritiesByTrade(@PathVariable(value = "securityId") long securityId){
	        return tradeRepository.findBySecurityId(securityId);
	    }
	    @GetMapping("/security/date")
		public List<Security> getSecurityInDateRange(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from_date, @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to_date) {
			return securityRepository.findByMaturityDateBetween(from_date, to_date);
		}
	    
	    
	    
	    
}
