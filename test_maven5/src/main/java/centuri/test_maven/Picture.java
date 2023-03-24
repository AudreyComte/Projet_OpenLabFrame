package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Picture implements Runnable {

	

	@Override
	public void run() {
        Camera camera = new Camera();
		
		var config = new Camera.PicConfig.Builder().outputPath("/home/audrey/Images/")
				.delay(Integer.parseInt("1000"))
				.disablePreview(true)
				.encoding(Camera.PicEncoding.valueOf("JPG"))
				.useDate(true)
				.quality(Integer.parseInt("100"))
				.width(Integer.parseInt("1240"))
				.height(Integer.parseInt("800"))
				.build();
		
		camera.takeStill(config);
		
	}

}
