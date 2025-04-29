package Joystick;

import ESCENARIO.crearEscenaGrafica5;
import Muebles.Administrativo;
import Muebles.Cubiculo;
import Muebles.Cubiculo2;
import Muebles.SalonD;
import Muebles.SalonDF;
import Muebles.SalonIz;
import Muebles.SalonIzF;
import Personaje.crearEscenaGrafica4;
import colisiones.ObjetoConColision;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.vecmath.Point3d;


public class MovimientoKeyListener implements KeyListener {
     private final TransformGroup tgPanza;
    private final crearEscenaGrafica4 crearEscena;
    private final crearEscenaGrafica5 escenaCamara;
    public ArrayList<ObjetoConColision> obstaculos = new ArrayList<>();/////////colisiones
   

    private float pitch = 0.0f;
    private float orientacion = -(float) Math.PI / 2.0f;

    private static final float MAX_PITCH = (float) Math.toRadians(80);
    private static final float MIN_PITCH = (float) Math.toRadians(-80);
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
/////edita apartir de aqui
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
            case KeyEvent.VK_SPACE:
                saltar();
                break;
             case KeyEvent.VK_T:
                teletransportar(new Vector3d(-6.5, 4.4, 6.8)); // más profundo en planta 2
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
    t3dActual.get(pos); // obtener la posición actual

    // Crear nueva rotación
    Transform3D rotacion = new Transform3D();
    rotacion.rotY(orientacion);

    // Aplicar posición actual
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
    orientacion = (float) Math.PI/2; // 180 grados = mirando al pasillo
    escenaCamara.orientacion = orientacion;

    Transform3D transform = new Transform3D();
    transform.rotY(orientacion); // rotación completa
    transform.setTranslation(nuevaPos);
    tgPanza.setTransform(transform);

    escenaCamara.actualizarCamara();
}



private void mover(float dx, float dz) {
    Transform3D t3dActual = new Transform3D();
    tgPanza.getTransform(t3dActual);

    Vector3d pos = new Vector3d();
    t3dActual.get(pos);

    Vector3d intentoTotal = new Vector3d(pos.x + dx, pos.y, pos.z + dz);

    if (!escenaCamara.hayColision(intentoTotal)) {
        aplicarTransformConRotacion(intentoTotal);
    } else {
        // Efecto deslizamiento: intentar movimientos más pequeños
        double[] escalas = {0.7, 0.4, 0.2, 0.1};
        for (double escala : escalas) {
            Vector3d intentoParcial = new Vector3d(
                pos.x + dx * escala,
                pos.y,
                pos.z + dz * escala
            );
            if (!escenaCamara.hayColision(intentoParcial)) {
                aplicarTransformConRotacion(intentoParcial);
                break;
            }
        }
    }
}
private void aplicarTransformConRotacion(Vector3d nuevaPos) {
    Transform3D rotacion = new Transform3D();
    rotacion.rotY(orientacion);

    Transform3D tFinal = new Transform3D();
    tFinal.setTranslation(nuevaPos);

    rotacion.mul(tFinal);
    tgPanza.setTransform(rotacion);
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

    // 2. Deslizamiento lateral progresivo (ambos lados)
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

    System.out.println("❌ Sin avance ni deslizamiento lateral posible con W");
    return "ninguno";
}


public void girarFloat(float deltaAngulo) {
    
    orientacion += deltaAngulo;
    actualizarTransform();
    escenaCamara.orientacion = orientacion;
    escenaCamara.actualizarCamara();
}

    public void saltar() {
        boolean enSalto = false;
        System.out.println("¡Salto!");
        new Thread(() -> {
            try {
                final double alturaSalto = 0.5;
                final int pasos = 10;
                final long delay = 20;

                for (int i = 0; i < pasos; i++) {
                    moverVertical(alturaSalto / pasos);
                    Thread.sleep(delay);
                }

                for (int i = 0; i < pasos; i++) {
                    moverVertical(-alturaSalto / pasos);
                    Thread.sleep(delay);
                }

                fijarAltura(0.9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void moverVertical(double dy) {
        Transform3D t3d = new Transform3D();
        tgPanza.getTransform(t3d);

        Vector3d pos = new Vector3d();
        t3d.get(pos);
        pos.y += dy;

        t3d.setTranslation(pos);
        tgPanza.setTransform(t3d);
    }

    private void fijarAltura(double altura) {
        Transform3D t3d = new Transform3D();
        tgPanza.getTransform(t3d);

        Vector3d pos = new Vector3d();
        t3d.get(pos);
        pos.y = altura;

        t3d.setTranslation(pos);
        tgPanza.setTransform(t3d);
    }
    private final Vector3d posicion = null;

}
