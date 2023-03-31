package centuri.test_maven;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SetTime {
    
    public static void SetTime() {
        
        String timeStamp = "T" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        ArduinoTimestamp.firstAvailableComPort.writeBytes(timeStamp.getBytes(), timeStamp.length());
        System.out.println("Time set to: " + timeStamp);
    }
}