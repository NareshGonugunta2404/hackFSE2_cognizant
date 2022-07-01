package com.united.stock.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.united.stock.resource.CompanyRegistry;
import com.united.stock.util.AppConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(AppConstant.ROOT_URI_V1)
public interface ApiContract {
	
	// STOCK APP
	@ApiOperation(value ="Add new stock price", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@PostMapping(path = "stock/add/{companycode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addStockStockPriceDetails(@PathVariable String companyCode, @RequestBody Double companyStockDetails);
	
	@ApiOperation(value ="Fetches stock price list", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@PostMapping(path = "stock/get/{companycode}/{startdate}/{enddate}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStockPriceList(@PathVariable String companyCode, @PathVariable String startdate, @PathVariable String endDate);

	@ApiOperation(value ="update a stock price Company", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@DeleteMapping(path = "company/update/{companycode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> updatCompanyDetails(String companyCode);
	
}
