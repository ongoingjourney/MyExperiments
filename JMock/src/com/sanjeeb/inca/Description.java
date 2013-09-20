package com.sanjeeb.inca;

public class Description {
	String condition;
	int shippingWeightInLb;
	String shippedFrom;
	boolean isHazardous;
	DeliveryMode deliveryMode;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getShippingWeightInLb() {
		return shippingWeightInLb;
	}
	public void setShippingWeightInLb(int shippingWeightInLb) {
		this.shippingWeightInLb = shippingWeightInLb;
	}
	public String getShippedFrom() {
		return shippedFrom;
	}
	public void setShippedFrom(String shippedFrom) {
		this.shippedFrom = shippedFrom;
	}
	public boolean isHazardous() {
		return isHazardous;
	}
	public void setHazardous(boolean isHazardous) {
		this.isHazardous = isHazardous;
	}
	public DeliveryMode getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(DeliveryMode deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
}