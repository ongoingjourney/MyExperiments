package com.sanjeeb.pattern.observer;

import java.util.List;

public interface Observable {
	public void registerObserver(Observer observer);
	public void registerObserver(List<Observer> observers);
	public void removeObserver(Observer observer);
	public void notifyObservers(Object key);
	public void update(Object key, Object val);
}
