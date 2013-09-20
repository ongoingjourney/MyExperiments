package com.sanjeeb.inca;

public class PrintProduct {
	private ProductAggregatorService productAggregatorService;
	
	public void printProduct(boolean flag) {
		Product product = productAggregatorService.getProduct(100);
		System.out.println(product);
	}

	public ProductAggregatorService getProductAggregatorService() {
		return productAggregatorService;
	}

	public void setProductAggregatorService(
			ProductAggregatorService productAggregatorService) {
		this.productAggregatorService = productAggregatorService;
	}
}