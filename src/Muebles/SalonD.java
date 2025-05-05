package Muebles;
import ESCENARIO.Color;

import colisiones.ObjetoConColision;

import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import colisiones.Pared;

import java.util.List;

public class SalonD extends BranchGroup{
    private TransformGroup tgSalon;


    public SalonD(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
    tgSalon = new TransformGroup();
    tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 
    
    tgSalon.addChild(Pared.crearPared(100.0f, 0.1f, 100.0f,
            new Vector3d(1.5, -3.3, 0.0), crearApariencia(160, 160, 160)));


    tgSalon.addChild(Pared.crearParedConColision(6.0f, 0.46f, 6.0f, new
            Vector3d(0.0, -0.2, 0.0), crearApariencia(160, 160, 160), "pared derecha",
            listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new
            Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "paredFondo",
            listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
            Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilar1",
            listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 4.3f, new
            Vector3d(-3.0, 1.5, -0.8), crearApariencia(228, 199, 124), "paredLateral",
            listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.8f, 1.3f, new
            Vector3d(-3.0, 2.6, 2.0), crearApariencia(228, 199, 124), "puertaArriba",
            listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new
            Vector3d(-2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentralIzq",
            listaObstaculos));


// Pared del frente (amarilla)
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new
            Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFrente", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(3.0f, 1.4f, 0.2f, new
            Vector3d(0.0, 1.8, 2.9), crearApariencia(255, 255, 255), "ventanaFrontal", listaObstaculos));


     //Pared derecha (azul)
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f, new
            Vector3d(3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredAbajo", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new
            Vector3d(2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentralDer", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f, new
            Vector3d(3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredArriba", listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
            Vector3d(3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventana1", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
            Vector3d(3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventana2", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
            Vector3d(3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventana3", listaObstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new
            Vector3d(3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventana4", listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
            Vector3d(3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilar2", listaObstaculos));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
            Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilar3", listaObstaculos));

    Vector3d[] posiciones = {
        // Columna izquierda (pegada a la pared izquierda)
        new Vector3d(-2.3, 0.9, -2.0), new Vector3d(-1.3, 0.9, -2.0),
        new Vector3d(-2.3, 0.9, -0.7), new Vector3d(-1.3, 0.9, -0.7),
        new Vector3d(-2.3, 0.9, 0.6),  new Vector3d(-1.3, 0.9, 0.6),

        // Columna derecha (pegada a la pared derecha)
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
    

        Vector3d posMesaContraria = new Vector3d(-2.0, 0.05, -2.0); 
        Vector3d posSillaContraria = new Vector3d(-2.0, 0.05, -2.0); 

        Mesa mesaContraria = new Mesa(posMesaContraria);
        Silla sillaContraria = new Silla(posSillaContraria, listaObstaculos);

        // Rotar mesa y silla contraria
        Transform3D transform = new Transform3D();
        transform.setRotation(new AxisAngle4d(0.0, 1.0, 0.0, Math.PI));
        TransformGroup tgContrario = new TransformGroup(transform);
        tgContrario.addChild(mesaContraria.getTransformGroup());
        tgContrario.addChild(sillaContraria.getTransformGroup());

        
        
   if (conPiso) {
    tgSalon.addChild(Pared.crearPared(100.0f, 0.1f, 100.0f, new Vector3d(-1.5, -0.1, 0.0),
            crearApariencia(160, 160, 160)));
    }
   
    tgSalon.addChild(Pared.crearPared(1.3f, 2.2f, 0.1f, new Vector3d(-2.4, 1.1, 2.6),
            crearApariencia(164, 45, 2)));

    
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
}

