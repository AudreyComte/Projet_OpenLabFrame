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

	static SerialPort serial_port;
	String message;
	
	
	// method Start
	public boolean Start() {
		
		boolean start;

		serial_port = SerialPort.getCommPort("ttyAMA1"); //ttyAMA1

		if (serial_port.openPort()) {
			System.out.println("Successfully open port! \r\n");
			start = true;
		} else {
			System.out.println("Failed to open port \r\n");
			start = false;
		}

		serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 au lieu de 9600//
		
		
		return start;
		
	}


	
	// method Go
	public void Go(String info) throws IOException, InterruptedException, SerialException {
		
		OutputStream output_stream = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Commande : " + info + "\r");
		info = info + "\n";
		try {
			data_output.write(info.getBytes("UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			output_stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	// method test_$G
	public boolean test_$G() throws SerialException, IOException, InterruptedException {

		boolean test;

		Go("$G");
		
		InputStream input_stream = serial_port.getInputStream();
		
		try {
			while (input_stream.available() <= 0) {
				Thread.sleep(100);
			}
			if (input_stream.available() > 0) {
				int availableBytes = input_stream.available();
				byte[] bytes = new byte[availableBytes];
				input_stream.read(bytes, 0, availableBytes);
				message = new String(bytes);
				System.out.println("Arduino : " + message);
			}
		} catch (Exception e) {
		}
		if (message.contains("[GC:")) {
			test = true;
		} else {
			test = false;
		}

		return test;
		
	}

	
	public boolean event_go(ArrayList<Event> data) {
		
		boolean ok = false;
	
		for (Event event : data) {
			ok = event.Do();
			if (!ok){
				System.out.println("WARNING : ERROR !");
				break;
			}
			event.Info(ok);
		}
		
		return ok;
		
	}
	
	
	// method Close
	public boolean Close()  {
		
		boolean close = false;
		
		if(serial_port.closePort()) {
			System.out.println("Successfully close port!");
			close = true;
		}

		return close;
		
	}

	
}