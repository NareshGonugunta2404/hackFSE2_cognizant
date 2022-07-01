package com.united.stock.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.united.stock.client.CompanyClient;
import com.united.stock.entity.StockData;
import com.united.stock.exception.CompanyNotFoundException;
import com.united.stock.kafka.KafkaSender;
import com.united.stock.model.StockDataWithDetail;
import com.united.stock.service.AppService;

@RestController
@RequestMapping("/stock")
public class StockDataController {

	@Autowired
	AppService appService;
	
	@Autowired
	CompanyClient client;
	
	@Autowired
	KafkaSender kafkaSender;
	
	@Value("${restclient.companyregistry.url}")
	String companyRegistryUrl;
	
	@GetMapping("/greetings")
	public String greetings() {
		return "Welcome to stock-price micro-service";
	}
	
	@PostMapping("/add/{companyCode}/{stockPrice}")
	public StockData saveStockPrice(@PathVariable String companyCode, @PathVariable double stockPrice) {
		try {
			URI determinedBasePathUri = URI.create(companyRegistryUrl);
			client.getCompany(determinedBasePathUri, companyCode);
		} catch (Exception e) {
			throw new CompanyNotFoundException();
		}
		StockData stockDataSaved = appService.saveStockPrice(companyCode, stockPrice);
		kafkaSender.send(stockDataSaved.toString());
		return stockDataSaved;
	}
	
	@GetMapping("/get/{companyCode}/{startDate}/{endDate}")
	public List<StockData> fetchStockData(@PathVariable String companyCode, @PathVariable String startDate, @PathVariable String endDate){
		try {
			URI determinedBasePathUri = URI.create(companyRegistryUrl);
			client.getCompany(determinedBasePathUri, companyCode);
		} catch (Exception e) {
			throw new CompanyNotFoundException();
		}
		return appService.fetchStockData(companyCode, startDate, endDate);
	}
	
	@GetMapping("/getWithDetail/{companyCode}/{startDate}/{endDate}")
	public StockDataWithDetail fetchStockDataWithDetail(@PathVariable String companyCode, @PathVariable String startDate, @PathVariable String endDate){
		try {
			URI determinedBasePathUri = URI.create(companyRegistryUrl);
			client.getCompany(determinedBasePathUri, companyCode);
		} catch (Exception e) {
			throw new CompanyNotFoundException();
		}
		StockDataWithDetail stockDataWithDetail = new StockDataWithDetail();
		List<StockData> stockDataList = appService.fetchStockData(companyCode, startDate, endDate);
		stockDataWithDetail.setStockDataList(stockDataList);
		stockDataWithDetail.setAvgOfPrice(appService.getAvgPrice(stockDataList));
		stockDataWithDetail.setMaxPrice(appService.getMaxPrice(stockDataList));
		stockDataWithDetail.setMinPrice(appService.getMinPrice(stockDataList));
		return stockDataWithDetail;
	}
	
	@DeleteMapping("/delete/{companyCode}")
	public void deleteStockData(@PathVariable String companyCode) {
		appService.deleteStockDataByCompanyCode(companyCode);
	}
}
