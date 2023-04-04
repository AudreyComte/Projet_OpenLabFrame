package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

import com.fazecast.jSerialComm.SerialPort;

public class Initialisation extends Event {

	Arduino myArduino;

	public Initialisation(Arduino myArduino) {
		this.myArduino = new Arduino();
	}

	@Override
	public boolean Do() {

		// Data list
		ArrayList data = new ArrayList();
		data.add("$H\n");
		data.add("G92x0y0z0\n");

		System.out.println("Start inialization \r\n");

		// send to arduino
		for (int i = 0; i < data.size(); i++) {
			try {
				myArduino.Go(data.get(i).toString());
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		// check $G test
				try {
					myArduino.test_$G();
				} catch (SerialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return true;
	}

	@Override
	public void Info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : end of the inialization \r\n\n");
		} else {
			System.out.println("Error : arduino didn't receive initialization information \r\n\n");
		}
	}

}
