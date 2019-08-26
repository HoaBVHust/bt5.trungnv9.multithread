package vn.topica.itlab.thread;


public class Thread2exercise1 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread2exercise1 start running...");
		try {
		
			Store store = Store.getStore();
			for (int index = 0; index < store.size()+1; index++) {
				if(index==store.size()) {
					/* 
					 * when store is approved to the final element,
					 * so it wait 500ms and try again, if size of store don't grow,
					 * this is meaning not any lamp which will be add to store,
					 * break the for loop. 
					 */
					Thread.sleep(500);
					if(store.size()==index)break;
					index--;
					continue;
				}
				//if status of lamp is off or repair, remove it from store and add to trash 
				index=store.ifLampStoreNotOn(index,this.getClass().getName());
			}
			Thread.sleep(100);
			System.out.print("Store:"+store.toString()+"\n");
			System.out.println("Thread2exercise1 end.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
