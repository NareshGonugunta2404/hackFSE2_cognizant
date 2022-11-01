package com.united.company.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegistry{
	
	//@NotNull(message = "companyCode is Mandatory")
	private String companyCode;
	
	//@NotNull(message = "companyName is Mandatory")
	private String companyName;
	
	//@NotNull(message = "companyCEO is Mandatory")
	private String companyCEO;
	
	//@NotNull(message = "companyTurnover is Mandatory")
	private long companyTurnover;
	
	//@NotNull(message = "companyWebsite is Mandatory")
	private String companyWebsite;
	
	//@NotNull(message = "stockExchange is Mandatory")
	private String stockExchange;
	
}
