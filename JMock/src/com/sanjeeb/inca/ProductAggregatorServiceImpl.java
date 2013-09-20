package com.sanjeeb.inca;

public class ProductAggregatorServiceImpl implements ProductAggregatorService {

	@Override
	public Product getProduct(int sku) {
		return ProductFactory.getProduct(sku);
	}
}
