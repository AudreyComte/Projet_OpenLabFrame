package centuri.test_maven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Protocol {
	
	ArrayList<Event> protocol;
	
	public Protocol(ArrayList<Event> protocol) {
		this.protocol = protocol;
	}
	
	public void set_protocol(ArrayList<Event> protocol) {
		this.protocol= protocol;
	}

	public ArrayList<Event> get_protocol() {
		return this.protocol;
	}
	
	public static void exporterProtocol (ArrayList<Event> protocol, String name) {
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream objStream = new ObjectOutputStream(file);
            objStream.writeObject(protocol);
            objStream.close();
            file.close();
            System.out.println("The protocol has been exported successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while exporting the protocol: " + e.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Event> importerProtocol (String name) {
        ArrayList<Event> protocol = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream objStream = new ObjectInputStream(file);
            protocol = (ArrayList<Event>) objStream.readObject();
            objStream.close();
            file.close();
            System.out.println("The protocol was successfully imported!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while importing the protocol : " + e.getMessage());
        }
        return protocol;
    }



}
