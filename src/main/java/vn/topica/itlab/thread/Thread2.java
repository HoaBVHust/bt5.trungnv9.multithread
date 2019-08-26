package vn.topica.itlab.thread;

public class Thread2 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread2 start running...");
		try {	
			Store store = Store.getStore();
			for (int index = 0; index < store.size()+1; index++) {
				if(index==store.size()) {
					/* 
					 * when store is approved to the final element,
					 * so it wait the size of trash grow,so the loop never end.
					 */
					Thread.sleep(100);
					System.out.print("Store:"+store.toString()+"\n");
					index--;
					continue;
				}
				//if status of lamp is off or repair, remove it from store and add to trash 
				index=store.ifLampStoreNotOn(index,this.getClass().getName());
			}
			Thread.sleep(200);	
			System.out.println("Thread2 end.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
