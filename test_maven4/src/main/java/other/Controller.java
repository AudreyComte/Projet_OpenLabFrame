package other;

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

import com.fazecast.jSerialComm.SerialPort;

import centuri.test_maven.Field;
import centuri.test_maven.Head;
import centuri.test_maven.Coordinate_Field;
import centuri.test_maven.Manip;
import centuri.test_maven.StopCamera;
//import gnu.io.SerialPortEvent;
import other.Event;

import java.lang.Thread;

public class Controller implements Runnable {
	Field myField;
	Coordinate_Field myCoordinate;
	Head myHead;
	public Manip myManip;
	ArrayList data_controller;
	
	public Controller (Field myField, Coordinate_Field myCoordinate, Head myHead, Manip myManip) {
		this.myField = myField;
		this.myCoordinate = myCoordinate;
		this.myHead = myHead;
		this.myManip = myManip;
		this.data_controller = new ArrayList ();
	}
	
	
	
	public void setField (Field myField) {
		this.myField = myField;
	}

	public void setCoordinate (Coordinate_Field myCoordinate) {
		this.myCoordinate = myCoordinate;
	}
	
	public void setHead (Head myHead) {
		this.myHead = myHead;
	}
		
	public void setManip(Manip myManip) {
		this.myManip = myManip;
	}
	
	public Field get_myField () {
		return this.myField;
	}
	
	public Coordinate_Field get_myCoordinate () {
		return this.myCoordinate;
	}
	
	public Head getHead() {
		return this.myHead;
	}
	
	public Manip get_myManip () {
		return this.myManip;
	}
	
	
	
	public void go () {
		int nbEvent = myManip.get_nb_event();
		Event[] event = new Event[nbEvent+1];
		for(int i=0; i<=nbEvent; i++) {
			event[i] = new Event(myManip.getData().get(i).toString(), myCoordinate.well_x_coordinate(myManip.getData().get(i).toString()),
					myCoordinate.well_y_coordinate(myManip.getData().get(i).toString()), myManip.getTime());
			if(i==0) {
				this.data_controller.add("$H\n");
				this.data_controller.add("G92x0y0z0\n");
				this.data_controller.add("G90\n");
			}
			this.data_controller.add("G0x" + event[i].get_x().toString() + "\n");
			this.data_controller.add("G0y" + event[i].get_y().toString()+ "\n");
			this.data_controller.add("G4 P"+ event[i].get_time()+ "\n");
		}
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
	
	
	public void Arduino()throws IOException, InterruptedException  {
    	
		
	}



	@Override
	public void run() {
		
		SerialPort[] get_port = SerialPort.getCommPorts();
		
		for(SerialPort port : get_port) {
			System.out.println(port.getSystemPortName());
			serial_port = SerialPort.getCommPort(port.getSystemPortName());
					
			if(serial_port.openPort()) {
				System.out.println("Successfully open port!");
			}else {
				System.out.println("Failed to open port");
			}
		}
		
		serial_port.setBaudRate(115200); // Attention au BaudRate : avec Grbl 115200 //
		
		//InputStream input_stream = serial_port.getInputStream();
			//while(input_stream!=null) {
				//char msg =(char)input_stream.read();
				//System.out.print(msg);
			//}
			
		 //Thread.sleep(5000);
							
		
		//InputStream input_stream  = serial_port.getInputStream();
		//DataInputStream data_input = new DataInputStream(input_stream);
		

		
		OutputStream output_stream  = serial_port.getOutputStream();
		DataOutputStream data_output = new DataOutputStream(output_stream);
		
		/*Scanner scanner1 = new Scanner(System.in);
		if(scanner1.next()== "stop") {
			String msg = "M30\n";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				data_output.write(msg.getBytes("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}	*/
			
		String filename = "/home/audrey/Desktop/Save_Coordiate.txt";
		
		try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))) {
		      String strCurrentLine;
		      while ((strCurrentLine = bufferedreader.readLine()) != null) {
		    	  System.out.println(strCurrentLine);
		    	  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	  strCurrentLine= strCurrentLine +"\n";
		    	  data_output.write(strCurrentLine.getBytes("UTF-8"));
		    	  if (strCurrentLine.contains("G4 P")== true ){
		    		  
		    		  StopCamera Stop_cam = new StopCamera();
						Thread t1 = new Thread(Stop_cam);
						t1.start();
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
						
						Picture2 picture = new Picture2(0,0,0);
						Thread t3 = new Thread(picture);
						t3.start();
		    	  }
		      }
		    } catch (IOException ioe) {
		     ioe.printStackTrace();   
		      
		      }
		      
		serial_port.closePort();
		
	};


}

