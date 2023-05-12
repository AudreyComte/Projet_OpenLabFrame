package centuri.test_maven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialException;
import javax.swing.JTextArea;

import com.fazecast.jSerialComm.*;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
//import com.pi4j.catalog.components.SerialReader;

//import gnu.io.SerialPortEvent;

public class Arduino {

	SerialPort serial_port;
	String port;
	DataOutputStream data_output;
	OutputStream output_stream;
	InputStream input_stream;
	String message;

	public Arduino(String port) {
		this.port = port;
	}

	// method Start : ouverture du port donné en argument

	public boolean start() {

		boolean start;

		serial_port = SerialPort.getCommPort(port); // ttyAMA1 //ttyAMA0

		if (serial_port.openPort()) {
			System.out.println("Successfully open port! \r\n");
			start = true;
		} else {
			System.out.println("Failed to open port \r\n");
			start = false;
		}

		serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 au lieu de 9600//

		output_stream = serial_port.getOutputStream();

		input_stream = serial_port.getInputStream();

		data_output = new DataOutputStream(output_stream);

		return start;

	}

	// method Go : pause 100 ms puis envoie le G-code à arduino puis pause 100 ms

	public boolean go(String info) {

		boolean go = true;

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Error Thread_sleep" + e.getMessage());
			go = false;
		}

		System.out.println("Commande : " + info + "\r");

		info = info + "\n";

		try {
			data_output.write(info.getBytes("UTF-8"));
		} catch (IOException e1) {
			System.out.println("Error data_output" + e1.getMessage());
			go = false;
		}

		/*
		 * try { Thread.sleep(100); } catch (InterruptedException e) {
		 * System.out.println("Error Thread_sleep" + e.getMessage()); go = false; }
		 */

		return go;

	}

	// method test_$G : méthode Go() avec le code $G en argument puis attend
	// qu'arduino renvoie une réponse : si la réponse est "[GC:" --> renvoie true si
	// non la méthode renvoie false

	public boolean test_$G() {

		boolean test = false;

		go("$G");

		while (true) {

			try {

				if (input_stream.available() > 0) {
					int availableBytes = input_stream.available();
					byte[] bytes = new byte[availableBytes];
					input_stream.read(bytes, 0, availableBytes);
					message = new String(bytes);
					System.out.println("Arduino : " + message);
					if (message.contains("[GC:")) {
						System.out.println("[GC: was detected !");
						test = true;
						break;
					} else {
						Thread.sleep(10);
						test = false;
					}
				}
			} catch (Exception e) {
			}
		}
		return test;
	}

	// method Close : ferme le port arduino et les output et input

	public boolean close() {

		boolean close = false;

		if (serial_port.closePort()) {
			System.out.println("Successfully close port!");
			try {
				input_stream.close();
				output_stream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			close = true;
		}

		return close;

	}

	/*
	 * public static void main(String[] args) { Arduino arduino = new Arduino
	 * ("ttyACM0"); arduino.Start(); arduino.test$G(); //arduino.Go("$H");
	 * //arduino.test_$G(); /*Initialisation home = new Initialisation(arduino);
	 * ArrayList<Event>homing = new ArrayList<Event>(); homing.add(home);
	 * Loading_protocol protocol = new Loading_protocol();
	 * protocol.event_go(homing); }
	 */

}