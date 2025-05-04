package ESCENARIO;

import Muebles.Administrativo;
import colisiones.ObjetoConColision;
import Muebles.Silla;
import Muebles.SalonD;
import Muebles.Mesa;
import Personaje.crearEscenaGrafica4;
import Muebles.Cubiculo;
import Muebles.Cubiculo2;
import Muebles.Escaleras;
import Muebles.Fuera;
import Muebles.SalonDF;
import Muebles.SalonIz;
import Muebles.SalonIzF;
import Muebles.wc;
import Personaje.crearEscenaGrafica4.BoundingRect;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;


public class crearEscenaGrafica5 {  
    public BranchGroup bgRaiz = new BranchGroup();
    TransformGroup tgSalon;  
  
    public ArrayList<ObjetoConColision> obstaculos = new ArrayList<>();
    public ArrayList<ObjetoConColision> obstaculos2 = new ArrayList<>();
    public ArrayList<ObjetoConColision> obstaculosE = new ArrayList<>();


    private float anguloCamara = 0f;
    private float pitchCamara = 0.0f;

    private TransformGroup tgCamara;


    public float orientacion = (float)-Math.PI / 2.0f;
  

    private static final double DIST_CAM =2.0, ALT_CAM =2;

    crearEscenaGrafica4 personaje;
    
    public TransformGroup tgUniverso;

    public TransformGroup tgEsfera;
    

    public Vector3d offsetCamara = new Vector3d(0.0, -2.0, -10.0);

    public crearEscenaGrafica5() {

        tgUniverso = new TransformGroup();
        tgUniverso.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgUniverso.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tgUniverso.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
        tgUniverso.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);

        TransformGroup tgTodosLosSalones = new TransformGroup();
        tgTodosLosSalones.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgTodosLosSalones.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        double pasillo = -9.0;


        SalonIzF salon3 = new SalonIzF(false, obstaculos);
        TransformGroup tgSalon3 = salon3.getTransformGroup();
        Transform3D pos3 = new Transform3D();
        pos3.setTranslation(new Vector3d(0.0, 0.0, 18.0));
        tgSalon3.setTransform(pos3);
        tgTodosLosSalones.addChild(tgSalon3);

        SalonIzF salon2 = new SalonIzF(false, obstaculos);
        TransformGroup tgSalon2 = salon2.getTransformGroup();
        Transform3D pos2 = new Transform3D();
        pos2.setTranslation(new Vector3d(0.0, 0.0, 12.0));
        tgSalon2.setTransform(pos2);
        tgTodosLosSalones.addChild(tgSalon2);

        SalonIz salon7 = new SalonIz(false, obstaculos);
        TransformGroup tgSalon7 = salon7.getTransformGroup();
        Transform3D pos7 = new Transform3D();
        pos7.setTranslation(new Vector3d(pasillo, 0.0, 18.0));
        tgSalon7.setTransform(pos7);
        tgTodosLosSalones.addChild(tgSalon7);

        SalonIz salon6 = new SalonIz(false, obstaculos);
        TransformGroup tgSalon6 = salon6.getTransformGroup();
        Transform3D pos6 = new Transform3D();
        pos6.setTranslation(new Vector3d(pasillo, 0.0, 12.0));
        tgSalon6.setTransform(pos6);
        tgTodosLosSalones.addChild(tgSalon6);

        Cubiculo cubiculo = new Cubiculo(obstaculos, new Vector3d(-4.0, 0.5, 17.0));
        tgTodosLosSalones.addChild(cubiculo);


        SalonD salon1 = new SalonD(false, obstaculos);
        tgSalon = salon1.getTransformGroup();
        tgTodosLosSalones.addChild(tgSalon);

        SalonD salon4 = new SalonD(false, obstaculos);
        TransformGroup tgSalon4 = salon4.getTransformGroup();
        Transform3D pos4 = new Transform3D();
        pos4.setTranslation(new Vector3d(0.0, 0.0, -6.0));
        tgSalon4.setTransform(pos4);
        tgTodosLosSalones.addChild(tgSalon4);

        SalonDF salon8 = new SalonDF(false, obstaculos);
        TransformGroup tgSalon8 = salon8.getTransformGroup();
        Transform3D pos8 = new Transform3D();
        pos8.setTranslation(new Vector3d(pasillo, 0.0, -6.0));
        tgSalon8.setTransform(pos8);
        tgTodosLosSalones.addChild(tgSalon8);

