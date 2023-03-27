package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Picture extends Event {
	
	int delay;
	int width;
	int heigth;
	
	public Picture (int delay, int width, int heigth){
		this.delay =delay;
		this.width =width;
		this.heigth =heigth;
	}
	

	@Override
	public void Do() {
		
		Camera camera = new Camera();
		
		var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
				.delay(delay)
				.disablePreview(true)
				.encoding(Camera.PicEncoding.valueOf("JPG"))
				.useDate(true)
				.quality(100)
				.width(width)
				.height(heigth)
				.build();
		
		camera.takeStill(config);
	}


	@Override
	public String Info() {
		String nb = delay+2000+"";
		return ("G4 P"+ nb);		
	}

}
