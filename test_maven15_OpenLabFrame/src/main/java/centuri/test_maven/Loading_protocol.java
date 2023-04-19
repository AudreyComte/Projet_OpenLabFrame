package centuri.test_maven;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Loading_protocol {

	ArrayList<Event> data;
	int number_repetition;
	int time;

	
	public void timer(int number_repetition, int time, ArrayList<Event> data) {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			
			int n = 0;

			public void run() {

				n++;

				event_go(data);

				if (n == number_repetition) {
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, time);

	}

	
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
