package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class OpenArduino extends Event {
	
	String record_Time;
	
	public OpenArduino (String record_Time){
		this.record_Time =record_Time;
	}
	

	@Override
	public void Do()  {
	
		SerialPort serial_port= SerialPort.getCommPort("ttyACM0");
	 				
						
				if(serial_port.openPort()) {
					System.out.println("Successfully open port!");
				}else {
					System.out.println("Failed to open port");
				}
			
			serial_port.setBaudRate(115200);
	}

}
