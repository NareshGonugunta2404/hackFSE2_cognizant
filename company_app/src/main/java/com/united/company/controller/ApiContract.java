package com.united.company.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.united.company.resource.CompanyRegistry;
import com.united.company.util.AppConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(AppConstant.ROOT_URI_V1)
public interface ApiContract {
	
	@ApiOperation(value ="Register a new Company", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerNewCompany(@RequestBody CompanyRegistry companyStockDetails);
	
	@ApiOperation(value ="Fetches Company details", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@GetMapping(path = "/info/{companycode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCompanyDetails(@PathVariable Long companyCode);
	
	@ApiOperation(value ="Fetches all the company details", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@PutMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCompanyDetails();
	
	@ApiOperation(value ="Deletes a Company", hidden = false)
	@ApiResponses(value = { @ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Bad request"),
			@ApiResponse(code = 401, message="Not authorized to view the resource"),
			@ApiResponse(code = 403, message="Resource trying to access is forbidden"),
			@ApiResponse(code = 404, message="The resource trying to reach is not found"),
			@ApiResponse(code = 415, message="The content is unsupported"),
			@ApiResponse(code = 500, message="An unexpected error has occured")})
	@DeleteMapping(path = "/delete/{companycode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCompanyDetails(@PathVariable Long companyCode);
	
}
