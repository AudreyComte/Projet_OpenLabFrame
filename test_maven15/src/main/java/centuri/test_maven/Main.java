package centuri.test_maven;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

public class Main {

	public static void main(String[] args) {

		Arduino arduino = new Arduino();

		ArrayList<Event> data = new ArrayList();
		data.add(new Initialisation(arduino));
		data.add(new Mouvement(100.0, 50.0, arduino));
		data.add(new Picture(1000,800,1240));
		data.add(new Pause(10000));
		//data.add(new Mouvement(500000.0, 10.0, arduino));
		data.add(new Video (30000));
		data.add(new Mouvement(50.0, 10.0, arduino));

		arduino.Start();
		
		arduino.event_go(data);

		arduino.Close();

	}

}