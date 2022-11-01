package com.united.stock.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "stockdata")
public class StockData {
	
	@Id
	private long id;
	
	@Indexed(unique = true)
	private String companyCode;
	
	private double stockPrice;
	
	private LocalDateTime currentDateTime;
	//=LocalDateTime.now();
	
	@Override
	public String toString() {
		return "StockData [id=" + id + ", companyCode=" + companyCode + ", stockPrice=" + stockPrice
				+ ", currentDateAndTime=" + currentDateTime + "]";
	}
	
}
