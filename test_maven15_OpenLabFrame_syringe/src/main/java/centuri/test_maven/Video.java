package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Video extends Event {

	int record_Time;
	Camera myCamera;
	static final String path = "/home/audrey/Images/";

	public Video(int record_Time, Camera myCamera) {
		this.record_Time = record_Time;
		this.myCamera = myCamera;
	}

	@Override
	public boolean Do() {
		
		var vidconfig = Camera.VidConfig.Builder.newInstance()
		         .outputPath(path)
		         .recordTime(record_Time)
		         .useDate(true)
		         .build();
		
		return this.myCamera.takeVid(vidconfig);
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