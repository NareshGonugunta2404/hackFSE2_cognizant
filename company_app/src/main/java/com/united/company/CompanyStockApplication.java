package com.united.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyStockApplication.class, args);
	}
	
}
