package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000","https://pets-webapp-dot-db-grads-173c-group-22.nw.r.appspot.com")


public class TradeController {


	@Autowired
	private TradeRepository tradeRepository;

	@GetMapping("/trade")
	public List<Trade> getAlltrades() {
		return tradeRepository.findAll();
	}

	@GetMapping("/trade/{id}")
	public ResponseEntity< Trade > getTradesById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Trade trade = tradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("trade not found for this id :: " + id));
		return ResponseEntity.ok().body(trade);
	}

	@PostMapping("/trade")
	public Trade createTrade(@Valid @RequestBody Trade trade) {
		return tradeRepository.saveAndFlush(trade);
	}

	@PutMapping("/trade/{id}")
	public ResponseEntity < Trade > updateTrade(@PathVariable(value = "id") Long id,
												@Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {
		Trade getTrade = tradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("trade not found for this id :: " + id));
		getTrade.setBookId(tradeDetails.getBookId());
		getTrade.setCounterPartyId(tradeDetails.getCounterPartyId());
		getTrade.setBuySell(tradeDetails.getBuySell());
		getTrade.setPrice(tradeDetails.getPrice());
		getTrade.setQuantity(tradeDetails.getQuantity());
		getTrade.setSettlementDate(tradeDetails.getSettlementDate());
		getTrade.setStatus(tradeDetails.getStatus());
		getTrade.setTradeDate(tradeDetails.getTradeDate());

		final Trade updatedTrade = tradeRepository.save(getTrade);
		return ResponseEntity.ok(updatedTrade);
	}

	@DeleteMapping("/trade/{id}")
	public Map< String, Boolean > deleteSecurity(@PathVariable(value = "id") Long id)
			throws Exception {
		Trade trade = tradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("trade not found for this id :: " + id));

		tradeRepository.delete(trade);
		Map < String, Boolean > response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@PutMapping("/workontrade/{id}")
	public ResponseEntity< Trade > setWorkOnTrade(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Trade trade = tradeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("trade not found for this id :: " + id));

		trade.setActioned();
		final Trade updatedTrade = tradeRepository.save(trade);
		return ResponseEntity.ok().body(trade);
	}



}
