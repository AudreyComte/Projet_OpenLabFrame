package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.sql.rowset.serial.SerialException;

import com.fazecast.jSerialComm.SerialPort;

public abstract class Event {
	
	protected char[] toString;

	public abstract boolean Do() throws SerialException, IOException, InterruptedException;
	
	public abstract void Info(boolean ok);
	
}