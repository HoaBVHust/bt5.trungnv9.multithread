package vn.topica.itlab.thread;

public class Store extends StoreOrTrash{
	//make the constructor private so that this class can not be instantiated
	private Store() {}
	//create an object of Store
	private static Store store = new Store();
	//get the only object available
	public static Store getStore() {
		return store;
	}
	//if status of lamp is off or repair, remove it from store and add to trash 
	public int ifLampStoreNotOn(int index,String nameThread) {
		if(Store.getStore().get(index).status!=Status.ON) {
			Lamp lamp = store.remove(index);
			System.out.println(nameThread+" remove from store " + lamp.toString());
			Trash.getTrash().add(lamp);
			return index-1;	
		}
		return index;
	}
}
