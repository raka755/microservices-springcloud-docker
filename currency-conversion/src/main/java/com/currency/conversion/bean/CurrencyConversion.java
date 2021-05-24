package com.currency.conversion.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String cFrom;
	private String cTo;
	private String property;
	private BigDecimal rate;
	private BigDecimal quantity;
	private BigDecimal totalCalculateAmount;
 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getcFrom() {
		return cFrom;
	}
	public void setcFrom(String cFrom) {
		this.cFrom = cFrom;
	}
	public String getcTo() {
		return cTo;
	}
	public void setcTo(String cTo) {
		this.cTo = cTo;
	}
	 
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculateAmount() {
		return totalCalculateAmount;
	}
	public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
		this.totalCalculateAmount = totalCalculateAmount;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", cFrom=" + cFrom + ", cTo=" + cTo + ", property=" + property
				+ ", rate=" + rate + ", quantity=" + quantity + ", totalCalculateAmount=" + totalCalculateAmount + "]";
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	
	
}
