package vn.topica.itlab.thread;

import java.util.Random;

public class Thread1 extends Thread{
	final int MAX_LAMP_CREAT = 20;   
	@Override
	public void run() {
		System.out.println("Thread1 start running...");

		try {
			Random random = new Random();
			boolean j=true;
			//thread in while loop forever
			while (j) {
				int numLamp = random.nextInt(MAX_LAMP_CREAT)+1;
				for (int i = 0; i < numLamp; i++) {
					Lamp lamp = new Lamp();
					int ran =random.nextInt(3);
					//random value of status is ON, OFF or REPAIR
					lamp.randomLampStatus(ran);
					//add lamp to store
					Store.getStore().add(lamp);
					System.out.println("Thread1 add to store " + lamp.toString());
					Thread.sleep(100);		
				}
			}
			System.out.println("Thread1 end.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
