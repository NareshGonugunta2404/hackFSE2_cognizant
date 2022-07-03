package com.united.stock.resource;

import java.util.List;

import com.united.stock.entity.StockData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDataWithDetail {
	
	private List<StockData> stockDataList;
	
	private double avgOfPrice;

	private double minPrice;
	
	private double maxPrice;
	
}
