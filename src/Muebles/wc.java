package Muebles;

import ESCENARIO.Color;
import Muebles.Inodoro;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class wc extends BranchGroup {
    private TransformGroup tgSalon;
    private Vector3d posicionBase;

    public wc(List<ObjetoConColision> listaObstaculos, Vector3d posicion) {
       this.posicionBase = new Vector3d(0.0, 0.0, 0.0);

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);

        tgSalon = new TransformGroup(t3d);
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        // Piso
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 0.46f, 6.0f,
                new Vector3d(0.0, -0.2, 0.0), crearApariencia(160, 160, 160), "piso", listaObstaculos));

        // Paredes principales y puertas
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
                new Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "paredFondo", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(1.3f, 2.2f, 0.1f,
                new Vector3d(2.4, 1.1, 1.5), crearApariencia(164, 45, 2), "puerta1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(1.3f, 2.2f, 0.1f,
                new Vector3d(2.4, 1.1, -1.4), crearApariencia(164, 45, 2), "puerta2", listaObstaculos));

        // Pared derecha (con pilares y superiores)
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilar1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 2.7f,
                new Vector3d(3.0, 1.5, 0.0), crearApariencia(228, 199, 124), "paredLateralD", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.8f, 1.3f,
                new Vector3d(3.0, 2.6, 2.0), crearApariencia(228, 199, 124), "puertaSup1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.45f,
                new Vector3d(3.0, 1.5, -2.9), crearApariencia(228, 199, 124), "pilar2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.8f, 1.4f,
                new Vector3d(3.0, 2.6, -2.0), crearApariencia(228, 199, 124), "puertaSup2", listaObstaculos));

        // Separadores y divisiones internas
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.50f,
                new Vector3d(0.0, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentro", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 3.5f,
                new Vector3d(1.2, 1.5, 0.0), crearApariencia(228, 199, 124), "cabina1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 3.5f,
                new Vector3d(0.0, 1.5, 0.0), crearApariencia(228, 199, 124), "cabina2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 3.5f,
                new Vector3d(-1.2, 1.5, 0.0), crearApariencia(228, 199, 124), "cabina3", listaObstaculos));

        // Inodoros (sin colisión, decorativos)
       tgSalon.addChild(new Inodoro(rel(-2.0, 0.0, 1.0), listaObstaculos).getTransformGroup());
        tgSalon.addChild(new Inodoro(rel(-0.7, 0.0, 1.0), listaObstaculos).getTransformGroup());
        tgSalon.addChild(new Inodoro(rel(0.7, 0.0, 1.0), listaObstaculos).getTransformGroup());

        Transform3D r180 = new Transform3D();
        r180.rotY(Math.PI);
        tgSalon.addChild(rotado(new Inodoro(rel(-0.6, 0.0, 1.0), listaObstaculos), r180));
        tgSalon.addChild(rotado(new Inodoro(rel(0.7, 0.0, 1.0), listaObstaculos), r180));
        tgSalon.addChild(rotado(new Inodoro(rel(2.0, 0.0, 1.0), listaObstaculos), r180));


        // Pared izquierda
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f,
                new Vector3d(-3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredIzqAbajo", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f,
                new Vector3d(-3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredIzqArriba", listaObstaculos));

        // Pared frontal
        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
                new Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFrente", listaObstaculos));

        // Ventanas
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, 2.1), Color.setSemiTransparente(0.20f), "ventana1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, 1.0), Color.setSemiTransparente(0.20f), "ventana2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, -2.1), Color.setSemiTransparente(0.20f), "ventana3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(-3.0, 1.7, -1.0), Color.setSemiTransparente(0.20f), "ventana4", listaObstaculos));

        // Más pilares
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarIzq1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarIzq2", listaObstaculos));
     
        this.addChild(tgSalon);
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

    private TransformGroup rotado(Inodoro inodoro, Transform3D rotacion) {
        TransformGroup tg = new TransformGroup(rotacion);
        tg.addChild(inodoro.getTransformGroup());
        return tg;
    }
   
    public TransformGroup getTransformGroup() {
        return tgSalon;
    }
} 