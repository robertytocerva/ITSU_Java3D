package Joystick;

import ESCENARIO.crearEscenaGrafica5;
import Personaje.crearEscenaGrafica4;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class MovimientoKeyListener implements KeyListener {
     private final TransformGroup tgPanza;
    private final crearEscenaGrafica4 crearEscena;
    private final crearEscenaGrafica5 escenaCamara;

    private float orientacion = -(float) Math.PI / 2.0f;


    private final float incrementoPos = 0.03f;
    private final float incrementoRot = (float) Math.toRadians(2);

    public MovimientoKeyListener(crearEscenaGrafica4 escenaPersonaje, crearEscenaGrafica5 escenaCamara) {
        this.crearEscena = escenaPersonaje;
        this.escenaCamara = escenaCamara;
        this.tgPanza = escenaPersonaje.getTgPanza();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                String tipoMovimiento = moverRetorno(
                -(float) Math.sin(orientacion) * incrementoPos,
                -(float) Math.cos(orientacion) * incrementoPos
                );

                if (!tipoMovimiento.equals("ninguno")) {
                    crearEscena.Caminar();
                }
                break;
            case KeyEvent.VK_D:
                girarFloat(-incrementoRot);               
                break;
            case KeyEvent.VK_A:
                girarFloat(incrementoRot);
                break;
             case KeyEvent.VK_T:
                teletransportar(new Vector3d(-6.5, 4.4, 6.8));
                break;
            case KeyEvent.VK_B:
                teletransportar2(new Vector3d(-4.2, 0.9, 5.0), (float) Math.PI/2);
            break;
                }
        actualizarTransform();
        escenaCamara.orientacion = orientacion;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void actualizarTransform() {
    Transform3D t3dActual = new Transform3D();
    tgPanza.getTransform(t3dActual);

    Vector3d pos = new Vector3d();
    t3dActual.get(pos);


    Transform3D rotacion = new Transform3D();
    rotacion.rotY(orientacion);


    rotacion.setTranslation(pos);

    tgPanza.setTransform(rotacion);
}
private void teletransportar2(Vector3d nuevaPos, float nuevaOrientacion) {
    orientacion = nuevaOrientacion;
    escenaCamara.orientacion = orientacion;

    Transform3D transform = new Transform3D();
    transform.rotY(orientacion);
    transform.setTranslation(nuevaPos);
    tgPanza.setTransform(transform);

    escenaCamara.actualizarCamara();
}

private void teletransportar(Vector3d nuevaPos) {
    orientacion = (float) Math.PI/2;
    escenaCamara.orientacion = orientacion;

    Transform3D transform = new Transform3D();
    transform.rotY(orientacion);
    transform.setTranslation(nuevaPos);
    tgPanza.setTransform(transform);

    escenaCamara.actualizarCamara();
}




private String moverRetorno(float dx, float dz) {
    Transform3D t3dActual = new Transform3D();
    tgPanza.getTransform(t3dActual);

    Vector3d pos = new Vector3d();
    t3dActual.get(pos);

    // 1. Intentos escalados hacia adelante
    double[] escalas = {1.0, 0.7, 0.5, 0.3, 0.1};
    for (double escala : escalas) {
        double dxEsc = dx * escala;
        double dzEsc = dz * escala;
        Vector3d intento = new Vector3d(pos.x + dxEsc, pos.y, pos.z + dzEsc);

        if (!escenaCamara.hayColision(intento)) {
            Transform3D nuevaT3D = new Transform3D();
            nuevaT3D.rotY(orientacion);
            nuevaT3D.setTranslation(intento);
            tgPanza.setTransform(nuevaT3D);
            return "interpolado";
        }
    }


    Vector3d normalLateral = new Vector3d(Math.cos(orientacion), 0, -Math.sin(orientacion));
    for (double escala : escalas) {
        Vector3d lateral1 = new Vector3d(pos);
        Vector3d paso1 = new Vector3d(normalLateral);
        paso1.scale(escala * 0.15);  // mayor rango que antes
        lateral1.add(paso1);

        if (!escenaCamara.hayColision(lateral1)) {
            Transform3D lateralT3D = new Transform3D();
            lateralT3D.rotY(orientacion);
            lateralT3D.setTranslation(lateral1);
            tgPanza.setTransform(lateralT3D);
            return "lateral+";
        }

        Vector3d lateral2 = new Vector3d(pos);
        Vector3d paso2 = new Vector3d(paso1);
        paso2.negate();
        lateral2.add(paso2);

        if (!escenaCamara.hayColision(lateral2)) {
            Transform3D lateralT3D = new Transform3D();
            lateralT3D.rotY(orientacion);
            lateralT3D.setTranslation(lateral2);
            tgPanza.setTransform(lateralT3D);
            return "lateral-";
        }
    }

    System.out.println("Sin avance W");
    return "ninguno";
}


    public void girarFloat(float deltaAngulo) {

        orientacion += deltaAngulo;
        actualizarTransform();
        escenaCamara.orientacion = orientacion;
        escenaCamara.actualizarCamara();
    }

}
