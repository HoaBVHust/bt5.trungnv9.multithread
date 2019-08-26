package vn.topica.itlab.thread;

import java.util.Random;
public class Thread3 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread3 start running...");
		try {
			Store store = Store.getStore();
			Trash trash = Trash.getTrash();
			for (int index = 0; index < trash.size()+1; index++) {
				/* 
				 * when trash is approved to the final element,
				 * so it wait the size of trash grow so the loop never end.
				 */
				if(index==trash.size()) {
					Thread.sleep(100);
					index--;
					System.out.print("Trash:"+trash.toString()+"\n");
					continue;
				}
				//if status is repair, we remove it from trash and add to store
				if(trash.get(index).status==Status.REPAIR) {
					Lamp lampRepair = trash.remove(index);
					System.out.println("Thread3 remove lamprepair from trash " + lampRepair.toString());
					store.add(lampRepair);
					System.out.println("Thread3 add lamprepair  to store " + lampRepair.toString());			
					index--;	
				}
				else
				//if status is off, we remove it from trash or revert it to become repair lamp and add to store randomly
				if(trash.get(index).status==Status.OFF) {
					Random random = new Random();
					if(random.nextBoolean()) {
						Lamp lampOff =trash.remove(index);
						System.out.println("Thread3 remove lampoff from trash " + lampOff.toString());	
						index--;	
					}
					else {
						trash.get(index).status=Status.REPAIR;
						Lamp lampOff = trash.get(index);
						store.add(lampOff);
						System.out.println("Thread3 add lampoff was converted lamprepair to store " + lampOff.toString());
					}
				}
				System.out.print(trash.toString()+"\n");
				
			}
			Thread.sleep(200);
			System.out.print(trash.toString()+"\n");
			System.out.println("Thread3 end.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
