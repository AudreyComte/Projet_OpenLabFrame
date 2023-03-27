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
	ArrayList<String> data_controller;
	
	public Arduino (ArrayList<String> data_controller) {
		this.data_controller=data_controller;
	}
	
	
	static SerialPort serial_port;

	
    public void Start_arduino()throws IOException, InterruptedException, SerialException  {
    	
    		serial_port = SerialPort.getCommPort("ttyACM0");
 				
					
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
		
		
			serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 au lieu de 9600//
		
		
        	
		OutputStream output_stream  = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		
		//InputStream input_stream  = serial_port.getInputStream();
		//DataInputStream data_input = new DataInputStream(input_stream);
		BufferedReader input = new BufferedReader(new InputStreamReader(serial_port.getInputStream()));
	    OutputStream output = serial_port.getOutputStream();

	      // Lire les données envoyées par l'Arduino
	      
	    
		
		for (int i = 0; i < this.data_controller.size(); i ++) {
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
		
   
 
			serial_port.closePort();
			System.out.println("Successfully close port!");
    	
    	//InputStream input_stream  = serial_port.getInputStream();
    	//Thread.sleep(2000);
		//DataInputStream data_input = new DataInputStream(input_stream);
		//data_input.
		//Thread.sleep(5000);
        //String str = data_input.readUTF();
        //Thread.sleep(5000);
        //System.out.println("Arduino : "+ str);
     
        
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
}