        wc salon5 = new wc(obstaculos, new Vector3d(-9.0, 0.0, 0.0));
        tgTodosLosSalones.addChild(salon5);

        Cubiculo2 cubiculo2 = new Cubiculo2(obstaculos);
        Transform3D t3dCubiculo = new Transform3D();
        t3dCubiculo.setTranslation(new Vector3d(-4.0, 0.5, -9.9));

        TransformGroup tgCubiculo2 = new TransformGroup();
        tgCubiculo2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgCubiculo2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tgCubiculo2.setTransform(t3dCubiculo);

        tgCubiculo2.addChild(cubiculo2.getTransformGroup());
        tgTodosLosSalones.addChild(tgCubiculo2);

        Escaleras escalera = new Escaleras(obstaculos);
        Transform3D tEsc = new Transform3D();
        tEsc.setTranslation(new Vector3d(-8.2, -0.1, 4.1));

        TransformGroup tgEscalera = new TransformGroup();
        tgEscalera.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgEscalera.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tgEscalera.setTransform(tEsc);
        tgEscalera.addChild(escalera.getTransformGroup());
        tgTodosLosSalones.addChild(tgEscalera);

        Fuera fuera = new Fuera(false, obstaculosE);
        tgTodosLosSalones.addChild(fuera.getTransformGroup());

        Planta2 planta2 = new Planta2(4.0, obstaculos2);
        tgTodosLosSalones.addChild(planta2.getTransformGroup());

        personaje = new crearEscenaGrafica4();
        TransformGroup tgPersonaje = personaje.getTgPanza();
        Transform3D escala = new Transform3D();
        escala.setScale(0.6);
        Transform3D rotacion = new Transform3D();
        rotacion.rotY(0.0);
        Transform3D posInicial = new Transform3D();
escala.mul(rotacion);
//        escala.mul(posInicial);
        escala.setTranslation(new Vector3d(15.0, 0.9, 4.0));
        

        tgPersonaje.setTransform(escala);

        tgUniverso.addChild(personaje.getBranchGroup());
        tgUniverso.addChild(tgTodosLosSalones);

        MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(tgTodosLosSalones);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        bgRaiz.addChild(myMouseRotate);
        bgRaiz.addChild(tgUniverso);

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCamara();
            }
        });
        timer.start();
    }


    public void actualizarCamara() {
    Transform3D tp = new Transform3D();
    personaje.getTgPanza().getTransform(tp);
    Vector3d p = new Vector3d(); 
    tp.get(p);


    Vector3d eye = new Vector3d(
    p.x - DIST_CAM * Math.sin(orientacion),
    p.y + ALT_CAM,
    p.z - DIST_CAM * Math.cos(orientacion)
);

    Point3d target = new Point3d(p.x, p.y + 1.0, p.z); 
    Transform3D view = new Transform3D();
    view.lookAt(new Point3d(eye), target, new Vector3d(0, 1, 0));
    view.invert();

    tgCamara.setTransform(view);
}
   public void moverConJoystick(float xAxis, float yAxis) {
    float sensRot = 0.07f, vel = 0.5f;
    orientacion += xAxis * sensRot;

    Transform3D tp = new Transform3D();
    personaje.getTgPanza().getTransform(tp);
    Vector3d pos = new Vector3d(); 
    tp.get(pos);

    double dx = yAxis * vel * Math.sin(orientacion);
    double dz = yAxis * vel * Math.cos(orientacion);

    Vector3d intento = new Vector3d(pos.x + dx, pos.y, pos.z + dz);
    boolean movimiento = false;


    if (!hayColision(intento)) {
        aplicarTransformConRotacion(intento);
        movimiento = true;
    } else {
        // Interpolación suave hacia la pared (efecto deslizamiento)
        final double[] escalas = {0.7, 0.4, 0.2, 0.1}; // múltiples intentos de menor magnitud
        for (double escala : escalas) {
            Vector3d intentoParcial = new Vector3d(
                pos.x + dx * escala,
                pos.y,
                pos.z + dz * escala
            );
            if (!hayColision(intentoParcial)) {
                aplicarTransformConRotacion(intentoParcial);
                movimiento = true;
                break;
            }
        }
    }

if (!movimiento) {
    double fuerzaLateral = 0.15;

    Vector3d lateral1 = new Vector3d(
        pos.x + fuerzaLateral * Math.cos(orientacion),
        pos.y,
        pos.z - fuerzaLateral * Math.sin(orientacion)
    );

    Vector3d lateral2 = new Vector3d(
        pos.x - fuerzaLateral * Math.cos(orientacion),
        pos.y,
        pos.z + fuerzaLateral * Math.sin(orientacion)
    );

    if (!hayColision(lateral1)) {
        aplicarTransformConRotacion(lateral1);
        movimiento = true;
    } else if (!hayColision(lateral2)) {
        aplicarTransformConRotacion(lateral2);
        movimiento = true;
    }
     personaje.Caminar();
  }
}
private void aplicarTransformConRotacion(Vector3d nuevaPos) {
    Transform3D rot = new Transform3D();
    rot.rotY(orientacion);

    Transform3D tFinal = new Transform3D();
    tFinal.setTranslation(nuevaPos);

    rot.mul(tFinal);
    personaje.getTgPanza().setTransform(rot);

    if (hayColision(nuevaPos)) {
        double retroceso = 0.05;
        Vector3d retrocedido = new Vector3d(
            nuevaPos.x - retroceso * Math.sin(orientacion),
            nuevaPos.y,
            nuevaPos.z - retroceso * Math.cos(orientacion)
        );

        Transform3D rotRetro = new Transform3D();
        rotRetro.rotY(orientacion);
        rotRetro.setTranslation(retrocedido);
        personaje.getTgPanza().setTransform(rotRetro);
    }


}
    public crearEscenaGrafica4 getPersonaje() {
        return personaje;
    }

    public TransformGroup getTgEsfera() {
        return tgEsfera;
    }

    public TransformGroup getTgUniverso() {
        return tgUniverso;
    }
    public void acercarCamara() {
    offsetCamara.z += 0.25;
}

