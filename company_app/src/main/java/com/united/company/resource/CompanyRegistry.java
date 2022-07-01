package com.united.company.resource;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegistry implements Serializable {
	
	@NotNull(message = "companyCode is Mandatory")
	private Long companyCode;
	
	@NotNull(message = "companyName is Mandatory")
	private String companyName;
	
	@NotNull(message = "companyCEO is Mandatory")
	private String companyCEO;
	
	@NotNull(message = "companyTurnover is Mandatory")
	private long companyTurnover;
	
	@NotNull(message = "companyWebsite is Mandatory")
	private String companyWebsite;
	
	@NotNull(message = "stockExchange is Mandatory")
	private String stockExchange;
	
}
