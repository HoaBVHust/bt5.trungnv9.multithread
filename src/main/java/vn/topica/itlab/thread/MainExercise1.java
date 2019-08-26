package vn.topica.itlab.thread;

public class MainExercise1 {
	public static void main(String[] args) {
		
		Thread1exercise1 thread1exercise1 = new Thread1exercise1();
		Thread2exercise1 thread2exercise1 = new Thread2exercise1();

		thread1exercise1.start();
		thread2exercise1.start();	
	}
}

