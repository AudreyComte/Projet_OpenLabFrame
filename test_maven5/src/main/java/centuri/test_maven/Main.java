package centuri.test_maven;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		OpenArduino start1=new OpenArduino();
		Thread t1 = new Thread(start1);
		t1.start();
		
		Mouvement m1= new Mouvement("20.0","20.0");
		Thread t2 = new Thread(m1);
		t2.start();	
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Picture pic = new Picture();
		Thread t3 = new Thread(pic);
		t3.start();	
		
		Mouvement m2= new Mouvement("40.0","40.0");
		Thread t4 = new Thread(m2);
		t4.start();	
		
		
		
		
	}

}
