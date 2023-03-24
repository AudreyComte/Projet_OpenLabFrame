package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class Initialisation extends Event{

	
	
	static SerialPort serial_port = SerialPort.getCommPort("ttyACM0");
	
	OutputStream output_stream  = serial_port.getOutputStream();
	DataOutputStream data_output = new DataOutputStream(output_stream);
	
	
	@Override
	public void Do() {
		ArrayList data = new ArrayList();
		data.add("G92x0y0z0");
		data.add("G90");
		
		for (int i = 0; i < data.size(); i ++) {
			String info = (String) data.get(i);
			try {
				Thread.sleep(2000);
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
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	


}
