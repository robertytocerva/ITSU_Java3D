package colisiones;

import com.sun.j3d.utils.geometry.Box;
import java.util.List;
import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

public class Pared {
    
    public static TransformGroup crearParedConColision(float ancho, float alto, float profundo, Vector3d posicion,
                                                       Appearance apariencia, String nombre, List<ObjetoConColision> listaObstaculos) {
        TransformGroup tgPared = new TransformGroup();
        tgPared.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPared.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);
        tgPared.setTransform(t3d);

        Box box = new Box(ancho / 2, alto / 2, profundo / 2, apariencia);
        tgPared.addChild(box);

        // Añadir a la lista de obstáculos
        listaObstaculos.add(new ObjetoConColision(nombre, tgPared, ancho, profundo));

        return tgPared;
    }
    public static TransformGroup crearPared(float ancho, float alto, float profundo, Vector3d posicion, Appearance apariencia) {
    TransformGroup tgPared = new TransformGroup();
    Transform3D t3d = new Transform3D();
    t3d.setTranslation(posicion);
    tgPared.setTransform(t3d);
    
    Box pared = new Box(ancho / 2, alto / 2, profundo / 2, apariencia);
    tgPared.addChild(pared);
    
    return tgPared;
}

}
