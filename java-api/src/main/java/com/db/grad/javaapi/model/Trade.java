package com.db.grad.javaapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Table(name = "TRADE")
public class Trade {
    @Id
    @Column(name = "trade_id")
    private  long tradeId;
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "counter_party_id")
    private long counterPartyId;

    @Column(name = "security_id")
    private long securityId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private double price;

	@Column(name = "buy_sell")
    private String buySell;

    @Column(name = "trade_date")
    private Date tradeDate;

    @Column(name = "settlement_date")
    private Date settlementDate;
    
    @Column(name = "actioned")
    private long actioned=0;
    
    public long getActioned() {
		return actioned;
	}

	public void setActioned() {
		this.actioned = 1;
	}

	public Trade() {
    	
	}

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(long counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public long getSecurityId() {
		return securityId;
	}

	public void setSecurityId(long securityId) {
		this.securityId = securityId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public CounterParty getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(CounterParty counterParty) {
		this.counterParty = counterParty;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	@ManyToOne
    @JoinColumn(name="book_id", nullable=false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Book book;

    @ManyToOne
    @JoinColumn(name="counter_party_id", nullable=false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    CounterParty counterParty;

    @ManyToOne
    @JoinColumn(name="security_id", nullable=false, insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Security security;

}
