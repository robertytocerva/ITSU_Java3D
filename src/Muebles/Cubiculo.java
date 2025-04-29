package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.*;
import colisiones.Pared;
import java.util.List;

public class Cubiculo extends BranchGroup {
    TransformGroup tgCubiculo;
private Vector3d posicionBase;
TransformGroup tgPuerta;
private boolean puertaAbierta = false;

    public Cubiculo(List<ObjetoConColision> obstaculos, Vector3d posicion) {
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);

        tgCubiculo = new TransformGroup(t3d);
        tgCubiculo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgCubiculo.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        

        this.posicionBase = posicion;
    
        // Método auxiliar para crear Vector3d relativo a la posición base
        
       tgCubiculo.addChild(Pared.crearPared(3.0f, 1.4f, 0.1f, new Vector3d(-0.5, 1.5, 3.9), Color.setSemiTransparente(0.1f)));///ventana de cubiculo
       tgCubiculo.addChild(Pared.crearPared(1.6f, 1.2f, 0.1f, new Vector3d(-1.0, 1.5, 2.4), Color.setSemiTransparente(0.1f)));///ventana de cubiculo
       tgCubiculo.addChild(Pared.crearPared(1.6f, 1.2f, 0.1f, new Vector3d(-1.0, 1.5, 1.0), Color.setSemiTransparente(0.1f)));///ventana de cubiculo
       
       
       
tgCubiculo.addChild(Pared.crearParedConColision(1.1f, 2.6f, 0.1f, new Vector3d(0.4, 0.7, 0.9), crearApariencia(160, 50, 50), "puertaCubiculo1", obstaculos ));
tgCubiculo.addChild(Pared.crearParedConColision(1.1f, 2.6f, 0.1f, new Vector3d(0.4, 0.7, 2.4), crearApariencia(160, 50, 50), "puertaCubiculo2", obstaculos ));

tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 1.4f, 0.1f, new Vector3d(-0.5, 0.1, 4.0), crearApariencia(155, 80, 15), "ventanaAbajo", obstaculos )); // no tocar
tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f, new Vector3d(-0.5, 2.3, 4.0), crearApariencia(155, 80, 15), "ventanaArriba", obstaculos)); // no tocar
tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f, new Vector3d(-0.5, 2.3, 2.4), crearApariencia(155, 80, 15), "divisorCubiculo1", obstaculos));
tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f, new Vector3d(-0.5, 2.3, 0.9), crearApariencia(155, 80, 15), "divisorCubiculo2", obstaculos));
tgCubiculo.addChild(Pared.crearParedConColision(1.8f, 1.4f, 0.1f, new Vector3d(-1.1, 0.1, 2.4), crearApariencia(155, 80, 15), "paredSeparadora1", obstaculos));
tgCubiculo.addChild(Pared.crearParedConColision(1.8f, 1.4f, 0.1f, new Vector3d(-1.1, 0.1, 0.9), crearApariencia(155, 80, 15), "paredSeparadora2", obstaculos));

tgCubiculo.addChild(Pared.crearParedConColision(0.12f, 2.9f, 0.1f, new Vector3d(-0.2, 1.0, 0.9), crearApariencia(160,160,160), "pilarDelgado1", obstaculos));
tgCubiculo.addChild(Pared.crearParedConColision(0.12f, 2.9f, 0.1f, new Vector3d(-0.2, 1.0, 2.4), crearApariencia(160,160,160), "pilarDelgado2", obstaculos));

tgCubiculo.addChild(Pared.crearParedConColision(0.12f, 2.9f, 0.1f, new Vector3d(-1.9, 1.0, 0.9), crearApariencia(160,160,160), "pilarDelgado3", obstaculos));
tgCubiculo.addChild(Pared.crearParedConColision(0.12f, 2.9f, 0.1f, new Vector3d(-1.9, 1.0, 2.4), crearApariencia(160,160,160), "pilarDelgado4", obstaculos));

        // Primer par (Z positivo)
