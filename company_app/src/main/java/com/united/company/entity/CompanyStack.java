package com.united.company.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value="company_stock_details")
public class CompanyStack {
	
	@Id
	private String uuid;
	
	private String companyCode;
	
	private String stockPrice;
	
}
