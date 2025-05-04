
package ESCENARIO;




import Joystick.JoystickReader;
import Joystick.MovimientoKeyListener;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.SwingUtilities;

public class EdificioI extends javax.swing.JFrame {
crearEscenaGrafica5 creaEscena = new  crearEscenaGrafica5();




    public EdificioI() {
        initComponents();

        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D lienzo = new Canvas3D(config);
        lienzo.setBounds(20, 20, 1000, 900);
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.add(lienzo);
        this.setBounds(100, 50, 1000, 1000);

        MovimientoKeyListener listener = new MovimientoKeyListener(creaEscena.personaje, creaEscena);
        lienzo.addKeyListener(listener);


        BranchGroup root = new BranchGroup();
        root.addChild(creaEscena.bgRaiz);
        
        SimpleUniverse universo = new SimpleUniverse(lienzo);
        universo.getViewingPlatform().setNominalViewingTransform();
        universo.addBranchGraph(root);
        
        creaEscena.inicializarCamara(universo);
  
            JoystickReader reader = new JoystickReader(listener, "COM8");
            new Thread(reader, "Joystick-Thread").start();
          
        // Configurar ventana
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        this.setVisible(true);

        // Asegurar enfoque del lienzo
        SwingUtilities.invokeLater(() -> {
            lienzo.requestFocus();
            lienzo.requestFocusInWindow();
            lienzo.setFocusable(true);
            lienzo.setFocusTraversalKeysEnabled(false);
        });

        // Debug tecla presionada
        lienzo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Tecla presionada: " + e.getKeyChar());
            }
        });


        lienzo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lienzo.requestFocusInWindow();
            }
        });
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IZQUIERDA");

        jLabel2.setText("DERECHA");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addGap(225, 225, 225)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(863, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(1009, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdificioI().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;

}
