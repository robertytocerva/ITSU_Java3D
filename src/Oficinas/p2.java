package Oficinas;
import ESCENARIO.Color;
import Muebles.Silla;
import colisiones.ObjetoConColision;
import colisiones.Pared;
import com.sun.j3d.utils.geometry.Box;
import java.util.List;
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

public class p2 extends BranchGroup {

    private TransformGroup tgSalon;

    public p2(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        if (conPiso) {
            tgSalon.addChild(crearPared(9.0f, 0.46f, 6.0f, new Vector3d(1.5, -0.2, 0.0), crearApariencia(160, 160, 160)));///////////ACTIVAR PISO SEGUNDA PLANTA
        }
        //// Pasillo y pared separadora segunda planta también en class p1
tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 3.7f, new Vector3d(3.0, 1.5, -1.1), crearApariencia(228, 199, 124), "paredLargaPasilloDer", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 0.90f, new Vector3d(3.0, 1.5, 0.9), crearApariencia(240, 210, 135), "pilarPasilloDer", listaObstaculos));

/// Pared separadora
tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new Vector3d(0.0, 1.5, 0.9), crearApariencia(254, 216, 116), "paredSeparadoraCentral", listaObstaculos));

/// Pared a un lado de las escaleras
tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f, new Vector3d(0.0, 1.5, -3.0), crearApariencia(254, 216, 116), "paredEscaleraFondo", listaObstaculos));

/// Pared izquierda reflejada (Z invertido)
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f, new Vector3d(-3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredIzqInferior", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.4f, 3.0f, 1.0f, new Vector3d(-2.8, 1.5, 1.0), crearApariencia(240, 210, 135), "pilarIzqCentro", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f, new Vector3d(-3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredIzqSuperior", listaObstaculos));

/// Ventanas reflejadas
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventanaRef5", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaRef6", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventanaRef7", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f, new Vector3d(-3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaRef8", listaObstaculos));

/// Pilas reflejadas también
tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new Vector3d(-3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarIzqFrente", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f, new Vector3d(-3.0, 1.5, -2.8), crearApariencia(228, 199, 124), "pilarIzqFondo", listaObstaculos));

      Vector3d[] posiciones = {
            new Vector3d(-2.0, 0.9, -2.0), new Vector3d(-1.0, 0.9, -2.0),
            new Vector3d(0.7, 0.9, -2.0), new Vector3d(1.8, 0.9, -2.0),
            new Vector3d(-2.0, 0.9, -0.8), new Vector3d(-1.0, 0.9, -0.8),
            new Vector3d(0.7, 0.9, -0.8), new Vector3d(1.8, 0.9, -0.8),
            new Vector3d(-2.0, 0.9, 0.4), new Vector3d(-1.0, 0.9, 0.4),
            new Vector3d(0.7, 0.9, 0.4), new Vector3d(1.8, 0.9, 0.4)
        };

TransformGroup tgContrario = new TransformGroup(); 
//////////////////////////////////////////////////////////////////////
tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.5f, 6.0f, new Vector3d(-1.3, 1.0, 4.0), crearApariencia(155, 80, 15), "paredFrontalFondo", listaObstaculos));
tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.4f, 6.0f, new Vector3d(-1.3, 2.7, 4.0), crearApariencia(155, 80, 15), "paredFrontalFondo", listaObstaculos));

double separacion = 1.8;
int totalMesas = 3;
double baseX = -5.0;
double baseY = 0.8;
double baseZ = -1.4;

double offsetZMesa = -0.6;
double offsetZSilla = -1.2;

for (int i = 0; i < totalMesas; i++) {
    if (i == 3 || i == 4) continue; // omitir algunas posiciones si lo deseas

    double offsetX = baseX + i * separacion;

    // Posiciones base sin rotar
    Vector3d posMesa = new Vector3d(offsetX, baseY, baseZ + offsetZMesa);
    Vector3d posSilla = new Vector3d(offsetX, baseY, baseZ + offsetZSilla);

    // Crear elementos
    Mesa mesa = new Mesa(posMesa);
    Silla silla = new Silla(posSilla, listaObstaculos);

    // Rotar para mirar lateralmente hacia +X (izquierda)
    Transform3D rotY = new Transform3D();
    rotY.rotY(Math.PI / 2); // 90° a la derecha

    TransformGroup tgGrupo = new TransformGroup(rotY);

    tgGrupo.addChild(mesa.getTransformGroup());
    tgGrupo.addChild(silla.getTransformGroup());

    tgContrario.addChild(tgGrupo);

    // Pilares
    if (i < totalMesas - 1) {
        double pilarX = offsetX + (separacion / 2);
        double zAltoLocal = baseZ + offsetZSilla + 1.2;
        double zBajoLocal = baseZ + offsetZSilla + 0.3;

        Vector3d posPilarAlto = new Vector3d(pilarX, 1.5, zAltoLocal);
        Vector3d posPilarBajo = new Vector3d(pilarX, 0.75, zBajoLocal);

        TransformGroup tgPilarAlto = crearPared(0.1f, 3.0f, 0.3f, posPilarAlto, crearApariencia(160,160,160));
        TransformGroup tgPilarBajo = crearPared(0.1f, 1.5f, 1.5f, posPilarBajo, crearApariencia(155, 80, 15));

        tgGrupo.addChild(tgPilarAlto);
        tgGrupo.addChild(tgPilarBajo);
    }
}

// ¡No olvidar!
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
