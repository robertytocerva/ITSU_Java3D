package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import javax.media.j3d.*;
import javax.vecmath.*;
import colisiones.Pared;
import java.util.List;
public class SalonIz extends BranchGroup {

    private TransformGroup tgSalon;
    


    public SalonIz(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       

        if (conPiso) {
            tgSalon.addChild(Pared.crearPared(09.0f, 0.46f, 25.0f, new Vector3d(1.5,-0.2, 0.0), crearApariencia(160, 160, 160)));
        }
        
        
        
        // Pared trasera (nuevo pizarrón)

        tgSalon.addChild(Pared.crearParedConColision(1.3f, 2.2f, 0.1f,
                new Vector3d(2.4, 1.1, -2.6), crearApariencia(164, 45, 2), "puertaRder", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
                new Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "prd", listaObstaculos));


        // Pared derecha reflejada (Z invertido)
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilard1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 4.3f,
                new Vector3d(3.0, 1.5, 0.8), crearApariencia(228, 199, 124), "paredLargad", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f,
                new Vector3d(2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarFd", listaObstaculos));


        // Pared izquierda reflejada (Z invertido)
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f,
                new Vector3d(-3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredInfIIz", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f,
                new Vector3d(-2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentro", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f,
                new Vector3d(-3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredSupIzq", listaObstaculos));

        // Pared del frente (ahora al fondo)
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
                new Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFront", listaObstaculos));

        // Ventanas reflejadas
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventana1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaR", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventana3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaR4", listaObstaculos));

        // Pilas reflejadas también
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarR3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarR4", listaObstaculos));

        // Mesas y sillas reflejadas hacia atrás (Z invertido)
        Vector3d[] posiciones = {
        // Columna derecha reflejada (pegada pared, valores positivos)
        new Vector3d(2.5, 0.9, -2.0), new Vector3d(1.5, 0.9, -2.0),
        new Vector3d(2.5, 0.9, -0.7), new Vector3d(1.5, 0.9, -0.7),
        new Vector3d(2.5, 0.9, 0.6),  new Vector3d(1.5, 0.9, 0.6),

        // Columna izquierda reflejada (valores negativos)
        new Vector3d(-1.3, 0.9, -2.0), new Vector3d(-2.3, 0.9, -2.0),
        new Vector3d(-1.3, 0.9, -0.7), new Vector3d(-2.3, 0.9, -0.7),
        new Vector3d(-1.3, 0.9, 0.6),  new Vector3d(-2.3, 0.9, 0.6)
        };


        for (Vector3d pos : posiciones) {
            Vector3d posMesa = new Vector3d(pos.x - 0.2, 0.03, -pos.z - 0.5);
            Vector3d posSilla = new Vector3d(pos.x, 0.05, -pos.z - 1.8);
            
            Mesa mesa = new Mesa(posMesa);
            Silla silla = new Silla(posSilla,listaObstaculos);

            tgSalon.addChild(mesa.getTransformGroup());

            // Voltear silla hacia pizarrón
           Transform3D rotSilla = new Transform3D();
            rotSilla.setRotation(new AxisAngle4d(0, 1, 0, Math.PI));
            TransformGroup tgSilla = new TransformGroup(rotSilla);
            tgSilla.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            tgSilla.addChild(silla.getTransformGroup());

            tgSalon.addChild(tgSilla);
        }


        Vector3d posMesaContraria = new Vector3d(-2.0, 0.1, -2.0);
        Vector3d posSillaContraria = new Vector3d(-2.0, 0.1, -2.0);

       Mesa mesaContraria = new Mesa(posMesaContraria);
        Silla sillaContraria = new Silla(posSillaContraria,listaObstaculos);

        TransformGroup tgContrario = new TransformGroup(); // sin rotación, mira hacia las sillas
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
}
