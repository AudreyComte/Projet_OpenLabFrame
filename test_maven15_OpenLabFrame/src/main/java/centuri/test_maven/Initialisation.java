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
		this.myArduino = new Arduino("ttyAMA1");
	}

	@Override
	public boolean Do() {
		
		boolean ok = false;

		// Data list
		ArrayList data = new ArrayList();
		data.add("$H\n");
		data.add("G92x0y0z0\n");
		data.add("G4 P1\n");

		System.out.println("Start inialization \r\n");

		// send to arduino
				for (int i = 0; i < data.size(); i++) {
						myArduino.Go(data.get(i).toString());
				}
				
		
		// check $G test		
		ok = myArduino.test_$G();
				
		
		return ok;
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