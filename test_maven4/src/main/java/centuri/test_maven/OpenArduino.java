package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class OpenArduino extends Event {
	
	


	@Override
	public void Do()  {
	
			SerialPort serial_port= SerialPort.getCommPort("ttyACM0");
	 				
						
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
			
			serial_port.setBaudRate(115200);
			
			OutputStream output_stream  = serial_port.getOutputStream();
			DataOutputStream data_output = new DataOutputStream(output_stream);
			
			ArrayList start = new ArrayList();
			start.add("$H\n");
			start.add("G92x0y0z0\n");
			start.add("G90\n");
			
			String info;
			for (int i=0 ; i< start.size(); i++) {
				info = start.get(i).toString();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				System.out.println(info);
				
				try {
					data_output.write(info.getBytes("UTF-8"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
			}		
			
	}

}
