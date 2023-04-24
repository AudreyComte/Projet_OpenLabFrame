package centuri.test_maven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Loading_protocol {

	ArrayList<Event> data;
	int number_repetition;
	int time;
	
	
	public Loading_protocol (int number_repetition, int time, ArrayList<Event> data) {
		this.number_repetition = number_repetition;
		this.time = time;
		this.data = data;
		
	}
	
	

	public boolean timer() {
		
		boolean timer = false;
		
		int counter = 0;
		
		while(!timer) {
			
			LocalTime  time0 = LocalTime.now();

			event_go(data);
			
			LocalTime  time1 = LocalTime.now();
			
			Duration  duration = Duration.between(time0, time1);
			
			long duration_sec = duration.getSeconds();
			
			int duration_sec_int = (int) duration_sec;
			
			int delay = (time*60) - duration_sec_int;
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			counter++;	
			
			if (counter != number_repetition) {
				timer = true;
			}
			
		}
		
		return timer;
	
	}

	
	// méthode event_go (ArrayList<Event> data) :
	// Cette méthode prend en argument une liste d'objet de la classe Event et renvoie un boolean ok
	// Pour chaque élement de cette liste la méthode Do() de la chaque object est appelé.
	// Le boolean ok prend la valeur du résultat de la méthode Do()
	// Si ok est égal à false alors le msssage "Warning : Error !3 s'affiche et la bouble for est arrêté
	// Si non la méthode Info(boolean ok) de chaque object est appelé avec comme argument la valeur du boolean ok et la boucle continue
	
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

}
