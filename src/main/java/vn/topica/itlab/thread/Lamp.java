package vn.topica.itlab.thread;

enum Status{ON,OFF,REPAIR};
public class Lamp {
	static int growIndex=0;//help the index increase itself
	public Status status;
	int index;
	public Lamp() {
		index = ++growIndex;
	}
	
	//Override toString() method to show value of properties 
	@Override
	public String toString() {
		return "status: "+status+",index: "+index;
	}
	/*
	 * random status of lamp by ran
	 * if ran = 2, status is ON or OFF
	 * if ran = 3, status is ON,OFF or REPAIR
	 */
	public void randomLampStatus(int ran) {
		this.status= Status.values()[ran];
	}
}
