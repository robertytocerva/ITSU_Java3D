package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class Mesa {
    private TransformGroup tgMesa;

    public Mesa(Vector3d posicion) {
        tgMesa = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgMesa.setTransform(t3d);

        // Colores
        Appearance colorSuperficie = new Color().setColor(210, 163, 122); // Marrón claro (superficie)
        Appearance colorEstructura = new Color().setColor(210, 163, 122); // Marrón medio (estructura)
        Appearance colorPatas = new Color().setColor(0,0,0);      // Marrón oscuro (patas)

        // SUPERFICIE
        tgMesa.addChild(Pared.crearPared(0.9f, 0.4f, 0.4f, new Vector3d(0.0, 0.5, 0.2), colorSuperficie));

        // ESTRUCTURA BAJO LA SUPERFICIE
        tgMesa.addChild(Pared.crearPared(0.5f, 0.1f, 0.2f, new Vector3d(0.0, 0.5, 0.0), colorEstructura));

        // PATAS DE LA MESA
        tgMesa.addChild(Pared.crearPared(0.1f, 0.5f, 0.1f, new Vector3d(-0.25, 0.25, 0.3), colorPatas)); 
        tgMesa.addChild(Pared.crearPared(0.1f, 0.5f, 0.1f, new Vector3d(0.25, 0.25, 0.3), colorPatas)); 
        tgMesa.addChild(Pared.crearPared(0.1f, 0.5f, 0.1f, new Vector3d(-0.25, 0.25, 0.3), colorPatas));
        tgMesa.addChild(Pared.crearPared(0.1f, 0.5f, 0.1f, new Vector3d(0.25, 0.25, 0.3), colorPatas)); 
    }


    public TransformGroup getTransformGroup() {
        return tgMesa;
    }
}
