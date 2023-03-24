package centuri.test_maven;

import java.util.ArrayList;

public class Protocol {
	ArrayList<Event> protocol;
	
	public Protocol(ArrayList<Event> protocol) {
		this.protocol = protocol;
	}
	
	public ArrayList<Event> getProtocol(){
		return this.protocol;
	}
	
	public void go() {
		for (Event event : this.protocol) 
			event.Do();
	}
	
	
	
}
