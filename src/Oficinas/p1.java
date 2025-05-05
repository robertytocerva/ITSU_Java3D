package Oficinas;

import ESCENARIO.Color;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import Muebles.Mesa;
import Muebles.Silla;
import colisiones.ObjetoConColision;
import colisiones.Pared;

import java.util.List;



public class p1 {
    
     private TransformGroup tgSalon;
     public p1(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
         tgSalon = new TransformGroup();
         tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

         if (conPiso) {

            tgSalon.addChild(crearPared(09.0f, 0.46f, 25.0f,
                    new Vector3d(-1.5, -0.2, 0.0), crearApariencia(160, 160, 160)));
         }

         tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 3.7f,
                 new Vector3d(-3.0, 1.5, -1.1), crearApariencia(228, 199, 124), "paredLargaIzqPilar", listaObstaculos));

         tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f,
                 new Vector3d(-3.0, 1.5, 0.3), crearApariencia(240, 210, 135), "pilarIzquierdo", listaObstaculos));



        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f,
                new Vector3d(3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredInferiorDer", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.90f,
                new Vector3d(2.9, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentroDer", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f,
                new Vector3d(3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredSuperiorDer", listaObstaculos));

        // Ventanas
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventanaDer1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaDer2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventanaDer3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaDer4", listaObstaculos));

        // Pilas delgadas a los lados
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarPuertaDer1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarPuertaDer2", listaObstaculos));


         tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                 Vector3d(3.0, 1.5, -2.8), crearApariencia(240, 210, 135), "pilarPuertaDerExt1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new
                Vector3d(3.0, 1.5, 2.8), crearApariencia(240, 210, 135), "pilarPuertaDerExt2", listaObstaculos));

        // Paredes café (tipo divisor)
        tgSalon.addChild(Pared.crearParedConColision(5.8f, 1.4f, 0.1f, new
                Vector3d(0.1, 0.8, -1.1), crearApariencia(155, 80, 15), "paredCafeInferior", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(5.8f, 0.4f, 0.1f, new
                Vector3d(0.1, 2.9, -1.1), crearApariencia(155, 80, 15), "paredCafeSuperior", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 12.0f, new
                Vector3d(2.7, 0.8, 3.1), crearApariencia(155, 80, 15), "paredLateralCafe", listaObstaculos));





        TransformGroup tgCubiculosExtras = new TransformGroup();

        double baseX2 = -0.4;
        double separacionX = 0.9;
        double distanciaFrenteEspalda = 1.3;

        Vector3d[] posicionesCubiculos = {
            new Vector3d(baseX2, 0.6, 2.6),
            new Vector3d(baseX2 + separacionX, 0.6, 2.6),
            new Vector3d(baseX2, 0.6, 2.6 + distanciaFrenteEspalda),
            new Vector3d(baseX2 + separacionX, 0.6, 2.6 + distanciaFrenteEspalda)
        };

        boolean[] esEspalda = {false, false, true, true};
        for (int i = 0; i < posicionesCubiculos.length; i++) {
            Vector3d base = posicionesCubiculos[i];

            // Mesa y silla
            Vector3d posMesa = new Vector3d(base);
            Vector3d posSilla = new Vector3d(base);
            posSilla.z += esEspalda[i] ? -0.2 : 0.35;

            Mesa mesa = new Mesa(posMesa);
            Silla silla = new Silla(posSilla, listaObstaculos);

            Transform3D rotacionSilla = new Transform3D();
            if (esEspalda[i]) rotacionSilla.rotY(Math.PI);



            TransformGroup tgPar = new TransformGroup();
            tgPar.addChild(mesa.getTransformGroup());


            // Separadores
            float alto = 1.9f;
            float grosor = 0.1f;
            float prof = 1.8f;

            tgPar.addChild(Pared.crearPared(grosor, alto, prof,
                    new Vector3d(base.x - 0.6, 0.7, base.z), crearApariencia(155, 80, 15)));
            tgPar.addChild(Pared.crearPared(grosor, alto, prof,
                    new Vector3d(base.x + 0.6, 0.7, base.z), crearApariencia(155, 80, 15)));

            double offsetFondo = esEspalda[i] ? -0.55 : 0.55;
            tgPar.addChild(Pared.crearPared(0.8f, alto, grosor,
                    new Vector3d(base.x, 0.7, base.z + offsetFondo), crearApariencia(155, 80, 15)));

            tgCubiculosExtras.addChild(tgPar);
        }

        tgSalon.addChild(tgCubiculosExtras);

        float ancho = 0.1f;
        float alto = 3.0f;
        float profundo = 0.1f;

        float distancia = 1.2f; // separación entre paredes
        float inicioX = -0.9f;    // posición inicial en X
        float inicioZ = 2.3f;    // posición inicial en Z

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                double x = inicioX + col * distancia;
                double z = inicioZ + fila * distancia;

                Vector3d posicion = new Vector3d(x, 1.5, z); // Y fijo en 1.5
                tgSalon.addChild(Pared.crearPared(ancho, alto, profundo, posicion, crearApariencia(160, 160, 160)));
            }
            tgSalon.addChild(Pared.crearParedConColision(3.3f, 0.4f, 0.1f,
                    new Vector3d(0.0, 2.9, 2.1), crearApariencia(155, 80, 15), "paredCafeSuperior", listaObstaculos));
            tgSalon.addChild(Pared.crearParedConColision(3.4f, 0.4f, 0.1f,
                    new Vector3d(0.1, 2.9, 4.8), crearApariencia(155, 80, 15), "paredCafeSuperior", listaObstaculos));
            tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.4f, 3.0f,
                    new Vector3d(-1.1, 2.9,3.5), crearApariencia(155, 80, 15), "paredCafeSuperior", listaObstaculos));
            tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.4f, 3.0f,
                    new Vector3d(1.8, 2.9,3.5), crearApariencia(155, 80, 15), "paredCafeSuperior", listaObstaculos));
        }




        TransformGroup tgContrario = new TransformGroup();
        double separacion = 1.8;
        int totalMesas = 3;
        double baseX = -2.0;
        double baseY = 0.1;
        double baseZ = -2.0;

        double offsetZ = -0.6;

        for (int i = 0; i < totalMesas; i++) {
            double offsetX = baseX + i * separacion;

            Vector3d posMesa = new Vector3d(offsetX, baseY, baseZ + offsetZ);
            Vector3d posSilla = new Vector3d(offsetX, baseY, baseZ + offsetZ);

            Mesa mesa = new Mesa(posMesa);
            Silla silla = new Silla(posSilla, listaObstaculos);

            tgContrario.addChild(mesa.getTransformGroup());
            tgContrario.addChild(silla.getTransformGroup());

            if (i < totalMesas - 1) {
                double pilarX = offsetX + (separacion / 2);
                Vector3d posPilar = new Vector3d(pilarX, 1.5, -1.1); // Y=1.5 es el centro vertical
                tgSalon.addChild(crearPared(0.1f, 3.0f, 0.3f, posPilar, crearApariencia(228, 199, 124))); // Pilar más delgado
            }
            if (i < totalMesas - 1) {
            double pilarX = offsetX + (separacion / 2);

            // Pilar ALTO entre sillas
            Vector3d posPilarAlto = new Vector3d(pilarX, 1.5, -1.1);
            tgSalon.addChild(crearPared(0.1f, 3.0f, 0.3f, posPilarAlto, crearApariencia(160,160,160)));

            // Pilar BAJO entre mesas (más ancho y más atrás)
            Vector3d posPilarBajo = new Vector3d(pilarX, 0.75, -2.0); // más atrás (Z), centrado en Y
            tgSalon.addChild(crearPared(0.1f, 1.5f, 1.5f, posPilarBajo, crearApariencia(200, 180, 100)));
            }
        }
        tgSalon.addChild(tgContrario);
     }
    
    private TransformGroup crearPared(float ancho, float alto, float profundo, Vector3d posicion, Appearance apariencia) {
        TransformGroup tgPared = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgPared.setTransform(t3d);

        Box pared = new Box(ancho / 2, alto / 2, profundo / 2, apariencia);
        tgPared.addChild(pared);

        return tgPared;
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
