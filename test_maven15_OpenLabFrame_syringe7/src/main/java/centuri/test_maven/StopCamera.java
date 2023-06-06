package centuri.test_maven;

public class StopCamera implements Runnable  {

	@Override
	public void run() {
		Camera camera = new Camera();
		ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "kill -9 $(pidof raspistill)");

        try {
            camera.callBash(processBuilder);
        } catch (Exception f) {
        	System.out.println("Camera: Error : " + f.getMessage());
            //logError("Camera: Error while taking picture: " + e.getMessage());
        }

        
	}

}