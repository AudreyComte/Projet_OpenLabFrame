package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

import com.fazecast.jSerialComm.SerialPort;

public class Initialisation extends Event{

	
	@Override
	public boolean Do() {
		
		   //Arduino arduino = new Arduino();
		   
		   //Open arduino serial port 
		   //try {
			//arduino.Start_arduino();
		  // } catch (SerialException | IOException | InterruptedException e2) {
			//e2.printStackTrace();
		  // }
		   
		   // Creation of OuputStream
		   Arduino arduino = new Arduino();
		   OutputStream output_stream  = arduino.getSerialPort().getOutputStream();
		   DataOutputStream data_output = new DataOutputStream(output_stream);
		   
		   // Data list
		   ArrayList data = new ArrayList();
		   data.add("$H\n");
		   data.add("G92x0y0z0\n");
		   
		   System.out.println("Start inialization");
		   
		   //for loop
		   for (int i =0; i<data.size(); i++) {
			   
			    //Thread sleeping
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//Info
				String info = data.get(i).toString();
				
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
		if(Do() == true) {
			System.out.println("End of the inialization");
		}
		else {
			System.out.println("Error : arduino didn't receive initialization information");
		}
	}
	
	

}
