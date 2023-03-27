package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class Initialisation extends Event{


	
	@Override
	public void Do() {
		System.out.println("Inialisation");
		
	}


	@Override
	public String Info() {
		return "G92x0y0z0";
	}
	


}
