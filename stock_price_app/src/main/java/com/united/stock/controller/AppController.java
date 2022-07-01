package com.united.stock.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.united.stock.entity.StockData;
import com.united.stock.service.AppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RestController
public class AppController implements ApiContract{
	
	@Autowired
	private AppService appService;
	
//	@Autowired
//	RestClient client;
	
	@Value("${restclient.stockprice.url}")
	String stockPriceUrl;
	
	@Override
	public ResponseEntity<?> addStockStockPriceDetails(String companyCode, Double stockPrice) {
		
		StockData saveStockPrice = appService.saveStockPrice(companyCode, stockPrice);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getStockPriceList(String companyCode, String startdate, String endDate) {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updatCompanyDetails(String companyCode) {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
