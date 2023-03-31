package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Main {

	public static void main(String[] args) throws SerialException, IOException, InterruptedException {
		
			ArrayList<Event> data= new ArrayList();
			data.add(new Initialisation());
			data.add(new Mouvement(20.0,10.0));
			data.add(new Pause(10000));
			//data.add(new Picture(5000,800,1240));
			//data.add(new Pause(10000));
			
			Arduino arduino = new Arduino();
			
			arduino.Start_arduino();
			arduino.input();
		
			for (Event event : data) {
				event.Do();	
				event.Info();
				arduino.input();
				}
				
			arduino.Close_arduino();

	}
}
