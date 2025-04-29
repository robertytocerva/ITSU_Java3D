package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;

public class Silla {
    private TransformGroup tgSilla;

    public Silla(Vector3d posicion,List<ObjetoConColision> listaObstaculos) {
        tgSilla = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgSilla.setTransform(t3d);

        // Colores
        Appearance colorAsiento = new Color().setColor(5, 21, 164); // Marrón medio
        Appearance colorRespaldo = new Color().setColor(5, 21, 164); // Marrón más oscuro
        Appearance colorPatas = new Color().setColor(0,0,0); // Marrón oscuro

        ///// ASIENTO Y RESPALDO
        tgSilla.addChild(Pared.crearParedConColision(0.6f, 0.05f, 0.6f, new Vector3d(0.0, 0.3, 0.0),colorAsiento, "s", listaObstaculos));    // Asiento
        tgSilla.addChild(Pared.crearParedConColision(0.5f, 0.7f, 0.05f, new Vector3d(0.0, 0.7, -0.3),colorAsiento, "s", listaObstaculos));

        /////// PATAS DE LA SILLA
        tgSilla.addChild(Pared.crearPared(0.05f, 0.3f, 0.05f, new Vector3d(-0.25, 0.15, -0.25), colorPatas));
        tgSilla.addChild(Pared.crearPared(0.05f, 0.3f, 0.05f, new Vector3d(0.25, 0.15, -0.25), colorPatas));
        tgSilla.addChild(Pared.crearPared(0.05f, 0.3f, 0.05f, new Vector3d(-0.25, 0.15, 0.25), colorPatas));
        tgSilla.addChild(Pared.crearPared(0.05f, 0.3f, 0.05f, new Vector3d(0.25, 0.15, 0.25), colorPatas));
    }

    public TransformGroup getTransformGroup() {
        return tgSilla;
    }
}
