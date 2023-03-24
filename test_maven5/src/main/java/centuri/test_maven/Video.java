package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Video extends Event {
	
	String record_Time;
	
	public Video (String record_Time){
		this.record_Time =record_Time;
	}
	

	@Override
	public void Do() {
		Camera camera = new Camera();
		
		var vidconfig = Camera.VidConfig.Builder.newInstance()
		         .outputPath("/home/audrey/Videos/")
		         .recordTime(Integer.parseInt(record_Time))
		         .useDate(true)
		         .build();
		
		camera.takeVid(vidconfig);
	}

}
