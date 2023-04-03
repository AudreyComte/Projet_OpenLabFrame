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
		System.out.println((pause/1000) + " secondes break... \r\n");
		try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return true;
	}


	@Override
	public void Info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : end of the " + (pause/1000) +" secondes break \r\n\n");
		}
		else {
			System.out.println("Error : no break \r\n\n");	
		}
	}

}
