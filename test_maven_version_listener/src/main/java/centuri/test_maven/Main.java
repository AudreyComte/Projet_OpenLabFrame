package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Main {

	public static void main(String[] args) throws SerialException, IOException, InterruptedException {
		
			ArrayList<Event> data= new ArrayList();
			data.add(new Initialisation());
			data.add(new Absolue());
			data.add(new Mouvement("100","50"));
			data.add(new Picture(5000,800,1240));
			data.add(new Mouvement("20","10"));
			data.add(new Pause(10000));
			data.add(new Mouvement("100","50"));
			data.add(new Picture(5000,1240,800));
			
			Protocol protocol = new Protocol(data);
			
			
			ArduinoTest3 essai3 = new ArduinoTest3(protocol);
			
			essai3.Start_arduino();
			essai3.Go_arduino();
		
		
	}

}
