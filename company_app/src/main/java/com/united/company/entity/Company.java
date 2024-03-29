package com.united.company.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "company")
public class Company {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String companyCode;
	
	private String companyName;
	
	private String companyCEO;
	
	private long companyTurnover;
	
	private String companyWebsite;
	
	private String stockExchange;
	
	private long stockPrice;

}
