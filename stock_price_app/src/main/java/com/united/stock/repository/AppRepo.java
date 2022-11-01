package com.united.stock.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.united.stock.entity.StockData;

@Repository
public interface AppRepo extends MongoRepository<StockData, Long> {

	
	//@Query(value="SELECT s.* FROM stock_data s WHERE company_code = :companyCode AND DATE(current_date_and_time) BETWEEN :startDate AND :endDate", nativeQuery = true)
	Collection<StockData> findByCompanyCodeAndCurrentDateTimeBetween(String companyCode, LocalDate startDate, LocalDate endDate);
	
	//@Modifying
	@Transactional
	//@Query(value="DELETE FROM stock_data s WHERE company_code = :companyCode", nativeQuery = true)
	void deleteByCompanyCode(String companyCode);
	
	Collection<StockData> findByCompanyCode(String companyCode);
	
}
