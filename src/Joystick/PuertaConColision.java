package Joystick;

import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.Vector3d;
import javax.vecmath.Color3f;
import java.util.List;

public class PuertaConColision {
    private TransformGroup tgPuerta;
    private ObjetoConColision colisionPuerta;
    private List<ObjetoConColision> listaObstaculos;
    private boolean abierta = false;

    private final Vector3d posicionCerrada;
    private final Vector3d posicionAbierta;

    public PuertaConColision(float ancho, float alto, float profundo, Vector3d posicion, Appearance apariencia, String nombre, List<ObjetoConColision> listaObstaculos) {
        this.listaObstaculos = listaObstaculos;
        this.posicionCerrada = new Vector3d(posicion);
        this.posicionAbierta = new Vector3d(posicion);
        this.posicionAbierta.x += 1.5; // Mueve la puerta hacia un lado cuando se abre (ajustable)

        tgPuerta = new TransformGroup();
        tgPuerta.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPuerta.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgPuerta.setTransform(t3d);

        Box puerta = new Box(ancho / 2, alto / 2, profundo / 2, apariencia);
        tgPuerta.addChild(puerta);

        colisionPuerta = new ObjetoConColision(nombre, tgPuerta, ancho, profundo);
        listaObstaculos.add(colisionPuerta);
    }

    public TransformGroup getTransformGroup() {
        return tgPuerta;
    }

    public void abrirCerrar() {
        if (abierta) {
            cerrarPuerta();
        } else {
            abrirPuerta();
        }
    }

    private void abrirPuerta() {
        if (listaObstaculos.contains(colisionPuerta)) {
            listaObstaculos.remove(colisionPuerta);
        }
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicionAbierta);
        tgPuerta.setTransform(t3d);
        abierta = true;
    }

    private void cerrarPuerta() {
        if (!listaObstaculos.contains(colisionPuerta)) {
            listaObstaculos.add(colisionPuerta);
        }
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicionCerrada);
        tgPuerta.setTransform(t3d);
        abierta = false;
    }
}
