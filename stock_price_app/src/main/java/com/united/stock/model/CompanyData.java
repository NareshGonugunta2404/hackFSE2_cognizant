package com.united.stock.model;

public class CompanyData {
	private String companyCode;
	private String companyName;
	public CompanyData() {
		super();
	}
	public CompanyData(String companyCode, String companyName) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
