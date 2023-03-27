package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Pause extends Event{
	String pause;
	
	public Pause (String pause) {
		this.pause = pause;
	}
	
	
	@Override
	public void Do() {
		System.out.println("Pause de " + pause);
	}


	@Override
	public String Info() {
		return ("G4 P" + pause);
	}

}
