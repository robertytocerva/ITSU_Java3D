package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.*;
import colisiones.Pared;
import java.util.List;
public class SalonDF extends BranchGroup {

    private TransformGroup tgSalon;
    TransformGroup tgPuerta;
private boolean puertaAbierta = false;

    public SalonDF(boolean conPiso, List<ObjetoConColision> listaObstaculos) {
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        

        if (conPiso) {
            tgSalon.addChild(Pared.crearPared(9.3f, 0.25f, 6.0f, new
                    Vector3d(1.5, -0.2, 0.0), crearApariencia(160, 160, 160)));
                 
        }
        tgSalon.addChild(Pared.crearParedConColision(1.3f, 2.2f, 0.1f, new
                Vector3d(2.5, 1.1, 2.6), crearApariencia(164, 45, 2), "puertaNuevaDer", listaObstaculos));
       
        // Pared trasera (nuevo pizarrón)
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new
                Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "paredPizarron", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(3.0f, 1.4f, 0.2f, new
                Vector3d(0.0, 1.8, 2.9), crearApariencia(255, 255, 255), "pizarronCentro", listaObstaculos));

        // Pared derecha (donde ahora va la puerta)
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarPuertaDer1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 4.3f, new
                Vector3d(3.0, 1.5, -0.8), crearApariencia(228, 199, 124), "paredLargaPuertaDer", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new
                Vector3d(2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarFrontalDer", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.8f, 1.3f, new
                Vector3d(3.0, 2.6, 2.0), crearApariencia(228, 199, 124), "puertaSuperiorDer", listaObstaculos));

        // Pared izquierda reflejada (Z invertido)
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f, new
                Vector3d(-3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredInferiorIzq", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new
                Vector3d(-2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentroIzq", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f, new
                Vector3d(-3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredSuperiorIzq", listaObstaculos));

        // Pared del frente (ahora al fondo)
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new
                Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFrontal", listaObstaculos));

        // Ventanas reflejadas
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
                Vector3d(-3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventanaRef1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
                Vector3d(-3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaRef2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
                Vector3d(-3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventanaRef3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
                Vector3d(-3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaRef4", listaObstaculos));

        // Pilas reflejadas también
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarRef1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarRef2", listaObstaculos));


        Vector3d[] posiciones = {
            // Columna izquierda (sin cambio)
            new Vector3d(-2.3, 0.9, -2.0), new Vector3d(-1.3, 0.9, -2.0),
            new Vector3d(-2.3, 0.9, -0.7), new Vector3d(-1.3, 0.9, -0.7),
            new Vector3d(-2.3, 0.9, 0.6),  new Vector3d(-1.3, 0.9, 0.6),

            // Columna derecha (pegadas más a la pared)
            new Vector3d(1.5, 0.9, -2.0), new Vector3d(2.5, 0.9, -2.0),
            new Vector3d(1.5, 0.9, -0.7), new Vector3d(2.5, 0.9, -0.7),
            new Vector3d(1.5, 0.9, 0.6),  new Vector3d(2.5, 0.9, 0.6)
        };


        for (Vector3d pos : posiciones) {
            Vector3d posMesa = new Vector3d(pos.x, 0.05, pos.z - 0.4);
            Vector3d posSilla = new Vector3d(pos.x, 0.05, pos.z - 0.6);

            Mesa mesa = new Mesa(posMesa);
            Silla silla = new Silla(posSilla,listaObstaculos);

            tgSalon.addChild(mesa.getTransformGroup());
            tgSalon.addChild(silla.getTransformGroup());
        }
       

        Vector3d posMesaContraria = new Vector3d(2.0, 0.05, -2.0); 
        Vector3d posSillaContraria = new Vector3d(2.0, 0.05, -2.0); 

        Mesa mesaContraria = new Mesa(posMesaContraria);
        Silla sillaContraria = new Silla(posSillaContraria,listaObstaculos);

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
