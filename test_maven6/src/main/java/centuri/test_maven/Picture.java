package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Picture extends Event {
	
	String delay;
	String width;
	String heigth;
	
	public Picture (String delay, String width, String heigth){
		this.delay =delay;
		this.width =width;
		this.heigth =heigth;
	}
	

	@Override
	public void Do() {
		
		Camera camera = new Camera();
		
		var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
				.delay(Integer.parseInt(delay))
				.disablePreview(true)
				.encoding(Camera.PicEncoding.valueOf("JPG"))
				.useDate(true)
				.quality(Integer.parseInt("100"))
				.width(Integer.parseInt(width))
				.height(Integer.parseInt(heigth))
				.build();
		
		camera.takeStill(config);
	}

}
