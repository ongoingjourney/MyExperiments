package com.sanjeeb.pattern.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StockUpdate implements Observable {
	private List<Observer> observers;

	private Map<String, Float> priceMap;

	public StockUpdate() {
		observers = new LinkedList<>();
		priceMap = new HashMap<String, Float>();
	}

	@Override
	public void registerObserver(Observer observer) {
		getObservers().add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		getObservers().remove(observer);
	}

	@Override
	public void notifyObservers(Object key) {
		Iterator<Observer> obIterator = getObservers().iterator();
		while(obIterator.hasNext()) {
			obIterator.next().update(this, key);
		}
	}

	public Map<String, Float> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<String, Float> priceMap) {
		this.priceMap = priceMap;
	}

	@Override
	public void update(Object key, Object val) {
		String ticker;
		Float price;
		try{
			ticker = (String)key;
			price = (Float)val;
		}catch(ClassCastException ex) {
			ex.printStackTrace();
			return;
		}
		if(priceMap.containsKey(key) && priceMap.get(key).equals(val)) {
			return;
		}
		priceMap.put(ticker, price);
		notifyObservers(key);
	}

	@Override
	public void registerObserver(List<Observer> observers) {
		this.getObservers().addAll(observers);
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
}