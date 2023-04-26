package centuri.test_maven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Loading_protocol implements Runnable {

	ArrayList<Event> data;
	int number_repetition;
	long time;
	boolean timer;

	public Loading_protocol() {

	}
	
	public void set_number_repetition (int number_repetition) {
		this.number_repetition = number_repetition;
	}
	    
	public int get_number_repetition () {
		return this.number_repetition;
	}
	
	public void set_time (long time) {
		this.time = time;
	}
	    
	public long get_time () {
		return this.time;
	}
	
	public void set_data (ArrayList<Event> data) {
		this.data = data;
	}
	    
	public ArrayList<Event> get_data (ArrayList<Event> data) {
		return this.data;
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

		boolean ok = false;

		for (Event event : data) {
			ok = event.Do();
			if (!ok) {
				System.out.println("WARNING : ERROR !");
				break;
			}
			event.Info(ok);
		}

		return ok;

	}


	@Override
	public void run() {

		timer = false;

		int counter = 0;

		while (!timer) {

			LocalTime time0 = LocalTime.now();

			event_go(data);

			LocalTime time1 = LocalTime.now();

			Duration duration = Duration.between(time1, time0);

			long duration_sec = duration.getSeconds();

			long delay = ((time * 60) - duration_sec)*1000;
			
			if(counter < number_repetition-1) {

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
			}

		}
		
	}
	
	
	public void stop(){
		
		timer = true;
		
	}
	
	
		
	
	

}
