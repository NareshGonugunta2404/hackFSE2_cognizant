package com.united.stock.model;

import java.util.List;

import com.united.stock.entity.StockData;

public class StockDataWithDetail {
	private List<StockData> stockDataList;
	private double avgOfPrice;
	private double minPrice;
	private double maxPrice;
	public List<StockData> getStockDataList() {
		return stockDataList;
	}
	public void setStockDataList(List<StockData> stockDataList) {
		this.stockDataList = stockDataList;
	}
	public double getAvgOfPrice() {
		return avgOfPrice;
	}
	public void setAvgOfPrice(double avgOfPrice) {
		this.avgOfPrice = avgOfPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
}
