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

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
//import com.pi4j.catalog.components.SerialReader;

//import gnu.io.SerialPortEvent;



public class Arduino {
	
	
		static SerialPort serial_port;
		
		
		//method Start_arduino
	    public boolean Start_arduino()throws IOException, InterruptedException, SerialException  {
	    	
	    		serial_port = SerialPort.getCommPort("ttyACM0");
	 						
				if(serial_port.openPort()) {
					System.out.println("Successfully open port!");
				}else {
					System.out.println("Failed to open port");
				}
			
				serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 au lieu de 9600//
				
				return true;
	    }
		
	    
	    //method getSearialPort
		public SerialPort getSerialPort() {
				return this.serial_port;
		}
		
		
		//method Go_arduino	 
		public void Go_arduino()throws IOException, InterruptedException, SerialException  {
        	
		OutputStream output_stream  = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		
		}
		
		
		//method Input_arduino
		public void input()  {
		
		InputStream input_stream  = serial_port.getInputStream();
		        try {
		            if (input_stream.available() > 0) {
		                    int availableBytes = input_stream.available();
		                    byte[] bytes = new byte[availableBytes];
		                    input_stream.read(bytes, 0, availableBytes);
		                    String message = new String(bytes);
		                    System.out.println("Arduino : " + message);
		                    Thread.sleep(2000);
		            }
		            if (input_stream.available() < 0) {
		            	Thread.sleep(2000);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		}
		
		public String getMessage() {
			return message;
		}
		
		/*DataInputStream data_input = new DataInputStream(input_stream);
		Thread.sleep(5000);
		String str = data_input.readUTF();
		if (str == null) {
			Thread.sleep(1000);
		}
		else {
			System.out.println("Arduino : "+ str);
		}
		//System.out.println("Arduino : "+ str);
		//while((str = data_input.readUTF()).isEmpty()) {
		Thread.sleep(1000);	
		InputStream input_stream  = serial_port.getInputStream();
		DataInputStream data_input = new DataInputStream(input_stream);
		BufferedReader input = new BufferedReader(new InputStreamReader(serial_port.getInputStream()));
		Thread.sleep(1000);
		String line = (input.readLine());
		Thread.sleep(5000);
		
		
		while (line.isEmpty()) {
			  Thread.sleep(2000);
		}
		
		if (line.contains(" ")) {
			Thread.sleep(1000);
			System.out.println(line);
			}*/
		
		
		
		//method Close_arduino
		public boolean Close_arduino()throws IOException, InterruptedException, SerialException {
			
		serial_port.closePort();
		System.out.println("Successfully close port!");
		
		return true;
		}
	    
	    	
		//InputStream input_stream  = serial_port.getInputStream();
		//DataInputStream data_input = new DataInputStream(input_stream);
		//BufferedReader input = new BufferedReader(new InputStreamReader(serial_port.getInputStream()));
	    //OutputStream output = serial_port.getOutputStream();

	    // Lire les données envoyées par l'Arduino
	      
	    
		/*for (int i = 0; i < this.data_controller.size(); i ++) {
			String info = (String) this.data_controller.get(i);
			Thread.sleep(2000);
			info = info + "\n";
			System.out.println(info);
			data_output.write(info.getBytes("UTF-8"));
			String line;
		      while ((line = input.readLine()) != null) {
		    	Thread.sleep(10000);
		        System.out.println(line);
		      }
			}
				/*if(msg == 'k') {
					Thread.sleep(1000);
					info = "G4 P10\n";
					System.out.println(info);
					data_output.write(info.getBytes("UTF-8"));
					Picture pic = new Picture();
					pic.run();
				}
				if(msg == ']' || msg== 'k') {
					System.out.print("\n");
					break;
				}*/
		
	
		
        
		//Thread thread = new Thread(){
			//@Override public void run() {
	
				//Scanner scanner = new Scanner(serial_port.getInputStream());
				//try {
					//Thread.sleep(2000);
				//} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				//}
				//while(scanner.hasNextLine()) {
					//try {
						//String line = scanner.nextLine();
						//System.out.println("Arduino : "+line);								
					//} catch(Exception e) {}
				//}							
				//scanner.close();
				
			//}
		//};
		//Thread.sleep(2000);
		//thread.start();
		//Thread.sleep(2000);	
		
	//}
    
    
}
