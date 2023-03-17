package about_files;

import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import com.hopding.jrpicam.enums.AWB;
import com.hopding.jrpicam.enums.DRC;
import com.hopding.jrpicam.enums.Encoding;
import com.hopding.jrpicam.enums.Exposure;
import com.hopding.jrpicam.enums.ImageEffect;
import com.hopding.jrpicam.enums.MeteringMode;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;


public class Camera1 {

      public void camera_pi () throws FailedToRunRaspistillException{
	
		RPiCamera piCamera = new RPiCamera("/home/Images");
		piCamera.setWidth(500).setHeight(500) // Set Camera to produce 500x500 images.
	    .setBrightness(75)                // Adjust Camera's brightness setting.
	    .setExposure(Exposure.AUTO)       // Set Camera's exposure.
	    .setTimeout(2)                    // Set Camera's timeout.
	    .setAddRawBayer(true);            // Add Raw Bayer data to image files created by Camera.
	// Sets all Camera options to their default settings, overriding any changes previously made.
	piCamera.setToDefaults();
		
 }
	
}

