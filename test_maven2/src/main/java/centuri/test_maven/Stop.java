package centuri.test_maven;

import javax.swing.JFrame;


public class Stop implements Runnable  {

		@Override
		public void run() {
			CameraView frame = new CameraView();
			frame.dispose();
 }
}