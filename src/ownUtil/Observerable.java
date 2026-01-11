package ownUtil;

public interface Observerable 
{
	void addObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObservers();
}
