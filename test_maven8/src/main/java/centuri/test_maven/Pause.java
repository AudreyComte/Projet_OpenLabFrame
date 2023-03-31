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
	public void Do() {
		System.out.println("Pause de " + (pause/1000)+" secondes");
		try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}


	@Override
	public String Info() {
		return ("" );
	}

}
