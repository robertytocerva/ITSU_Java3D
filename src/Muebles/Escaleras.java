package Muebles;

import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class Escaleras {
    private TransformGroup tgEscalera = new TransformGroup();
private TransformGroup tgpiso = new TransformGroup();
    public Escaleras(List<ObjetoConColision> listaObstaculos) {
        tgEscalera.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgEscalera.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Appearance apariencia = new Appearance();
        ColoringAttributes ca = new ColoringAttributes(new Color3f(0.8f, 0.8f, 0.8f), ColoringAttributes.NICEST);
        apariencia.setColoringAttributes(ca);
//        tgpiso.addChild(Pared.crearPared(100.0f, 0.1f, 100.0f, new Vector3d(1.5, -0.1, 0.0), crearApariencia(160, 160, 160)));
//        
        float ancho = 1.5f;
        float alto = 0.15f;
        float profundo = 0.3f;
        int escalonesPorTramo = 6;
        int escalonesPorTramo2 = 5;

        // Tramo 1
        TransformGroup tgRotada1 = new TransformGroup();
        Transform3D rotacionY1 = new Transform3D();
        rotacionY1.rotY(-Math.PI / 2);
        tgRotada1.setTransform(rotacionY1);

        for (int i = 0; i < escalonesPorTramo; i++) {
            Vector3d posicionEscalon = new Vector3d(0.8, alto * (2 * (escalonesPorTramo - i - 1.2) + 1), -i * 1.8 * profundo + profundo * (escalonesPorTramo - 1));
            tgRotada1.addChild(Pared.crearParedConColision(2.0f, 0.10f, 0.8f, posicionEscalon, apariencia, "escalon1_" + i, listaObstaculos));
        }

        tgEscalera.addChild(tgRotada1);

        // Piso central
        tgEscalera.addChild(Pared.crearPared(2.2f, 0.3f, 3.8f, new Vector3d(-2.9, 1.8, 1.8), crearApariencia(228, 199, 124)));

        // Tramo 2
        TransformGroup tgRotada2 = new TransformGroup();
        Transform3D rotacionY2 = new Transform3D();
        rotacionY2.rotY(-Math.PI / 2);
        Transform3D traslacionX = new Transform3D();
        traslacionX.setTranslation(new Vector3d(2.7, 0.2, 1.3));
        rotacionY2.mul(traslacionX);
        tgRotada2.setTransform(rotacionY2);

        for (int i = 0; i < escalonesPorTramo2; i++) {
            Vector3d posicionEscalon = new Vector3d(0, alto * (2 * escalonesPorTramo2 + 1 + 2 * i + 2.0), -i * 2.7 * profundo + profundo * (escalonesPorTramo2 - 5));
            tgRotada2.addChild(Pared.crearParedConColision(2.0f, 0.10f, 0.5f, posicionEscalon, apariencia, "escalon2_" + i, listaObstaculos));
        }

        tgEscalera.addChild(tgRotada2);
    }

    public TransformGroup getTransformGroup() {
        return tgEscalera;
    }

    private Appearance crearApariencia(int r, int g, int b) {
        Appearance apariencia = new Appearance();
        ColoringAttributes colorAttr = new ColoringAttributes();
        colorAttr.setColor(new Color3f(r / 255f, g / 255f, b / 255f));
        apariencia.setColoringAttributes(colorAttr);
        return apariencia;
    }
}
