package colisiones;

import ESCENARIO.Color;
import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import java.util.List;

public class Tope {
    private TransformGroup tgTope;

    public Tope(Vector3d posicion, float ancho, float alto, float profundo, List<ObjetoConColision> listaObstaculos) {
        tgTope = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgTope.setTransform(t3d);

        Appearance apariencia = Color.setTransparente();


        tgTope.addChild(Pared.crearParedConColision(
            ancho,
            alto,
            profundo,
            new Vector3d(0.0, 0.0, 0.0), // relativo al centro del tope
            apariencia,
            "Tope",
            listaObstaculos
        ));
    }

    public TransformGroup getTransformGroup() {
        return tgTope;
    }
}
