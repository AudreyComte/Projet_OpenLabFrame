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
	
	static SerialPort serial_port = SerialPort.getCommPort("ttyACM0");
	
	OutputStream output_stream  = serial_port.getOutputStream();
	DataOutputStream data_output = new DataOutputStream(output_stream);

	@Override
	public void Do() {
		String info = "G0" + coordinate_x + coordinate_y;
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
