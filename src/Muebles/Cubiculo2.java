
package Muebles;

import colisiones.ObjetoConColision;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class Cubiculo2 extends BranchGroup {
    TransformGroup tgCubiculo;
    TransformGroup tgPuerta;
    private boolean puertaAbierta = false;

    public Cubiculo2(List<ObjetoConColision> listaObstaculos) {
        tgCubiculo = new TransformGroup();
        tgCubiculo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        

        tgCubiculo.addChild(Pared.crearPared(1.1f, 2.6f, 0.1f,
                new Vector3d(0.4, 0.7, 2.4), crearApariencia(160, 50, 50)));
        tgCubiculo.addChild(Pared.crearPared(1.1f, 2.6f, 0.1f,
                new Vector3d(0.4, 0.7, 4.0), crearApariencia(160, 50, 50)));


        tgCubiculo.addChild(Pared.crearPared(2.9f, 0.5f, 0.1f,
                new Vector3d(-0.5, 2.3, 2.4), crearApariencia(155, 80, 15)));
        tgCubiculo.addChild(Pared.crearPared(1.8f, 1.4f, 0.1f,
                new Vector3d(-1.1, 0.1, 2.4), crearApariencia(155, 80, 15)));
        tgCubiculo.addChild(Pared.crearPared(0.12f, 2.9f, 0.1f,
                new Vector3d(-0.2, 1.0, 2.4), crearApariencia(160,160,160)));
        tgCubiculo.addChild(Pared.crearPared(0.12f, 2.9f, 0.1f,
                new Vector3d(-1.9, 1.0, 2.4), crearApariencia(160,160,160)));

        tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 1.4f, 0.1f,
                new Vector3d(-0.5, 0.1, 0.9), crearApariencia(155, 80, 15),"cb",listaObstaculos));
        tgCubiculo.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f,
                new Vector3d(-0.5, 2.3, 0.9), crearApariencia(155, 80, 15),"cb",listaObstaculos));

        tgCubiculo.addChild(Pared.crearPared(0.12f, 2.9f, 0.1f,
                new Vector3d(-1.9, 1.0, 4.0), crearApariencia(160,160,160))); // delgado
        tgCubiculo.addChild(Pared.crearPared(0.12f, 2.9f, 0.1f,
                new Vector3d(-0.2, 1.0, 4.0), crearApariencia(160,160,160))); // delgado==
        tgCubiculo.addChild(Pared.crearPared(2.9f, 0.5f, 0.1f,
                new Vector3d(-0.5, 2.3, 4.0), crearApariencia(155, 80, 15)));//divisor de cubiculos  ===
        tgCubiculo.addChild(Pared.crearPared(1.8f, 1.4f, 0.1f,
                new Vector3d(-1.1, 0.1, 4.0), crearApariencia(155, 80, 15))); //pared serapadaorsa

        // Primer par (Z positivo)
        Vector3d posMesa = new Vector3d(-1.2, 0.05, 3.2);
        Vector3d posSilla = new Vector3d(-1.35, 0.05, 3.2); // más cerca de la mesa

        Mesa mesa = new Mesa(posMesa);
        Silla silla = new Silla(posSilla,listaObstaculos);

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
        Vector3d posSilla2 = new Vector3d(-1.35, 0.05, 1.8);

        Mesa mesa2 = new Mesa(posMesa2);
        Silla silla2 = new Silla(posSilla2,listaObstaculos);

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
