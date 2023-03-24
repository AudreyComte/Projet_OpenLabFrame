package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class Input extends Event{


	@Override
	public void Do() {
		
		SerialPort serial_port= SerialPort.getCommPort("ttyACM0");
			
		if(serial_port.openPort()) {
			System.out.println("Successfully open port!");
		}else {
			System.out.println("Failed to open port");
		}
		
		serial_port.setBaudRate(115200);
		
		
		System.out.println("Arduino : ");
		Scanner scanner = new Scanner(serial_port.getInputStream());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(scanner.hasNextLine()) {
		    try {
		        String line = scanner.nextLine();
		        System.out.println("Arduino : " + line);
		    } catch(Exception e) {
		    	e.printStackTrace();
		    }
		}
		scanner.close();            	
	}
			

}
