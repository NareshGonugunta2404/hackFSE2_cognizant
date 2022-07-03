package com.united.company.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.united.company.client.CompanyRestClient;
import com.united.company.entity.Company;
import com.united.company.exception.CompanyCodeAlreadyExistException;
import com.united.company.exception.CompanyNotFoundException;
import com.united.company.exception.CompanyTurnoverException;
import com.united.company.resource.CompanyRegistry;
import com.united.company.service.CompanyAppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RestController
public class AppController implements ApiContract{
	
	@Autowired
	private CompanyAppService appService;
	
	@Autowired
	private CompanyRestClient client;
	
	@Value("${restclient.stockprice.url}")
	String stockPriceUrl;

	@Override
	public ResponseEntity<?> registerNewCompany(CompanyRegistry companyRegistryRequest) {
		
		if(companyRegistryRequest == null) {
			log.info("Empty Company registry has not registered.{}", companyRegistryRequest.getCompanyCode());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(companyRegistryRequest.getCompanyTurnover()<10) {
			throw new CompanyTurnoverException();
		}
		Company companyExist = appService.getCompanyDetailByCompanyCode(companyRegistryRequest.getCompanyCode());
		if(null!=companyExist) {
			throw new CompanyCodeAlreadyExistException();
			
		}
		Company registeredCompany = appService.registerCompany(companyRegistryRequest);
		//return "company \""+ companyRegistryRequest.getCompanyName()+"\" got registered with id - "+companyId;
		return new ResponseEntity<>(registeredCompany, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> getCompanyDetails(Long companyCode) {
		Company company = appService.getCompanyDetailByCompanyCode(companyCode);
	
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllCompanyDetails() {
		List<Company> allCompaniesInfo = appService.getAllCompaniesInfo();
		return new ResponseEntity<>(allCompaniesInfo, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCompanyDetails(Long companyCode) {
		Company companyRegistry = appService.getCompanyDetailByCompanyCode(companyCode);
		if(null == companyRegistry) {
			throw new CompanyNotFoundException();
		}
		URI determinedBasePathUri = URI.create(stockPriceUrl);
		client.deleteStockData(determinedBasePathUri,companyCode);
		appService.deleteCompany(companyCode);
		log.info("Company deleted with company code \""+companyCode+"\".");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
