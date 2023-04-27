package centuri.test_maven;

public class Pause_System implements Runnable{
	
	volatile boolean pause = false;
	
	public Pause_System() {
		
	}
		

	@Override
	public void run() {
		
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Stop");
			
		}
		
	
}
