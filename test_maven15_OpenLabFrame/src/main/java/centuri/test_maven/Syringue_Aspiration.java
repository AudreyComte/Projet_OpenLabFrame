package centuri.test_maven;

import java.io.IOException;

import javax.sql.rowset.serial.SerialException;

public class Syringue_Aspiration extends Event {

	int volum;
	int round;
	Arduino2 myArduino2;

	public Syringue_Aspiration(int volum, Arduino2 myArduino2) {
		this.volum = volum;
		this.myArduino2 = myArduino2;
	}

	
	@Override
	public boolean Do() {
		boolean ok = false;
		
		round = volum *1 ;

		// command sent to arduino
		String info = "G0X" + round + "\n";
		
		System.out.println(volum +" ml aspirated \r\n");

		// send to arduino
		try {
			myArduino2.Go(info);
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
			System.out.println("OK : "+ volum + " ml aspirated \r\n\n");
		}
		else {
			System.out.println("Error : no aspiration \r\n\n");	
		}
	}

}
