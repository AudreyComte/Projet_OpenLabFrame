package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Absolue extends Event{

	
	@Override
	public void Do() {
		System.out.println("Coordonées absolue");
	}

	@Override
	public String Info() {
		return ("G90");
	}


}