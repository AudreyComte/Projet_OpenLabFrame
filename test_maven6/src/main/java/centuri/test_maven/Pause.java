package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Pause extends Event{
	String pause;
	
	public Pause (String pause) {
		this.pause = pause;
	}
	
    static SerialPort serial_port = SerialPort.getCommPort("ttyACM0");
	
	OutputStream output_stream  = serial_port.getOutputStream();
	DataOutputStream data_output = new DataOutputStream(output_stream);
	
	@Override
	public void Do() {
		String info = "G4 P" + pause;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info = info + "\n";
		System.out.println(info);
		try {
			data_output.write(info.getBytes("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
