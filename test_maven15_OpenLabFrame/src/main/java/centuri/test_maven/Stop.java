package centuri.test_maven;

public class Stop implements Runnable  {

	@Override
	public void run() {
		Camera camera = new Camera();
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", "kill -9 $(pidof raspistill raspivid)");
		try {
			camera.callBash(processBuilder);
		} catch (Exception f) {
			System.out.println("Camera: Error : " + f.getMessage());
			// logError("Camera: Error while taking picture: " + e.getMessage());
		}
	}

}
