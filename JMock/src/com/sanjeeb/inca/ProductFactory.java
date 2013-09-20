package com.sanjeeb.inca;

public class ProductFactory {
	public static IncaProduct getProduct(int productNum){
		IncaProduct product = new IncaProduct();
		product.setId(productNum);
		product.setName(productNum + " - product");
		product.setOffer("Free item");
		product.setPrice(22.33F);
		product.setDescription(new Description(){
			{
				setCondition("wrecked");
				setCondition("Brand new");
				setHazardous(true);
				setShippedFrom("Hombok");
				setShippingWeightInLb(1222);
				setDeliveryMode(DeliveryMode.PostOffice);
			}
		});

		return product;
	}
}