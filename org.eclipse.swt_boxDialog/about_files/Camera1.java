package about_files;

public class Camera1 {
	
	public static void main(String[] args) {
	
	Camera camera = new Camera();

	camera.takeStill();

	var config = new Camera.PicConfig.Builder().outputPath("/home/pi/Pictures/")
			.delay(3000)
			.disablePreview(true)
			.encoding(Camera.PicEncoding.PNG)
			.useDate(true)
			.quality(93)
			.width(1280)
			.height(800)
			.build();

	camera.takeStill(config);

	var vidconfig = new Camera.VidConfig.Builder().outputPath("/home/pi/Videos/")
			.recordTime(3000)
			.useDate(true)
			.build();
	camera.takeVid(vidconfig);

	}
}