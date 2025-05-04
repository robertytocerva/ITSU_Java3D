
package ESCENARIO;



import Muebles.Administrativo;

import Muebles.Cubiculo2;
import Muebles.SalonD;
import Muebles.SalonDF;

import Muebles.wc;
import Oficinas.p1;
import Oficinas.p2;
import Oficinas.p3;
import Oficinas.p4;
import colisiones.ObjetoConColision;
import java.util.ArrayList;

import javax.media.j3d.*;
import javax.vecmath.Vector3d;

public class Planta2 {
    
    private TransformGroup tgPlanta;
    public ArrayList<ObjetoConColision> obstaculos2 = new ArrayList<>();
    

    
    public Planta2(double alturaY, ArrayList<ObjetoConColision> listaObstaculos) {
        this.obstaculos2 = listaObstaculos;
        tgPlanta = new TransformGroup();
        tgPlanta.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPlanta.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        // Eleva toda la planta a la altura especificada
        Transform3D elevacion = new Transform3D();
        elevacion.setTranslation(new Vector3d(0.0, alturaY, 0.0));
        tgPlanta.setTransform(elevacion);

        construirPlanta();
    }

    private void construirPlanta() {
        
        
        double pasillo = -9.0;
        //6
        SalonD salonCentro = new SalonD(false,obstaculos2);
       tgPlanta.addChild(crearTG(salonCentro.getTransformGroup(), new Vector3d(0.0, -0.6, 0.0)));
        // 8
        SalonD salonD1 = new SalonD(false,obstaculos2);
        tgPlanta.addChild(crearTG(salonD1.getTransformGroup(), new Vector3d(0.0, -0.6, -6.0)));
        //7
        SalonDF salonDF = new SalonDF(true,obstaculos2);
        tgPlanta.addChild(crearTG(salonDF.getTransformGroup(), new Vector3d(pasillo, -0.6, -6.0)));

        Cubiculo2 cubiculo2 = new Cubiculo2(obstaculos2);
        tgPlanta.addChild(crearTG(cubiculo2.getTransformGroup(), new Vector3d(-4.0, 0.0, -9.9)));

        wc banio = new wc(obstaculos2, new Vector3d(-9.0, -0.6, 0.0)); // ✔️
        tgPlanta.addChild(banio);


        Administrativo administrativo = new Administrativo(true,obstaculos2);
        tgPlanta.addChild(crearTG(administrativo.getTransformGroup(), new Vector3d(0.0, -0.6, 6.0)));

         p1 administrativo2 = new p1(false,obstaculos2);
        tgPlanta.addChild(crearTG(administrativo2.getTransformGroup(), new Vector3d(0.0, -0.6, 12.0)));
       
        p4 salonIzU = new p4(true,obstaculos2);
        tgPlanta.addChild(crearTG(salonIzU.getTransformGroup(), new Vector3d(0.0, -0.6, 18.0)));
        
        
        p3 salonIz1 = new p3(false,obstaculos2);
        tgPlanta.addChild(crearTG(salonIz1.getTransformGroup(), new Vector3d(-9.0, -0.6, 18.0)));
        
         p2 administrativo3 = new p2(true,obstaculos2);
        tgPlanta.addChild(crearTG(administrativo3.getTransformGroup(), new Vector3d(-9.0, -0.6, 12.0)));
        
    }

    
    private TransformGroup crearTG(TransformGroup original, Vector3d posicion) {
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(posicion);

        TransformGroup nuevoTG = new TransformGroup();
        nuevoTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        nuevoTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        nuevoTG.setTransform(t3d);

        nuevoTG.addChild(original);
        return nuevoTG;
    }

    public TransformGroup getTransformGroup() {
        return tgPlanta;
    }
}
