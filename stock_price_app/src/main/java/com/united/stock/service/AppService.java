package com.united.stock.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.united.stock.entity.StockData;
import com.united.stock.repository.AppRepo;

@Service
public class AppService {
	
	@Autowired
	AppRepo appRepo;

	public StockData saveStockPrice(String companyCode, double stockPrice) {
		StockData stockData = new StockData();
		stockData.setCompanyCode(companyCode);
		stockData.setStockPrice(stockPrice);
		return appRepo.save(stockData);
	}

	public List<StockData> fetchStockData(String companyCode, String startDate, String endDate) {
		List<StockData> returnList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDateObj = LocalDate.parse(startDate, formatter);
		LocalDate endDateObj = LocalDate.parse(endDate, formatter);
		Collection<StockData> stockData = appRepo.findByCodeAndDate(companyCode, startDateObj, endDateObj);
		returnList.addAll(stockData);
		return returnList;
	}

	public void deleteStockDataByCompanyCode(String companyCode) {
		appRepo.deleteByCompanyCode(companyCode);
	}

	public double getAvgPrice(List<StockData> stockDataList) {
		double avg = stockDataList.stream().mapToDouble(stockData -> stockData.getStockPrice()).average().orElse(0);
		return Math.round(avg*100)/100;
	}

	public double getMaxPrice(List<StockData> stockDataList) {
		return stockDataList.stream().mapToDouble(stockData -> stockData.getStockPrice()).max().orElse(0);
	}
	
	public double getMinPrice(List<StockData> stockDataList) {
		return stockDataList.stream().mapToDouble(stockData -> stockData.getStockPrice()).min().orElse(0);
	}
}
