package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public abstract class Event {
	
	protected char[] toString;

	public abstract boolean Do();
	
	public abstract void Info(boolean ok);
	
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