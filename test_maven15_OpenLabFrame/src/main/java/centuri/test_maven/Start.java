package centuri.test_maven;

import java.util.ArrayList;

public class Start {
	
	
public boolean event_go(ArrayList<Event> data) {
		
		boolean ok = false;
	
		for (Event event : data) {
			ok = event.Do();
			if (!ok){
				System.out.println("WARNING : ERROR !");
				break;
			}
			event.Info(ok);
		}
		
		return ok;
		
	}

}
