package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public interface Arduino2 {
	
	default public void doArduino() {
		
		static SerialPort serial_port;
		
		serial_port = SerialPort.getCommPort("ttyACM0");
		
		OutputStream output_stream  = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		
		String info;
		Thread.sleep(1000);
		info = info + "\n";
		System.out.println(info);
		data_output.write(info.getBytes("UTF-8"));
	}

}
