package com.united.stock.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String companyCode;
	
	private double stockPrice;
	
	private LocalDateTime currentDateAndTime=LocalDateTime.now();
	
	@Override
	public String toString() {
		return "StockData [id=" + id + ", companyCode=" + companyCode + ", stockPrice=" + stockPrice
				+ ", currentDateAndTime=" + currentDateAndTime + "]";
	}
	
}
