package centuri.test_maven;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public abstract class Event {
	
	protected char[] toString;

	public abstract boolean toDo();
	
	public abstract void info(boolean ok);
	
	
	
}