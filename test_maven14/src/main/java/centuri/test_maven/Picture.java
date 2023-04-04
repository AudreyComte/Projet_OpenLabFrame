
package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Picture extends Event {
	
	int delay;
	int width;
	int heigth;
	static final int quality =100;
	static final String encoding="JPG";
	static final String path = "/home/audrey/Images/";
	
	public Picture (int delay, int width, int heigth){
		this.delay =delay;
		this.width =width;
		this.heigth =heigth;
	}
	

	@Override
	public boolean Do() {
		
		boolean ok = false;
		
		Camera camera = new Camera();
		
		var config = new Camera.PicConfig.Builder().outputPath(path)
				.delay(delay)
				.disablePreview(true)
				.encoding(Camera.PicEncoding.valueOf(encoding))
				.useDate(true)
				.quality(quality)
				.width(width)
				.height(heigth)
				.build();
				
		ok = camera.takeStill(config);
		
		return ok ;
	}


	@Override
	public void Info(boolean ok) {
		if(ok == true) {
			System.out.println("OK : the picture was taken\r\n\n");	
		}
		else {
			System.out.println("Error : the picture wasn't taken");
		}

	}
}
