package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Syringe extends Event {

	int volum;
	Arduino myArduino;

	public Syringe(int volum, Arduino myArduino) {
		this.volum = volum;
		this.myArduino = myArduino;
	}

	@Override
	public boolean toDo() {
		
		boolean ok = false;

		// Data list
		ArrayList data = new ArrayList();
		data.add("$X\n");
		data.add("G92X0\n");
		data.add("G0X" + volum + "\n");
		data.add("G4 P1\n");

		System.out.println(volum + " ml \r\n");

		// send to arduino
		for (int i = 0; i < data.size(); i++) {
			myArduino.go(data.get(i).toString());
		}

		// check $G test
		ok = myArduino.test_$G();

		return ok;
	}


	@Override
	public void info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : "+ volum + " ml \r\n\n");
		}
		else {
			System.out.println("Error : no injection or aspiration \r\n\n");	
		}
	}

}