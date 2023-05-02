package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

import com.fazecast.jSerialComm.SerialPort;

public class Mouvement extends Event {

	
	double coordinate_x;
	double coordinate_y;
	double coordinate_z;
	static final String type_of_coordinate = "G90";
	Arduino myArduino;

	
	public Mouvement(double coordinate_x, double coordinate_y, double coordinate_z, Arduino myArduino) {
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
		this.coordinate_z = coordinate_z;
		this.myArduino = myArduino;
	}

	
	@Override
	public boolean Do() {
		
		boolean ok = false;

		// command sent to arduino
		
		ArrayList data = new ArrayList();
		data.add(type_of_coordinate + "G0X" + coordinate_x + "Y" + coordinate_y + "Z-" + coordinate_z + "\n");
		data.add("G4 P1\n");
		
		System.out.println(coordinate_x + " mm movement in x and " + coordinate_y + " mm movement in y \r\n");


		// send to arduino
		for (int i = 0; i < data.size(); i++) {
				myArduino.go(data.get(i).toString());
		}
		
		
		// check $G test
		
		ok = myArduino.test_$G();
		
		
		return ok;
		
		}
	
	

	@Override
	public void Info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : the move has been made \r\n\n");
		} else {
			System.out.println("Error : arduino didn't receive movement information \r\n\n");
		}

	}

}