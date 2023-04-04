package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Video extends Event {

	String record_Time;
	
	static final String path = "/home/audrey/Videos/";

	public Video(String record_Time) {
		this.record_Time = record_Time;
	}

	@Override
	public boolean Do() {

		Camera camera = new Camera();
		
		var vidconfig = Camera.VidConfig.Builder.newInstance()
		         .outputPath(path)
		         .recordTime(Integer.parseInt(record_Time))
		         .useDate(true)
		         .build();
		
		return camera.takeVid(vidconfig);
	}

	@Override
	public void Info(boolean ok) {
		if (ok == true) {
			System.out.println("OK : the video was taken\r\n\n");
		} else {
			System.out.println("Error : the video wasn't taken");
		}

	}
}
