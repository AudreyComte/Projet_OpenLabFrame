package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Mouvement extends Event{

	double coordinate_x;
	double coordinate_y;
	static final String type_of_coordinate = "G90";
	
	public Mouvement (double coordinate_x,double coordinate_y){
		this.coordinate_x= coordinate_x;
		this.coordinate_y= coordinate_y;
	}
	

	@Override
	public boolean Do() {
		
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
			String info = type_of_coordinate + "G0X" + coordinate_x + "Y" + "coordinate_y" + "\n";
			
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
			
		return true;
	}

	
	@Override
	public void Info() {
		if(Do()== true) {
			System.out.println(coordinate_x +" mm movement in x and " + coordinate_y + " mm movement in y");
		}
		else {
			System.out.println("Error : arduino didn't receive movement information");
		}
			
	}

}
