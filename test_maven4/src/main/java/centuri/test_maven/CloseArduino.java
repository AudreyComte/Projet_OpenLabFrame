package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class CloseArduino extends Event {


	@Override
	public void Do()  {
	
		SerialPort serial_port= SerialPort.getCommPort("ttyACM0");
		serial_port.closePort();
		System.out.println("Successfully close port!");	
		
	}

}
