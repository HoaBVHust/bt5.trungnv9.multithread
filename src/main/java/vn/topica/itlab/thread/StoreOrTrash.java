package vn.topica.itlab.thread;

import java.util.LinkedList;

public class StoreOrTrash extends LinkedList<Lamp>{
	@Override
	public Lamp get(int index) {
		// TODO Auto-generated method stub
		return super.get(index);
	}
	@Override
	public synchronized boolean add(Lamp e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}
	@Override
	public synchronized Lamp remove(int index) {
		// TODO Auto-generated method stub
		return super.remove(index);
	}
	@Override
	public synchronized String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
