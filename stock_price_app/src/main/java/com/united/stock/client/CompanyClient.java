package com.united.stock.client;

import java.net.URI;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.united.stock.resource.CompanyData;

@FeignClient(value="company-client", url="http://loclhost:8989/company/")
public interface CompanyClient {

	@GetMapping("/info/{companyCode}")
	CompanyData getCompany(URI baseUrl, @PathVariable String companyCode);
}
