package centuri.test_maven;

import javax.swing.JFrame;


public class Stop implements Runnable  {

		@Override
		public void run() {
			CameraView2 frame = new CameraView2();
			frame.dispose();
 }
}