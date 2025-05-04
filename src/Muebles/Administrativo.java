
package Muebles;


import ESCENARIO.Color;

import colisiones.ObjetoConColision;
import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class Administrativo {


     private TransformGroup tgSalon;
     TransformGroup tgPuerta;
    private boolean puertaAbierta = false;
     
    public Administrativo(boolean conPiso,List<ObjetoConColision> obstaculos) {
    tgSalon = new TransformGroup();
    tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 
    

   if (conPiso) {

        tgSalon.addChild(Pared.crearPared(09.0f, 0.50f, 25.0f,
                new Vector3d(-1.5, -0.2, 0.0), crearApariencia(160, 160, 160)));///////////ACTIVAR PISO SEGUNDA PLANTA
   }

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 2.2f, 1.3f,
            new Vector3d(-3.0, 1.1, 2.0), crearApariencia(164, 45, 2), "puertaIzq", obstaculos));/////////puerta


    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "paredFondo", obstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
            new Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarIzq1", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 4.3f,
            new Vector3d(-3.0, 1.5, -0.8), crearApariencia(228, 199, 124), "paredLargaIzq", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.8f, 1.3f,
            new Vector3d(-3.0, 2.6, 2.0), crearApariencia(228, 199, 124), "puertaArribaIzq", obstaculos));


    tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 8.0f,
            new Vector3d(3.1, 2.7, 0.0), crearApariencia(228, 199, 124), "paredArribaDer", obstaculos));///////posible linea  a utilizar para exteriores

    // Pared del frente (amarilla)
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFrontal", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(3.0f, 1.4f, 0.2f,
            new Vector3d(0.0, 1.8, 2.9), crearApariencia(255, 255, 255), "pizarron", obstaculos));

    // Ventanas
    Appearance aparienciaVentana = Color.setSemiTransparente(0.8f);
    tgSalon.addChild(Pared.crearParedConColision(
        0.1f, 1.4f, 1.1f,
        new Vector3d(3.0, 1.7, -2.1),
        aparienciaVentana,
        "ventana1",
        obstaculos
    ));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 7.0f,
            new Vector3d(3.1, -0.1, 0.1), crearApariencia(255,255,255), "paredAbajoDer", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 2.7f, 3.0f,
            new Vector3d(3.3, 1.2, -1.6), Color.setSemiTransparente(0.20f),"ventana2", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 2.7f, 3.0f,
            new Vector3d(3.3, 1.2, 1.5), Color.setSemiTransparente(0.20f), "ventana4", obstaculos));

            Vector3d posMesaContraria = new Vector3d(-2.0, 0.05, -2.0);
            Vector3d posSillaContraria = new Vector3d(-2.0, 0.05, -2.0);

            Mesa mesaContraria = new Mesa(posMesaContraria);
            Silla sillaContraria = new Silla(posSillaContraria,obstaculos);

            // Rotar mesa y silla contraria
            Transform3D transform = new Transform3D();
            transform.setRotation(new AxisAngle4d(0.0, 1.0, 0.0, Math.PI));
            TransformGroup tgContrario = new TransformGroup(transform);
            tgContrario.addChild(mesaContraria.getTransformGroup());
            tgContrario.addChild(sillaContraria.getTransformGroup());

            tgSalon.addChild(tgContrario);
        }


        private Appearance crearApariencia(int r, int g, int b) {
        Appearance apariencia = new Appearance();
        ColoringAttributes colorAttr = new ColoringAttributes();
        colorAttr.setColor(new Color3f(r / 255f, g / 255f, b / 255f));
        apariencia.setColoringAttributes(colorAttr);
        return apariencia;
    }

        public TransformGroup getTransformGroup() {
            return tgSalon;
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
}
