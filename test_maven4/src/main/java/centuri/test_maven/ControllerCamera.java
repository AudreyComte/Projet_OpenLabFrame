package centuri.test_maven;

public class ControllerCamera implements Runnable  {

	@Override
	public void run() {
		Camera camera = new Camera();
		ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "raspistill -p '800,200,1000,1000' -t 0");

        try {
            camera.callBash(processBuilder);
        } catch (Exception f) {
        	System.out.println("Camera: Error while taking picture: " + f.getMessage());
            //logError("Camera: Error while taking picture: " + e.getMessage());
        }

		
	}

}
