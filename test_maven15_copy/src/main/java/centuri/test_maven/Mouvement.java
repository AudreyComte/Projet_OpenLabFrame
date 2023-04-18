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
	static final String type_of_coordinate = "G90";
	Arduino myArduino;

	
	public Mouvement(double coordinate_x, double coordinate_y, Arduino myArduino) {
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
		this.myArduino = new Arduino();
	}
	

	
	@Override
	public boolean Do() throws SerialException, IOException, InterruptedException {
		
		boolean ok = false;

		// command sent to arduino
		
		
		System.out.println(coordinate_x + " mm movement in x and " + coordinate_y + " mm movement in y \r\n");

		//ArrayList data = new ArrayList();
		String Info = (type_of_coordinate + "G0X" + coordinate_x + "Y" + coordinate_y + "\n");
		//data.add("G0\n");

		System.out.println("Mouvement \r\n");

		// send to arduino
					try {
						myArduino.Go(Info);
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
			System.out.println("OK : the move has been made \r\n\n");
		} else {
			System.out.println("Error : arduino didn't receive movement information \r\n\n");
		}

	}

}