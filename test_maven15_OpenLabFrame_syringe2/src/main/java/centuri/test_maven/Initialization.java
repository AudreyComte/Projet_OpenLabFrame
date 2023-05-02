package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

import com.fazecast.jSerialComm.SerialPort;

public class Initialization extends Event {

	Arduino myArduino;

	public Initialization(Arduino myArduino) {
		this.myArduino = myArduino;
	}
    
	// Méthode Do() : 
	// Instancie une liste de string et ajoute à cette liste les commandes g_code $H et G92x0y0z0. 
	// Cette liste est parcourue et la méthode Go() de la classe Arduino est exécuté pour chaque élément de la liste. 
	// Lorsque que la liste a fini d'être parcourue la méthode test_$G() de la classe Arduino est lancé. Si arduino renvoie bien "[GC:" alors la méthode test_$G renvoie true aussi non false.
	// La méthode Do() renvoie le boolean de la méthode test_$G().
	
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
	
	// Méthode Info(boolean ok) :
	// Prend en argument un boolean 
	// Si ce boolean est égal à true alors la méthode Info(boolean ok) écrit "Ok" aussi non le méthode écrit "Error"
	
	@Override
	public void Info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : end of the inialization \r\n\n");
		} else {
			System.out.println("Error : arduino didn't receive initialization information \r\n\n");
		}
	}

}