public void alejarCamara() {
    offsetCamara.z -= 0.30;
}
public TransformGroup getTransformGroupUniverso() {
    return tgUniverso;
}
public void rotarCamara(float delta) {
        anguloCamara += delta;
        Transform3D t3d = new Transform3D();
        t3d.rotY(anguloCamara);
        tgCamara.setTransform(t3d);
    }
public void rotarCamaraPitch(float pitchAngle) {
    this.pitchCamara = pitchAngle;
    aplicarTransformVista();
}

private void aplicarTransformVista() {
    Transform3D tPitch = new Transform3D();
    tPitch.rotX(pitchCamara);

    Transform3D tYaw = new Transform3D();
    tYaw.rotY(anguloCamara);

    tYaw.mul(tPitch);              // yaw ∘ pitch
    tgCamara.setTransform(tYaw);   // actualiza la vista
}
   
public void inicializarCamara(SimpleUniverse universo) {
    ViewingPlatform vp = universo.getViewingPlatform();
    tgCamara = vp.getViewPlatformTransform();
    actualizarCamara();
}
public boolean hayColision(Vector3d nuevaPosicion) {
    
   float y = (float) nuevaPosicion.y;
ArrayList<ObjetoConColision> lista = (y > 3.0) ? obstaculos2 : obstaculos;

    
    crearEscenaGrafica4.BoundingRect bbPersonaje = crearEscenaGrafica4.getBoundingRectPersonaje(nuevaPosicion, orientacion);
    
    for (ObjetoConColision obj : lista) {
        Transform3D t = new Transform3D();
        obj.getTransformGroup().getLocalToVworld(t);
        Vector3d posObj = new Vector3d();
        t.get(posObj);
        
        
        float expand = 0.0f;
        if (obj.getAncho() < 0.2 || obj.getLargo() < 0.2) {
        expand = 0.5f; // Expansión para objetos delgaditos
         }
        float ancho = (float) obj.getAncho() + expand;
        float largo = (float) obj.getLargo() + expand;


        crearEscenaGrafica4.BoundingRect bbObstaculo = new crearEscenaGrafica4.BoundingRect(
            (float) (posObj.x - ancho), (float) (posObj.x + ancho),
            (float) (posObj.z - largo), (float) (posObj.z + largo)
        );
    }
    return false;
}
 public void addPointLight(float x, float y, float z, float r, float g, float b) {
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        
        PointLight pointLight = new PointLight(
            new Color3f(r, g, b),
            new Point3f(x, y, z),
            new Point3f(8.0f, 8.0f, 8.0f)  // Attenuation (constant, linear, quadratic)
        );
        pointLight.setInfluencingBounds(bounds);
        bgRaiz.addChild(pointLight);
    }

}
