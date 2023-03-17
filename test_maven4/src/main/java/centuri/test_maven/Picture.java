package centuri.test_maven;

public class Picture implements Runnable {
	int delay;
	int width;
	int height;
	
	public Picture (int delay, int width, int height) {
		this.delay = delay;
		this.width = width;
		this.height = height;
	}
	
	public void setDelay (int delay) {
		this.delay = delay;
	}
	
	public void setWidth (int width) {
		this.width = width;
	}
	
	public void setHeight (int height) {
		this.height = height;
	}
	
		public void run() {
			
			Camera camera = new Camera();
			int delay= this.delay;
			int width=this.width;
			int height=this.height;
			
			var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
					.delay(delay)
					.disablePreview(true)
					.encoding(Camera.PicEncoding.valueOf("JPG"))
					.useDate(true)
					.quality(Integer.parseInt("100"))
					.width(width)
					.height(height)
					.build();
			
			camera.takeStill(config);
	 }


}
