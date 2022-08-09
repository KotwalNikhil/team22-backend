package com.db.grad.javaapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "security")
public class Security {
    @Id
    @Column(name = "security_id")
    private long securityId;
    @Column(name = "isin")
    private String isin;
    @Column(name = "cusip")
    private String cusip;
    @Column(name = "issuer")
    private String issuer;

    @Column(name = "maturity_date")
    private Date maturityDate;
    @Column(name = "coupon")
    private Double coupon;
    @Column(name = "type")
    private String type;
   
    @Column(name = "face_value")
    private  Double faceValue;
    @Column(name = "status")
    private String status;
//    @OneToMany(cascade = CascadeType.ALL)
//   	@JoinColumn( name = "sc_id", referencedColumnName = "security_id")
//    List<Trade> trades = new ArrayList<>();
    
    
    public Security() {
    	
    }

	public Security(long securityId, String isin, String cusip, String issuer, Date maturityDate, Double coupon,
			String type, Double faceValue, String status) {
		super();
		this.securityId = securityId;
		this.isin = isin;
		this.cusip = cusip;
		this.issuer = issuer;
		this.maturityDate = maturityDate;
		this.coupon = coupon;
		this.type = type;
		this.faceValue = faceValue;
		this.status = status;
	}
	public long getSecurityId() {
		return securityId;
	}
	public void setSecurityId(long securityId) {
		this.securityId = securityId;
	}
	
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Double getCoupon() {
		return coupon;
	}
	public void setCoupon(Double coupon) {
		this.coupon = coupon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public List<Trade> getTrades() {
//		return trades;
//	}
//	public void setTrades(List<Trade> trades) {
//		this.trades = trades;
//	}
    

}
