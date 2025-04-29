package Personaje;

import ESCENARIO.crearEscenaGrafica5;
import Joystick.JoystickReader;
import Joystick.MovimientoKeyListener;
import com.sun.j3d.utils.universe.SimpleUniverse;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Personaje extends JFrame {

    private crearEscenaGrafica4 creaEscena;
    private crearEscenaGrafica5 creaEscena5;
    private MovimientoKeyListener movListener;

    public Personaje() {
        super("Personaje con Joystick");

        // 1) Canvas y Universo
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        this.setLayout(new BorderLayout());
        this.add(canvas3D, BorderLayout.CENTER);
        this.setBounds(300, 50, 840, 870);

        // 2) Escena del personaje
        creaEscena = new crearEscenaGrafica4();
        BranchGroup scene = creaEscena.getBranchGroup();  // usa el método getter

        SimpleUniverse universe = new SimpleUniverse(canvas3D);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(scene);

        // 3) KeyListener para W/A/S/D y rotación
        movListener = new MovimientoKeyListener(creaEscena,creaEscena5);
        canvas3D.addKeyListener(movListener);

        // 4) Hacer focus para recibir teclas
        canvas3D.setFocusable(true);
        canvas3D.requestFocusInWindow();

        // 5) ¡Arrancar joystick!
        new Thread(new JoystickReader(movListener, "COM3")).start();

        // 6) Manejo de cierre
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1047, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
