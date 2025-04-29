package Joystick;

import java.io.InputStream;
import java.util.Scanner;
import com.fazecast.jSerialComm.SerialPort;

public class JoystickReader extends Thread {
    private MovimientoKeyListener controlador;
    private SerialPort puerto;
    private Scanner scanner;

    public JoystickReader(MovimientoKeyListener controlador, String nombrePuerto) {
        this.controlador = controlador;
        for (SerialPort sp : SerialPort.getCommPorts()) {
            if (sp.getSystemPortName().equals(nombrePuerto)) {
                this.puerto = sp;
                break;
            }
        }
        if (puerto != null) {
            puerto.setBaudRate(9600);
            puerto.setNumDataBits(8);
            puerto.setNumStopBits(SerialPort.ONE_STOP_BIT);
            puerto.setParity(SerialPort.NO_PARITY);
            puerto.openPort();
            InputStream input = puerto.getInputStream();
            scanner = new Scanner(input);
        } 
    }
    public void cerrar() {
        if (puerto != null && puerto.isOpen()) {
            puerto.closePort();
        }
    }
}
