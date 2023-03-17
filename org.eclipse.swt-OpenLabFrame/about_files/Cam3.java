package about_files;

import about_files.Camera;

public class Cam3 {
	
	public static void main(String[] args) throws InterruptedException {
	
	System.out.println("Initializing the camera");
	Camera camera = new Camera();

	System.out.println("Taking a default picture");
	camera.takeStill();

	System.out.println("Taking a pic with different parameters");
	var config = new Camera.PicConfig.Builder().outputPath("/home/Centuri/Images")
			.delay(3000)
			.disablePreview(true)
			.encoding(Camera.PicEncoding.PNG)
			.useDate(true)
			.quality(93)
			.width(1280)
			.height(800)
			.build();

	camera.takeStill(config);

	System.out.println("waiting for camera to take pic");
	Thread.sleep(4000);

	System.out.println("Taking a video for 3 seconds");
	var vidconfig = new Camera.VidConfig.Builder().outputPath("/home/Centuri/Videos/")
			.recordTime(3000)
			.useDate(true)
			.build();
	camera.takeVid(vidconfig);
	
	
}

}
