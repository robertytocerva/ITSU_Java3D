package Personaje;

import ESCENARIO.crearEscenaGrafica5;
import Joystick.JoystickReader;
import Joystick.MovimientoKeyListener;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;

public class Personaje extends JFrame {

    private crearEscenaGrafica4 creaEscena;
    private crearEscenaGrafica5 creaEscena5;
    private MovimientoKeyListener movListener;

    public Personaje() {
        super("Personaje con Joystick");

        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        this.setLayout(new BorderLayout());
        this.add(canvas3D, BorderLayout.CENTER);
        this.setBounds(300, 50, 840, 870);

        creaEscena = new crearEscenaGrafica4();
        BranchGroup scene = creaEscena.getBranchGroup();  // usa el método getter

        SimpleUniverse universe = new SimpleUniverse(canvas3D);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(scene);

        movListener = new MovimientoKeyListener(creaEscena,creaEscena5);
        canvas3D.addKeyListener(movListener);

        canvas3D.setFocusable(true);
        canvas3D.requestFocusInWindow();

        new Thread(new JoystickReader(movListener, "COM3")).start();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personaje().setVisible(true);
            }
        });
    }


}
