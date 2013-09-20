package com.sanjeeb.inca;

public class SelectionParam {
	int id;
	DeliveryMode deliveryMode;
	Boolean isHazardous;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DeliveryMode getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(DeliveryMode deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public Boolean getIsHazardous() {
		return isHazardous;
	}
	public void setIsHazardous(Boolean isHazardous) {
		this.isHazardous = isHazardous;
	}
}