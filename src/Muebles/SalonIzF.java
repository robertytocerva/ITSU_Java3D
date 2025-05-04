package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.*;
import colisiones.Pared;
import colisiones.Tope;
import java.util.List;

public class SalonIzF extends BranchGroup {

    private TransformGroup tgSalon;

    public SalonIzF(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
        
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
     

        
        
        Tope miTope = new Tope(new Vector3d(0.0, 1.5, 3.0), 6.0f, 3.0f, 0.1f, listaObstaculos);
        Tope miTope2 = new Tope(new Vector3d(3.0, 0.5, 0.0), 0.1f, 1.0f, 6.0f, listaObstaculos);
       
        tgSalon.addChild(miTope.getTransformGroup());
        tgSalon.addChild(miTope2.getTransformGroup());

        Tope miTope3 = new Tope(new Vector3d(0.0, 1.5, -3.0), 6.0f, 3.0f, 0.1f, listaObstaculos);
        tgSalon.addChild(miTope3.getTransformGroup());

        
        Tope miTopePilar1 = new Tope(new Vector3d(4.7, 1.5, -9.1), 0.1f, 3.0f, 0.3f, listaObstaculos);
        tgSalon.addChild(miTopePilar1.getTransformGroup());



        
        
        
        

        tgSalon.addChild(Pared.crearPared(3.0f, 1.4f, 0.2f, new Vector3d(0.5, 1.8, -2.9), crearApariencia(255, 255, 255)));
        tgSalon.addChild(Pared.crearPared(6.0f, 3.0f, 0.1f, new Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116)));

        tgSalon.addChild(Pared.crearPared(0.1f, 3.0f, 0.3f, new Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124)));
        tgSalon.addChild(Pared.crearPared(0.1f, 3.0f, 4.3f, new Vector3d(-3.0, 1.5, 0.8), crearApariencia(228, 199, 124)));


        tgSalon.addChild(Pared.crearPared(0.4f, 2.8f, 0.90f, new Vector3d(-2.8, 1.3, 0.0), crearApariencia(240, 210, 135)));


        tgSalon.addChild(Pared.crearPared(0.1f, 1.0f, 6.0f, new Vector3d(3.0, 0.5, 0.0), crearApariencia(228, 199, 124)));


        tgSalon.addChild(Pared.crearPared(0.4f, 3.0f, 0.90f, new Vector3d(2.8, 1.5, 0.0), crearApariencia(240, 210, 135)));
        tgSalon.addChild(Pared.crearPared(0.1f, 0.6f, 6.0f, new Vector3d(3.0, 2.7, 0.0), crearApariencia(228, 199, 124)));


        tgSalon.addChild(Pared.crearPared(6.0f, 3.0f, 0.1f, new Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116)));
        tgSalon.addChild(Pared.crearPared(3.0f, 1.4f, 0.2f, new Vector3d(0.0, 1.8, -2.9), crearApariencia(255, 255, 255)));


        tgSalon.addChild(Pared.crearPared(0.1f, 1.4f, 1.1f, new Vector3d(3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f)));
        tgSalon.addChild(Pared.crearPared(0.1f, 1.4f, 1.1f, new Vector3d(3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f)));
        tgSalon.addChild(Pared.crearPared(0.1f, 1.4f, 1.1f, new Vector3d(3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f)));
        tgSalon.addChild(Pared.crearPared(0.1f, 1.4f, 1.1f, new Vector3d(3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f)));


        tgSalon.addChild(Pared.crearPared(0.1f, 3.0f, 0.3f, new Vector3d(3.0, 1.5, -2.8), crearApariencia(228, 199, 124)));
        tgSalon.addChild(Pared.crearPared(0.1f, 3.0f, 0.3f, new Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124)));

            Vector3d[] posiciones = {
            // Lado derecho (positivo)
            new Vector3d(2.5, 0.9, -2.0), new Vector3d(1.5, 0.9, -2.0),
            new Vector3d(2.5, 0.9, -0.7), new Vector3d(1.5, 0.9, -0.7),
            new Vector3d(2.5, 0.9, 0.6),  new Vector3d(1.5, 0.9, 0.6),

            // Lado izquierdo (negativo)
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

        // Mesa y silla contraria reflejada (ajustada en Z también)
        Vector3d posMesaContraria = new Vector3d(2.0, 0.1, -2.0);
        Vector3d posSillaContraria = new Vector3d(2.0, 0.1, -2.0);

        Mesa mesaContraria = new Mesa(posMesaContraria);
        Silla sillaContraria = new Silla(posSillaContraria,listaObstaculos);

        TransformGroup tgContrario = new TransformGroup(); // sin rotación, mira hacia las sillas
        tgContrario.addChild(mesaContraria.getTransformGroup());
        tgContrario.addChild(sillaContraria.getTransformGroup());

        tgSalon.addChild(Pared.crearPared(1.3f, 2.2f, 0.1f, new Vector3d(-2.4, 1.1, -2.6),
                crearApariencia(164, 45, 2)));
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
