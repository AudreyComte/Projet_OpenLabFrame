package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Mouvement extends Event{

	String coordinate_x;
	String coordinate_y;
	
	public Mouvement (String coordinate_x,String coordinate_y){
		this.coordinate_x= coordinate_x;
		this.coordinate_y= coordinate_y;
		
	}
	

	@Override
	public void Do() {
		System.out.println("Mouvement de " + coordinate_x +" en x et de " + coordinate_y + " en y");
	}

	@Override
	public String Info() {
		return ("G0x" + coordinate_x +"y"+ coordinate_y);
	}


}
