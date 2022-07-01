package com.united.company.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.united.company.entity.Company;

@Repository
public interface AppRepository extends MongoRepository<Company, String>{

	Company findByCompanyCode(Long companyCode);
	
	Long deleteByCompanyCode(Long companyCode);

}
