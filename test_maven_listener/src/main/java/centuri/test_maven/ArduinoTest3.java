package centuri.test_maven;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;

import com.fazecast.jSerialComm.*;
import java.util.*;

import javax.sql.rowset.serial.SerialException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import java.awt.Event;
import java.io.*;



public class ArduinoTest3 {
	
Protocol myProtocol;

	
	public ArduinoTest3 (Protocol myProtocol) {
		this.myProtocol= myProtocol;
	}
	
	 
	   static SerialPort serial_port;
	   static InputStream in;
	   

	   public void Start_arduino()throws IOException, InterruptedException, SerialException  {
	    	
   		serial_port = SerialPort.getCommPort("ttyAMA1");
				
					
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
		
		serial_port.setBaudRate(115200);
		
	   }
	   
	   public void Go(String info) {
		   OutputStream output_stream  = serial_port.getOutputStream();
		   DataOutputStream data_output = new DataOutputStream(output_stream);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Commande : " + info);
			info = info + "\n";
			try {
				data_output.write(info.getBytes("UTF-8"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	   
	 
	   
	   public void Go_arduino()throws IOException, InterruptedException, SerialException  {
		   
		 Go("$H");
		
	     serial_port.addDataListener(new SerialPortDataListener() {
	       @Override
	       public int getListeningEvents() {
	         return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
	       }
	       
	       public void serialEvent(SerialPortEvent event) {
	         if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
	         return;
	         byte[] newData = new byte[serial_port.bytesAvailable()];
	         int numRead = serial_port.readBytes(newData, newData.length);
	         String dataString = new String(newData, 0, numRead);
	         System.out.println("Arduino : " + dataString);
	         if (dataString.contains("ok")) {
				for (int i =0; i< myProtocol.getProtocol().size(); i++) {
					if (dataString.contains("ok")) {
	        			 myProtocol.getProtocol().get(i).Do();
	        			 Go(myProtocol.getProtocol().get(i).Info());
	        			 System.out.println("Arduino : " + dataString);
	        			 if(i==(myProtocol.getProtocol().size())-1) {
							try {
								Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
	        				serial_port.closePort();
	        				System.out.println("Successfully close port!");	
	        				break;
	        			 }
	        		 }
	        	 }
	         }
	       	}
	   });  
	   
		
	   }
	   
	   
}
	   	   

	 
	 
	 
	 
	 
		




		




