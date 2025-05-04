package Muebles;

import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import javax.media.j3d.*;
import javax.vecmath.Vector3d;
import colisiones.Pared;
import java.util.List;


public class Inodoro {
    private TransformGroup tgInodoro;

    public Inodoro(Vector3d posicion, List<ObjetoConColision> obstaculos) {
        tgInodoro = new TransformGroup();
        tgInodoro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgInodoro.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgInodoro.setTransform(t3d);

        Appearance colorCeramica = new Color().setColor(255, 255, 255); // Blanco

        // Base del inodoro (más grande)
        tgInodoro.addChild(Pared.crearParedConColision(
            0.6f, 0.375f, 0.6f,
            new Vector3d(0.0, 0.1875, 0.0),
            colorCeramica,
            "baseInodoro", obstaculos));

        // Taza
        tgInodoro.addChild(Pared.crearParedConColision(
            0.45f, 0.225f, 0.45f,
            new Vector3d(0.0, 0.525, 0.0),
            colorCeramica,
            "tazaInodoro", obstaculos));

        // Tanque trasero
        tgInodoro.addChild(Pared.crearParedConColision(
            0.45f, 0.375f, 0.15f,
            new Vector3d(0.0, 0.75, -0.3),
            colorCeramica,
            "tanqueInodoro", obstaculos));
    }

    public TransformGroup getTransformGroup() {
        return tgInodoro;
    }
}