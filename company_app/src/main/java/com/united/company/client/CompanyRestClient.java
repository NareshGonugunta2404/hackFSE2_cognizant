package com.united.company.client;

import java.net.URI;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="company-client", url="http://loclhost:8989/stock/")
public interface CompanyRestClient {

	@DeleteMapping("/delete/{companyCode}")
	void deleteStockData(URI baseUrl, @PathVariable Long companyCode);
}
