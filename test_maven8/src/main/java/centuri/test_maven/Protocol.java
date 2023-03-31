package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Protocol  {
	ArrayList<Event> protocol;
	Arduino myArduino = new Arduino();
	
	public Protocol(ArrayList<Event> protocol) {
		this.protocol = protocol;
	}
	
	public ArrayList<Event> getProtocol(){
		return this.protocol;
	}
	
	public void event() {
		for (Event event : this.protocol) {
			
			myArduino.input();
			event.Info();
		
	}
		
	try {
		Thread.sleep(2000);
		myArduino.Close_arduino();
	} catch (SerialException | IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
