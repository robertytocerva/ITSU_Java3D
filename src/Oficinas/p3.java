package Oficinas;

import ESCENARIO.Color;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.*;
import javax.vecmath.*;

import Muebles.Mesa;
import Muebles.Silla;
import colisiones.ObjetoConColision;
import colisiones.Pared;
import com.sun.j3d.utils.geometry.Box;
import java.util.List;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

public class p3 extends BranchGroup {

    private TransformGroup tgSalon;

    public p3(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        if (conPiso) {
            tgSalon.addChild(crearPared(09.0f, 0.46f, 25.0f, new Vector3d(1.5,-0.2, 0.0), crearApariencia(160, 160, 160)));
        }
        tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new Vector3d(2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarDerFinal", listaObstaculos)); /////// PILAR

// Pared del frente (ahora al fondo)
tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new Vector3d(0.0, 1.5, 3.0), crearApariencia(254, 216, 116), "paredFrontalFondo", listaObstaculos));

// Ventanas reflejadas


tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f, new Vector3d(-3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredIzqSuperior", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventanaRefDer1", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaRefDer2", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventanaRefDer3", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaRefDer4", listaObstaculos));

// Pilas reflejadas también
tgSalon.addChild(Pared.crearParedConColision(0.2f, 3.0f, 0.3f, new Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarEsquina1", listaObstaculos)); //// 2 esquinas
tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarEsquina2", listaObstaculos));

tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f, new Vector3d(-3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredInferiorIzq", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new Vector3d(-2.8, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentroIzqFinal", listaObstaculos));

           // Posición base del conjunto
Vector3d posicionBase = new Vector3d(-5.0, 0.8, 1.3); // más a la izquierda (X) y alineado a puerta (Z)
// Crear mesa y silla en (0,0,...) relativas al grupo
Mesa mesaContraria = new Mesa(new Vector3d(3.0, -0.6, -1.0));///sila afuera de cubiculo
Silla sillaContraria = new Silla(new Vector3d(3.0, -0.6, -0.9),listaObstaculos);//mesa

// Agrupar con rotación hacia la puerta (90° en Y)
Transform3D rotacion = new Transform3D();
rotacion.rotY(Math.PI ); // Gira 90° izquierda
Transform3D traslacion = new Transform3D();
traslacion.setTranslation(posicionBase);

// Combinamos rotación y traslación
rotacion.mul(traslacion); // rotación * traslación

TransformGroup tgGrupoContrario = new TransformGroup(rotacion);
tgGrupoContrario.addChild(mesaContraria.getTransformGroup());
tgGrupoContrario.addChild(sillaContraria.getTransformGroup());
tgSalon.addChild(tgGrupoContrario); // ← esto es lo que falta
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
