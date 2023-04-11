package centuri.test_maven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialException;
import javax.swing.JTextArea;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.pi4j.catalog.components.SerialReader;

//import gnu.io.SerialPortEvent;




public class Arduino2 {
	ArrayList<String> data_controller;
	
	public Arduino2 (ArrayList<String> data_controller) {
		this.data_controller=data_controller;
	}
	
	
	public void afficher_data_controller() {
		for (int i =0;i<this.data_controller.size(); i ++) {
			System.out.print(data_controller.get(i));
		}	
	}
	
	
	public void Save_Coordinate () {
		try {
			FileWriter file = new FileWriter("Save_Coordiate.txt");
			BufferedWriter output = new BufferedWriter(file);
			for (int i = 0; i < this.data_controller.size(); i ++) {
				String Info = (String) this.data_controller.get(i);
				output.write(Info);
			}
		    output.close();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	static SerialPort serial_port;

	
    public void arduino_openPort()throws IOException, InterruptedException, SerialException  {
    	
    	serial_port = SerialPort.getCommPort("ttyACM0");
 				
					
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
		
		if(serial_port.openPort()) {
			System.out.println("Successfully open port!");
		}else {
			System.out.println("Failed to open port");
		}
		
		serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 au lieu de 9600//
				
							
		
		//InputStream input_stream  = serial_port.getInputStream();
		//DataInputStream data_input = new DataInputStream(input_stream);
		
    }
	
    
    public void arduino_closePort()throws IOException, InterruptedException, SerialException  {
    	serial_port.closePort();
		System.out.println("Successfully close port!");
    }
    	
    
    public void arduino_start()throws IOException, InterruptedException, SerialException  {
    	
		OutputStream output_stream  = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		
		
		/*String filename = "/home/audrey/Desktop/Save_Coordiate.txt";
		
		try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
		      String strCurrentLine;
		      while ((strCurrentLine = bufferedreader.readLine()) != null) {
		    	  System.out.println(strCurrentLine);
		    	  Thread.sleep(1000);
		    	  strCurrentLine= strCurrentLine +"\n";
		    	  data_output.write(strCurrentLine.getBytes("UTF-8"));	
		      }
		    } catch (IOException ioe) {
		     ioe.printStackTrace();   
		      
		      }*/
		
		for (int i = 0; i < this.data_controller.size(); i ++) {
			String info = (String) this.data_controller.get(i);
			Thread.sleep(1000);
			info = info + "\n";
			System.out.println(info);
			data_output.write(info.getBytes("UTF-8"));
			
		}
		
    }
    
    
    public InputStream getInput() {
    	InputStream input_stream = serial_port.getInputStream();
    	return input_stream;
    }
    
    
    public void arduino_inPut()throws IOException, InterruptedException, SerialException  {
    	
    	InputStream input_stream = serial_port.getInputStream();
		Thread.sleep(2000); // Attendre 2 secondes avant de débuter
			while(input_stream != null) {
				//Thread.sleep(100);
				char msg =(char)input_stream.read();
				System.out.print(msg);
				if(msg == ']') {
					break;
				}
			}
    	
    	
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
