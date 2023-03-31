package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Pause extends Event{
int pause;
	
	public Pause (int pause) {
		this.pause = pause;
	}
	
	
	@Override
	public boolean Do() {
		System.out.println((pause/1000) + " secondes break...");
		try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return true;
	}


	@Override
	public void Info() {
		if (Do() == true) {
			System.out.println("End of the " + (pause/1000) +" secondes break");
		}
		else {
			System.out.println("Error : no break");	
		}
	}

}
