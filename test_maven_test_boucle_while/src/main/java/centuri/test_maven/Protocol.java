package centuri.test_maven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Protocol extends Thread {

	ArrayList<String> data;
	int number_repetition;
	volatile boolean timer = false;

	public Protocol(int number_repetition, ArrayList<String> data) {
		this.data = data;
		this.number_repetition = number_repetition;

	}

	public void set_number_repetition(int number_repetition) {
		this.number_repetition = number_repetition;
	}

	public int get_number_repetition() {
		return this.number_repetition;
	}

	public void set_data(ArrayList<String> data) {
		this.data = data;
	}

	public ArrayList<String> get_data(ArrayList<String> data) {
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

	@Override
	public void run() {

		int counter = 0;

		while (!timer) {

			for (int i = 0; i < data.size(); i++) {
				System.out.println("essai " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			counter++;

			if (timer == true) {
				System.out.print("true !!!");

			}

			if (counter == number_repetition) {
				timer = true;
				System.out.println("End !!");
			}

		}

	}

	public void stopThread() {
		timer = true;
		System.out.println("Interrupt");

	}

}
