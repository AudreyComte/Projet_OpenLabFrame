package centuri.test_maven;

import com.fazecast.jSerialComm.*;

public class MyComPortListener implements SerialPortDataListener {

                   @Override
                   public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
                   
                   @Override
                   public void serialEvent(SerialPortEvent event)
                   {
                       byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
                       event.getSerialPort().readBytes(buffer, buffer.length);
                       
                       ReformatBuffer.parseByteArray(buffer);
                   }
                   
}