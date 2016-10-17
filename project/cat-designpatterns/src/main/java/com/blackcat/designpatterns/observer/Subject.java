package com.blackcat.designpatterns.observer;

public interface Subject {
	
	public void register(Observer ob);
	
	public void notifyObservers();
	
	public void remove(Observer ob);
}
