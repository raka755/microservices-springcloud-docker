package com.csm.microservices.currencyexchange.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	@Column(name="curid")
	private Long id;
	@Column(name="currency_from")
	private String cFrom;
	@Column(name="currency_to")
	private String cTo;
	@Column(name="rate")
	private BigDecimal rate;
	@Column(name="property")
	private String property;
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
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", cFrom=" + cFrom + ", cTo=" + cTo + ", rate=" + rate + ", property="
				+ property + "]";
	}
	
	
}
