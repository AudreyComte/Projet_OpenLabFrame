package centuri.test_maven;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Event> protocol = new ArrayList<Event>();
		
		
		protocol.add(new OpenArduino());
		
		protocol.add(new Mouvement("2.0","2.0"));
		
		protocol.add(new Pause("10"));
		
		protocol.add(new Picture("5000","800","1240"));
		
		protocol.add(new CloseArduino());
		
		for (Event event : protocol)
			event.Do();

	}

}
