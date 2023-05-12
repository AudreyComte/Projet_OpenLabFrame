package centuri.test_maven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Protocol implements Runnable {

	ArrayList<Event> protocol;
	int number_repetition;
	long time;
	volatile boolean timer;
	volatile boolean ok;
	volatile boolean stop;

	public Protocol(ArrayList<Event> protocol) {
		this.protocol = protocol;
	}
	
	public void set_protocol(ArrayList<Event> protocol) {
		this.protocol = protocol;
	}
	
	public ArrayList<Event> get_protocol() {
		return this.protocol;
	}

	public void set_number_repetition(int number_repetition) {
		this.number_repetition = number_repetition;
	}

	public int get_number_repetition() {
		return this.number_repetition;
	}

	public void set_time(long time) {
		this.time = time;
	}

	public long get_time() {
		return this.time;
	}


	public void set_pause(boolean stop) {
		this.stop = stop;
	}

	// méthode event_go (ArrayList<Event> data) :
	// Cette méthode prend en argument une liste d'objet de la classe Event et
	// renvoie un boolean ok
	// Pour chaque élement de cette liste la méthode Do() de la chaque object est
	// appelé.
	// Le boolean ok prend la valeur du résultat de la méthode Do()
	// Si ok est égal à false alors le msssage "Warning : Error !3 s'affiche et la
	// bouble for est arrêté
	// Si non la méthode Info(boolean ok) de chaque object est appelé avec comme
	// argument la valeur du boolean ok et la boucle continue

	
	public boolean event_go(ArrayList<Event> data) {
		
		stop = false;
		
		ok = false;
		
		while(!stop) {
			
			for (Event event : data) {
				
				ok = event.toDo();
				
				if(stop==true) {
					System.out.println("Stop !");
					break;
				}
				
				if (!ok) {
					System.out.println("WARNING : ERROR !");
					break;
				}
				event.info(ok);

			}
			
			stop=true;
		}
		
	
	return ok;

	}
	

	@Override
	public void run() {

		timer = false;

		int counter = 0;

		while (!timer) {

			LocalTime time0 = LocalTime.now();

			event_go(this.protocol);

			LocalTime time1 = LocalTime.now();

			Duration duration = Duration.between(time1, time0);

			long duration_sec = duration.getSeconds();

			long delay = ((time * 60) - duration_sec) * 1000;

			if (counter < number_repetition - 1) {

				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			counter++;

			if (counter == number_repetition) {
				timer = true;
				System.out.println("End !!");
			}

		}
                                                                                                                                                                                                                                       
	}

	public void stop() {

		ok = false;

		timer = true;
		
		stop = true;

		System.out.println("Interrupt");
	
	}
	
	public static void exporterProtocol (ArrayList<Event> protocol, String name) {
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream objStream = new ObjectOutputStream(file);
            objStream.writeObject(protocol);
            objStream.close();
            file.close();
            System.out.println("The protocol has been exported successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while exporting the protocol: " + e.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Event> importerProtocol (String name) {
        ArrayList<Event> protocol = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream objStream = new ObjectInputStream(file);
            protocol = (ArrayList<Event>) objStream.readObject();
            objStream.close();
            file.close();
            System.out.println("The protocol was successfully imported!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while importing the protocol : " + e.getMessage());
        }
        return protocol;
    }

	
	

}
