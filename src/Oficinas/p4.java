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

public class p4 extends BranchGroup {

    private TransformGroup tgSalon;

    public p4(boolean conPiso,List<ObjetoConColision> listaObstaculos) {
        tgSalon = new TransformGroup();
        tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        if (conPiso) {
            tgSalon.addChild(crearPared(15.0f, 0.40f, 06.0f,
                    new Vector3d(-4.4, -0.2, 0.0), crearApariencia(160, 160, 160)));
        }

        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f,
                new Vector3d(3.0, 0.5, 0.0), crearApariencia(228, 199, 124), "paredInferiorFinalDer", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 0.6f, 6.0f,
                new Vector3d(3.0, 2.7, 0.0), crearApariencia(228, 199, 124), "paredSuperiorFinalDer", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
                new Vector3d(0.0, 1.5, 3.0), crearApariencia(228, 199, 124), "paredSeparadoraOficinas", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, -2.1), Color.setSemiTransparente(0.2f), "ventanaOficina1", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, -1.0), Color.setSemiTransparente(0.2f), "ventanaOficina2", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, 2.1), Color.setSemiTransparente(0.2f), "ventanaOficina3", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.4f, 1.1f,
                new Vector3d(3.0, 1.7, 1.0), Color.setSemiTransparente(0.2f), "ventanaOficina4", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.3f,
                new Vector3d(3.0, 1.5, 2.8), crearApariencia(228, 199, 124), "pilarPuertaDelgadoDer", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(0.1f, 3.0f, 0.90f,
                new Vector3d(2.9, 1.5, 0.0), crearApariencia(240, 210, 135), "pilarCentroFijoDer", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(3.0f, 1.4f, 0.1f,
                new Vector3d(-4.5, 0.7, 3.0), crearApariencia(155, 80, 15), "ventanaInferiorCubiculo", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(3.0f, 0.5f, 0.1f,
                new Vector3d(-4.5, 2.7, 3.0), crearApariencia(155, 80, 15), "ventanaSuperiorCubiculo", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(9.2f, 0.5f, 0.1f,
                new Vector3d(-7.4, 2.7, 1.4), crearApariencia(155, 80, 15), "divisorCubiculosExt", listaObstaculos));

        tgSalon.addChild(Pared.crearParedConColision(1.1f, 2.6f, 0.1f,
                new Vector3d(-3.6, 1.1, 1.4), crearApariencia(160, 50, 50), "puertaCubiculoIzq", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(5.8f, 1.4f, 0.1f,
                new Vector3d(0.1, 0.8, 1.2), crearApariencia(155, 80, 15), "paredComparativaCentro", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(7.8f, 1.4f, 0.1f,
                new Vector3d(-8.0, 0.8, 1.2), crearApariencia(155, 80, 15), "paredComparativaIzq", listaObstaculos));
        tgSalon.addChild(Pared.crearParedConColision(5.8f, 0.3f, 0.1f,
                new Vector3d(-0.1, 2.9, 1.3), crearApariencia(155, 80, 15), "paredComparativaSuperior", listaObstaculos));

        TransformGroup tgContrario = new TransformGroup();
        double separacion = 1.8;
        int totalMesas = 8;
        double baseX = -1.8;
        double baseY = 0.7;
        double baseZ = -1.4;

        double offsetZMesa = -0.6;
        double offsetZSilla = -1.2;


        for (int i = 0; i < totalMesas; i++) {
            if (i == 3 || i == 4)
                continue;
            double offsetX = baseX + i * separacion;

            Vector3d posMesa = new Vector3d(offsetX, baseY, baseZ + offsetZMesa);
            Mesa mesa = new Mesa(posMesa);

            Vector3d posSilla = new Vector3d(offsetX, baseY, baseZ + offsetZSilla);
            Silla silla = new Silla(posSilla,listaObstaculos);

            Transform3D rotY = new Transform3D();
            rotY.rotY(Math.PI);
            TransformGroup tgGrupo = new TransformGroup(rotY);

            tgGrupo.addChild(mesa.getTransformGroup());
            tgGrupo.addChild(silla.getTransformGroup());

            tgContrario.addChild(tgGrupo);


            if (i < totalMesas - 1) {
                double pilarX = offsetX + (separacion / 2);
                double zAltoLocal = baseZ + offsetZSilla + 1.2;
                double zBajoLocal = baseZ + offsetZSilla + 0.3;

                Vector3d posPilarAlto = new Vector3d(pilarX, 1.5, zAltoLocal);
                Vector3d posPilarBajo = new Vector3d(pilarX, 0.75, zBajoLocal);

                TransformGroup tgPilarAlto = crearPared(0.1f, 3.0f, 0.3f,
                        posPilarAlto, crearApariencia(160,160,160));
                TransformGroup tgPilarBajo = crearPared(0.1f, 1.5f, 1.5f,
                        posPilarBajo, crearApariencia(155, 80, 15));

                tgGrupo.addChild(tgPilarAlto);
                tgGrupo.addChild(tgPilarBajo);
            }

        }
        Vector3d posicionBase = new Vector3d(-5.0, 0.8, 1.3);

        Mesa mesaContraria = new Mesa(new Vector3d(3.0, 0.0, -6.2));
        Silla sillaContraria = new Silla(new Vector3d(3.0, 0.0, -6.7),listaObstaculos);

        Transform3D rotacion = new Transform3D();
        rotacion.rotY(Math.PI / 2);
        Transform3D traslacion = new Transform3D();
        traslacion.setTranslation(posicionBase);


        rotacion.mul(traslacion);

        TransformGroup tgGrupoContrario = new TransformGroup(rotacion);
        tgGrupoContrario.addChild(mesaContraria.getTransformGroup());
        tgGrupoContrario.addChild(sillaContraria.getTransformGroup());
        tgSalon.addChild(tgGrupoContrario);

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
