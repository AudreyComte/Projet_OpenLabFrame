package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Syringue_Injection extends Event {

	int volum;
	int round;
	Arduino2 myArduino2;

	public Syringue_Injection(int volum, Arduino2 myArduino2) {
		this.volum = volum;
		this.myArduino2 = myArduino2;
	}

	@Override
	public boolean Do() {
		boolean ok = false;
		
		round = volum *1 ;

		// command sent to arduino
		
		System.out.println(volum +" ml injected  \r\n");

		// Data list
		ArrayList data = new ArrayList();
		data.add("$X\n");
		data.add("G92X0\n");
		data.add("G0X"+round+"\n");

		System.out.println("Injection \r\n");

		// send to arduino
		for (int i = 0; i < data.size(); i++) {
			try {
				myArduino2.Go(data.get(i).toString());
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
			ok = myArduino2.test_$G();
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
			System.out.println("OK : "+ volum + " ml injected \r\n\n");
		}
		else {
			System.out.println("Error : no injection \r\n\n");	
		}
	}

}
