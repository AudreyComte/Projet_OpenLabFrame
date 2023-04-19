package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Syringue_Aspiration extends Event {

	int volum;
	Arduino myArduino;

	public Syringue_Aspiration(int volum, Arduino myArduino) {
		this.volum = volum;
		this.myArduino = myArduino;
	}
	
	
	@Override
	public boolean Do() {
		
		boolean ok = false;

		// Data list
		ArrayList data = new ArrayList();
		data.add("$X\n");
		data.add("G92X0\n");
		data.add("G0X" + volum + "\n");
		data.add("G4 P1\n");

		System.out.println(volum + " ml aspirated  \r\n");

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
			System.out.println("OK : " + volum + " ml aspirated \r\n\n");
		} else {
			System.out.println("Error : no aspiration \r\n\n");
		}
	}

}
