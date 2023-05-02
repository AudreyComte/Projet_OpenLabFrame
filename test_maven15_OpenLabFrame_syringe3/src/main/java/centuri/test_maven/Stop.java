package centuri.test_maven;

public class Stop implements Runnable  {
	
	Camera myCamera;
	
	public Stop (Camera myCamera) {
		this.myCamera = myCamera;
	}

	@Override
	public void run() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", "kill -9 $(pidof raspistill raspivid)");
		try {
			myCamera.callBash(processBuilder);
		} catch (Exception f) {
			System.out.println("Camera: Error : " + f.getMessage());
			// logError("Camera: Error while taking picture: " + e.getMessage());
		}
	}

}
