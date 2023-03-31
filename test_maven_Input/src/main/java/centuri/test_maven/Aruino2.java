package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;


public class Aruino2 {

	    public static SerialPort arduinoPort = null;
	    public static InputStream arduinoStream = null;
	    static String logText="";
	    private static boolean isRunning=false;
	    private static   byte[] sendingPack;
	    private static   byte[] receivingPack;
	    public static boolean isRunning() {
	        return isRunning;
	    }

	    public static void setRunning(boolean running) {
	        try {
				sendingPack = new byte[6];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				receivingPack= new byte[36];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        isRunning = running;
	       
	    }
	    
	    static SerialPort devicePortName;
	    
	   public static void connectPort(String port) {
		   
		   devicePortName = SerialPort.getCommPort("ttyACM0");

	        int len = SerialPort.getCommPorts().length;
	        SerialPort serialPorts[] = new SerialPort[len];
	        serialPorts = SerialPort.getCommPorts();

	        for (int i = 0; i < len; i++) {

	            String portName = serialPorts[i].getDescriptivePortName();
	            System.out.println(serialPorts[i].getSystemPortName() + ": " + portName + ": " 
	             + i);
	           
	            if (portName.contains((CharSequence) devicePortName)) {
	                try {
	                    arduinoPort = serialPorts[i];
	                    arduinoPort.setBaudRate(115200);
	                    arduinoPort.openPort();
	                    setRunning(true);
	                    System.out.println("connected to: " + portName + "[" + i + "]");
	                    logText="Connected to: " + portName ;

	                    break;
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    //loogger.stop();
	                    arduinoPort.closePort();
	                }
	           } }
	 
	      (new Thread(new SerialReader(receivingPack))).start();
	      (new Thread(new SerialWriter(sendingPack))).start();
	     }
	    public static class SerialReader implements Runnable
	      {
	        byte[] buffer;

	        public SerialReader ( byte[] buffer )
	        {
	            this.buffer = buffer;
	            System.out.println("Reader");

	        }

	        public void run () {

	            readData(buffer,isRunning());
	        }
	    }
	  public static class SerialWriter implements Runnable
	    {
	        byte[] buffer;

	        public SerialWriter ( byte[] buffer )
	        {
	            this.buffer = buffer;

	        }

	        public void run () {

	            sendData(buffer);

	        }
	    }
	   public static void sendData(byte[] buffer){
	           
	        while (isRunning){
	             
	            arduinoPort.writeBytes(sendingPack,6,0);

	     System.out.println("Sending"+bytesToHexString(sendingPack));
	            try {
	                Thread.sleep(200);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            }
	       }
	   

	  public static void readData(byte[] buffer,boolean loopStatus){
	        while (isRunning()){

	            arduinoPort.readBytes(receivingPack,36,0);
	           
	           
	            //if(receivingPack()[0] & 0xff)==144 ){           
	                    
	         //String bufferD=bytesToHexString(receivingPack);
	                    //System.out.println(bufferD);
	                
	            //}
	            //try {
	                //Thread.sleep(50);
	           // } catch (Exception e) {
	               // e.printStackTrace();
	        //}
	        }}

	  public static String bytesToHexString(byte[] bytes){
	          StringBuilder sb = new StringBuilder();
	        for (byte b : bytes){
	            sb.append(String.format("%02x", b&0xff));
	        }
	        return sb.toString();
	    }
 }