Vector3d posMesa = new Vector3d(-1.2, 0.05, 3.2);
Vector3d posSilla = new Vector3d(-1.35, 0.05, 3.2); // más cerca de la mesa

Mesa mesa = new Mesa(posMesa);
Silla silla = new Silla(posSilla,obstaculos );

// Mesa
TransformGroup tgMesa = mesa.getTransformGroup();
Transform3D transformMesa = new Transform3D();
Transform3D rotacionMesa = new Transform3D();
rotacionMesa.rotY(Math.PI / 2);
transformMesa.setTranslation(posMesa);
transformMesa.mul(rotacionMesa);
tgMesa.setTransform(transformMesa);

// Silla
TransformGroup tgSilla = silla.getTransformGroup();
Transform3D transformSilla = new Transform3D();
Transform3D rotacionSilla = new Transform3D();
rotacionSilla.rotY(Math.PI / 2);
transformSilla.setTranslation(posSilla);
transformSilla.mul(rotacionSilla);
tgSilla.setTransform(transformSilla);

// Segundo par (Z negativo)
Vector3d posMesa2 = new Vector3d(-1.2, 0.05, 1.8);
Vector3d posSilla2 = new Vector3d(-1.35, 0.05, 1.8); // igual de cerca

Mesa mesa2 = new Mesa(posMesa2);
Silla silla2 = new Silla(posSilla2,obstaculos);

// Mesa 2
TransformGroup tgMesa2 = mesa2.getTransformGroup();
Transform3D transformMesa2 = new Transform3D();
Transform3D rotacionMesa2 = new Transform3D();
rotacionMesa2.rotY(Math.PI / 2);
transformMesa2.setTranslation(posMesa2);
transformMesa2.mul(rotacionMesa2);
tgMesa2.setTransform(transformMesa2);

// Silla 2
TransformGroup tgSilla2 = silla2.getTransformGroup();
Transform3D transformSilla2 = new Transform3D();
Transform3D rotacionSilla2 = new Transform3D();
rotacionSilla2.rotY(Math.PI / 2);
transformSilla2.setTranslation(posSilla2);
transformSilla2.mul(rotacionSilla2);
tgSilla2.setTransform(transformSilla2);

// Añadir a la escena
tgCubiculo.addChild(tgMesa);
tgCubiculo.addChild(tgSilla);
tgCubiculo.addChild(tgMesa2);
tgCubiculo.addChild(tgSilla2);
this.addChild(tgCubiculo); 
    }
    private Vector3d rel(double x, double y, double z) {
        return new Vector3d(posicionBase.x + x, posicionBase.y + y, posicionBase.z + z);
    }

    private Appearance crearApariencia(int r, int g, int b) {
        Appearance apariencia = new Appearance();
        ColoringAttributes colorAttr = new ColoringAttributes();
        colorAttr.setColor(new Color3f(r / 255f, g / 255f, b / 255f));
        apariencia.setColoringAttributes(colorAttr);
        return apariencia;
    }

public void abrirPuerta() {
    if (puertaAbierta) {
        girarPuerta(tgPuerta, -90, "Y");
    } else {
        girarPuerta(tgPuerta, 90, "Y");
    }
    puertaAbierta = !puertaAbierta;
}

public void girarPuerta(TransformGroup tg, int grados, String eje) {
    Transform3D leer = new Transform3D();
    Transform3D mover = new Transform3D();
    
    tg.getTransform(leer);
    double angulo = Math.PI / 180 * grados;

    if (eje.equalsIgnoreCase("X")) mover.rotX(angulo);
    else if (eje.equalsIgnoreCase("Y")) mover.rotY(angulo);
    else if (eje.equalsIgnoreCase("Z")) mover.rotZ(angulo);

    leer.mul(mover);
    tg.setTransform(leer);
}
    public TransformGroup getTransformGroup() {
        return tgCubiculo;
    }
}
