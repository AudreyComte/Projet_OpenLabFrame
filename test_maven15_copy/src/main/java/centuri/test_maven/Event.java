package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public abstract class Event {
	
	protected char[] toString;

	public abstract boolean Do();
	
	public abstract void Info(boolean ok);
	
}