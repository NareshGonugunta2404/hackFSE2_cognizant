package com.united.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.united.company.entity.Company;
import com.united.company.repository.AppRepository;
import com.united.company.resource.CompanyRegistry;
import com.united.company.util.AppUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyAppService {
	
	@Autowired
	private AppRepository appRepository;
	
	@Autowired
	private AppUtil appUtil;
	
	public Company registerCompany(CompanyRegistry companyDetails) {
		
		Company detailsToCompany = appUtil.convertConvertCompanyDetailsToCompany(companyDetails);
		Company savedEntity = appRepository.save(detailsToCompany);
		
		return savedEntity;
	}

	public Company addStockPriceDetails(String companyCode, CompanyRegistry companyStockDetails) {
		Company detailsToCompany = appUtil.convertConvertCompanyDetailsToCompany(companyStockDetails);
		Company stockPriceEntity = appRepository.save(detailsToCompany);
		return stockPriceEntity;
	}

	public Company getCompanyDetailByCompanyCode(String companyCode) {
		return appRepository.findByCompanyCode(companyCode);
	}

	public List<Company> getAllCompaniesInfo() {
		return appRepository.findAll();		
	}

	public void deleteCompany(String companyCode) {
		appRepository.deleteByCompanyCode(companyCode);
	}

	public Company updateCompanyDetailsByCompanyCode(CompanyRegistry companyRegistryRequest, Company companyExist) {
		companyExist.setCompanyCEO(companyRegistryRequest.getCompanyCEO()!= null ? companyRegistryRequest.getCompanyCEO() : companyExist.getCompanyCEO());
		companyExist.setCompanyName(companyRegistryRequest.getCompanyName()!= null ? companyRegistryRequest.getCompanyName() : companyExist.getCompanyName());
		companyExist.setCompanyWebsite(companyRegistryRequest.getCompanyWebsite()!= null ? companyRegistryRequest.getCompanyWebsite() : companyExist.getCompanyWebsite());
		companyExist.setStockExchange(companyRegistryRequest.getStockExchange()!= null ? companyRegistryRequest.getStockExchange() : companyExist.getStockExchange());
		companyExist.setCompanyTurnover(companyRegistryRequest.getCompanyTurnover() > 0.0 ? companyRegistryRequest.getCompanyTurnover() : companyExist.getCompanyTurnover());
		return appRepository.save(companyExist);
	}
	
}
