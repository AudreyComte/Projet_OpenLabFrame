package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Picture extends Event {
	
	Camera myCamera;
	int delay = 1;
	int width = 1000;
	int heigth = 1500;
	static final int quality =100;
	static final String encoding="JPG";
	static final String path = "/home/audrey/Images/";
	
	public Picture (Camera myCamera){
		this.myCamera = myCamera;;
	}
	

	@Override
	public boolean Do() {
		
		boolean ok = false;
		
		
		var config = new Camera.PicConfig.Builder().outputPath(path)
				.delay(delay)
				.disablePreview(false)
				.encoding(Camera.PicEncoding.valueOf(encoding))
				.useDate(true)
				.quality(quality)
				.width(width)
				.height(heigth)
				.build();
				
		ok = this.myCamera.takeStill(config);
		
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