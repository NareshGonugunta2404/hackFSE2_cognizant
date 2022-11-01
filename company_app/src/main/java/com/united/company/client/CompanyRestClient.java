package com.united.company.client;

import java.net.URI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(value="companyclient", url="http://loclhost:8089/stock/")
public interface CompanyRestClient {

	@DeleteMapping("/delete/{companyCode}")
	void deleteStockData(URI baseUrl, @PathVariable String companyCode);
}
