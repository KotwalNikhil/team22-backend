package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CounterPartyController {

	 @Autowired
	 private TradeRepository tradeRepository;

	 @Autowired
	 private CounterPartyRepository counterPartyRepository;


	@GetMapping("/counterparty")
    public List<CounterParty> getAllCounterParties() {
        return counterPartyRepository.findAll();
    }

    @GetMapping("/counterparty/{id}")
    public ResponseEntity< CounterParty > getCounterPartyById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CounterParty counterparty = counterPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Counter Party not found for this id :: " + id));
        return ResponseEntity.ok().body(counterparty);
    }

    @PostMapping("/counterparty")
    public CounterParty createCounterParty(@Valid @RequestBody CounterParty counterparty) {
        return counterPartyRepository.saveAndFlush(counterparty);
    }

    @PutMapping("/counterparty/{id}")
    public ResponseEntity < CounterParty > updateCounterParty(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody CounterParty counterPartyDetails) throws ResourceNotFoundException {
    	CounterParty getCounterParty = counterPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Counter Party not found for this id :: " + id));

    	getCounterParty.setCounterPartyName(counterPartyDetails.getCounterPartyName());

        final CounterParty updatedCounterParty = counterPartyRepository.save(getCounterParty);
        return ResponseEntity.ok(updatedCounterParty);
    }

    @DeleteMapping("/counterparty/{id}")
    public Map< String, Boolean > deleteCounterParty(@PathVariable(value = "id") Long id)
            throws Exception {
        CounterParty counterparty = counterPartyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Counter Party not found for this id :: " + id));

        counterPartyRepository.delete(counterparty);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
