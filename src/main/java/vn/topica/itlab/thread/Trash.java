package vn.topica.itlab.thread;


public class Trash extends StoreOrTrash{
	//make the constructor private so that this class can not be instantiated
		private Trash() {}
		//create an object of Store
		private static Trash trash = new Trash();
		//get the only object available
		public static Trash getTrash() {
			return trash;
		}
}
