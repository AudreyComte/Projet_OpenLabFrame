package centuri.test_maven;

import com.fazecast.jSerialComm.*;

public class ArduinoTimestamp {
    
    public static SerialPort firstAvailableComPort;

    public static void main(String[] args) {
        
        SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
        
        for(SerialPort eachComPort:allAvailableComPorts)
            System.out.println("List of all available serial ports: " + eachComPort.getDescriptivePortName());
        
        firstAvailableComPort = allAvailableComPorts[0];
        
        firstAvailableComPort.openPort();

        System.out.println("Opened the first available serial port: " + firstAvailableComPort.getDescriptivePortName());

        MyComPortListener listenerObject = new MyComPortListener();
        
        firstAvailableComPort.addDataListener(listenerObject);
      
    }
    
}
