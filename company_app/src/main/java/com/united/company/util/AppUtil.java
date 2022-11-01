package com.united.company.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.united.company.entity.Company;
import com.united.company.resource.CompanyRegistry;

@Component
public class AppUtil {
	
	public Company convertConvertCompanyDetailsToCompany(CompanyRegistry companyDetails) {
		Company company = new Company();
		company.setCompanyCode(companyDetails.getCompanyCode());
		company.setCompanyCEO(companyDetails.getCompanyCEO());
		company.setCompanyName(companyDetails.getCompanyName());
		company.setCompanyTurnover(companyDetails.getCompanyTurnover());
		company.setCompanyWebsite(companyDetails.getCompanyWebsite());
		company.setStockExchange(companyDetails.getStockExchange());
		company.setId(UUID.randomUUID().toString());
		return company;
	}

}
