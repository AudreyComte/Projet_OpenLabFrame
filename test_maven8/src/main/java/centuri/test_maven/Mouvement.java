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
		Arduino arduino = new Arduino();
		   
		   OutputStream output_stream  = arduino.getSerialPort().getOutputStream();
		   
		   DataOutputStream data_output = new DataOutputStream(output_stream);
		   
		    //Thread sleeping
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//info
			String info = "G0X" + coordinate_x + "Y" + "coordinate_y" + "\n";
			
			//Send info to Arduino
			try {
				data_output.write(info.getBytes("UTF-8"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//Thread sleeping
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Close to OutputStream
			try {
				output_stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public String Info() {
		return ("G0x" + coordinate_x +"y"+ coordinate_y);
	}


}
