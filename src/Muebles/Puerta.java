package Muebles;

import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Puerta {
    private TransformGroup tgPadre;
    private TransformGroup tgPuerta;
    private boolean estaAbierta = false;
    private Transform3D transformInicial;

    public Puerta(Vector3d posicionPivote, Vector3d desplazamientoPuerta) {

        tgPadre = new TransformGroup();
        tgPadre.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPadre.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);


        Transform3D t3dPadre = new Transform3D();
        t3dPadre.setTranslation(posicionPivote);
        tgPadre.setTransform(t3dPadre);


        tgPuerta = new TransformGroup();
        Transform3D t3dPuerta = new Transform3D();
        t3dPuerta.setTranslation(desplazamientoPuerta);
        tgPuerta.setTransform(t3dPuerta);

        Appearance apariencia = new Appearance();
        Box puerta = new Box(0.65f, 1.1f, 0.05f, apariencia);
        tgPuerta.addChild(puerta);

        tgPadre.addChild(tgPuerta);

        transformInicial = new Transform3D();
        tgPadre.getTransform(transformInicial);
    }

    public void abrirCerrar() {
        try {
            Transform3D transform = new Transform3D();
            tgPadre.getTransform(transform);

            Transform3D rotacion = new Transform3D();
            if (estaAbierta) {
                // Cerrar
                rotacion.rotY(Math.toRadians(-90));
            } else {
                // Abrir
                rotacion.rotY(Math.toRadians(90));
            }

            transform.mul(rotacion);
            tgPadre.setTransform(transform);

            estaAbierta = !estaAbierta;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public TransformGroup getTransformGroup() {
        return tgPadre;
    }
}
