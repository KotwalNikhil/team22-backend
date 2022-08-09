package com.db.grad.javaapi.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "counter_party")
public class CounterParty {

    @Id
    @Column(name = "counter_party_id")
    private long counterPartyId;

    @Column(name = "counter_party_name")
    private String counterPartyName;
    
//    @OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn( name = "cp_id", referencedColumnName = "counter_party_id")
//    List<Trade> trades = new ArrayList<>();
//    
    public CounterParty() {
    	
    }
    

	public CounterParty(long counterPartyId, String counterPartyName) {
		super();
		this.counterPartyId = counterPartyId;
		this.counterPartyName = counterPartyName;
	}

	public long getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(long counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getCounterPartyName() {
		return counterPartyName;
	}

	public void setCounterPartyName(String counterPartyName) {
		this.counterPartyName = counterPartyName;
	}

//	public List<Trade> getTrades() {
//		return trades;
//	}
//
//	public void setTrades(List<Trade> trades) {
//		this.trades = trades;
//	}

}
