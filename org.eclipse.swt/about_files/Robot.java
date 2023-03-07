package about_files;

import com.pi4j.io.gpio.*;

public class Robot {
	
	// attributs : elements du robot
	private GpioController gpio;
	private GpioPinDigitalOutput led18;

	// constructeur du robot
	public Robot(){
		this.gpio = GpioFactory.getInstance();
		this.led18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
	}

	public void allumerLed(GpioPinDigitalOutput led) {
		led.high();
		System.out.println("Camera alummée");
	}
	
	public void eteindreLed(GpioPinDigitalOutput led) {
		led.low();
		gpio.shutdown();
		gpio.setState(false, led18);
		System.out.println("rest");
		System.out.println("Camera éteinte");
	}
	
	public void resetGPIO() {
		gpio.shutdown();
		gpio.setState(false, led18);
		System.out.println("rest");
	}

	public GpioPinDigitalOutput getLed18() {
		return led18;
	}
}

