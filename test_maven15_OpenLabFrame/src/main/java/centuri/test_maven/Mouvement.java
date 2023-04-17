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
	int time;
	static final String type_of_coordinate = "G90";
	Arduino myArduino;

	
	public Mouvement(double coordinate_x, double coordinate_y, double coordinate_z, int time, Arduino myArduino) {
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
		this.coordinate_z = coordinate_z;
		this.time=time;
		this.myArduino = new Arduino();
	}

	
	@Override
	public boolean Do() {
		
		boolean ok = false;

		// command sent to arduino
		String info = type_of_coordinate + "G0X" + coordinate_x + "Y" + coordinate_y + "Z-" + coordinate_z + "\n";
		
		System.out.println(coordinate_x + " mm movement in x and " + coordinate_y + " mm movement in y \r\n");

		// send to arduino
		try {
			myArduino.Go(info, time);
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
		
		// check $G test
		try {
			ok = myArduino.test_$G();
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