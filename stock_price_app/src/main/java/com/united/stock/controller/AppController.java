package com.united.stock.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.united.stock.client.CompanyClient;
import com.united.stock.entity.StockData;
import com.united.stock.exception.CompanyNotFoundException;
import com.united.stock.kafka.KafkaSender;
import com.united.stock.resource.CompanyData;
import com.united.stock.resource.StockDataWithDetail;
import com.united.stock.service.AppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RestController
public class AppController implements ApiContract{
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private CompanyClient client;
	
	@Autowired
	KafkaSender kafkaSender;
	
	@Value("${restclient.companyregistry.url}")
	String companyRegistryUrl;
	
	@Value("${restclient.stockprice.url}")
	String stockPriceUrl;
	
	@GetMapping("/greetings")
	public String greetings() {
		return "Welcome to stock-price micro-service";
	}
	
	@Override
	public ResponseEntity<?> addStockPriceDetails(String companyCode, double stockPrice) {
		
		StockData saveStockPrice = appService.saveStockPrice(companyCode, stockPrice);
		return new ResponseEntity<>(saveStockPrice, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getStockPriceList(String companyCode, String startdate, String endDate) {
		List<StockData> stockData = appService.fetchStockData(companyCode, startdate, endDate);
		return new ResponseEntity<>(stockData, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchStockDataWithDetail(String companyCode, String startDate, String endDate) {
		// Check company is existed or not. If not exist throw company not found exception
		try {
			URI determinedBasePathUri = URI.create(companyRegistryUrl);
			CompanyData company = client.getCompany(determinedBasePathUri, companyCode);
		} catch (Exception e) {
			throw new CompanyNotFoundException();
		}
		StockDataWithDetail stockDataWithDetail = new StockDataWithDetail();
		List<StockData> stockDataList = appService.fetchStockData(companyCode, startDate, endDate);
		stockDataWithDetail.setStockDataList(stockDataList);
		stockDataWithDetail.setAvgOfPrice(appService.getAvgPrice(stockDataList));
		stockDataWithDetail.setMaxPrice(appService.getMaxPrice(stockDataList));
		stockDataWithDetail.setMinPrice(appService.getMinPrice(stockDataList));
		return new ResponseEntity<>(stockDataWithDetail, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCompanyDetails(String companyCode) {
		appService.deleteStockDataByCompanyCode(companyCode);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	}
