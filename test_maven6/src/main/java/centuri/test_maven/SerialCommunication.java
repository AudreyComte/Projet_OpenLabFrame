package centuri.test_maven;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialCommunication implements SerialPortEventListener {
    private SerialPort serialPort;

    private static final String PORT_NAME = "/dev/ttyACM0"; // spécifiez le port série de l'Arduino ici
    private static final int BAUD_RATE = 115200; // vitesse de communication en bauds

    public void initialize() {
        CommPortIdentifier portId = null;

        try {
            portId = CommPortIdentifier.getPortIdentifier(PORT_NAME);
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }

        if (portId == null) {
            System.err.println("Port série non disponible.");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
            serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                String inputLine = input.readLine();
                System.out.println("Données reçues: " + inputLine);
            } catch (Exception e) {
                System.err.println("Erreur: " + e.getMessage());
            }
        }
    }

    
}

