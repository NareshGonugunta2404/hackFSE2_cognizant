package com.united.stock.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String companyCode;
	private double stockPrice;
	private LocalDateTime currentDateAndTime=LocalDateTime.now();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public LocalDateTime getCurrentDateAndTime() {
		return currentDateAndTime;
	}
	public void setCurrentDateAndTime(LocalDateTime currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}
	public StockData() {
		super();
	}
	public StockData(long id, String companyCode, double stockPrice, LocalDateTime currentDateAndTime) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.currentDateAndTime = currentDateAndTime;
	}
	@Override
	public String toString() {
		return "StockData [id=" + id + ", companyCode=" + companyCode + ", stockPrice=" + stockPrice
				+ ", currentDateAndTime=" + currentDateAndTime + "]";
	}
	
}
