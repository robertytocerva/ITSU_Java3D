
package Personaje;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Delayed;
import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
/////////////LIBRERIAS PARA AGREGAR LA LUZ
import javax.media.j3d.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.vecmath.*;


public class crearEscenaGrafica4 {
    int paraTextura = Primitive.GENERATE_NORMALS+Primitive.GENERATE_TEXTURE_COORDS;
    Textura textura = new Textura();
   
    
    BranchGroup bgRaiz = new BranchGroup();
    
    TransformGroup tgSpHomDer;
    TransformGroup tgSpHomIzq;
    TransformGroup tgSpCodoDer;
    TransformGroup tgSpCodoIzq;
    TransformGroup tgSpMusDer;
    TransformGroup tgSpPrnDer;
    TransformGroup tgSpMusIzq;
    TransformGroup tgSpPrnIzq;
    TransformGroup tgPanza;
    TransformGroup tgMundo;
    private PointLight pointLight;
    private Color3f lightColor;
    private float hue = 0.0f; 
    int r = 255;
    int g = 255;
    int b = 255;
    
    int pasos;
    int baile=0;
    
//////////////////////////////////////////////////////////////////////////
    public Transform3D inittgMundo = new Transform3D();
    public Transform3D initTgSpCabeza = new Transform3D();
    
    public Transform3D initTgPanza = new Transform3D();
    public Transform3D initTgSpHomDer = new Transform3D();
    public Transform3D initTgSpHomIzq = new Transform3D();
    
    public Transform3D initTgSpMusloDer = new Transform3D();
    public Transform3D initTgSpMusloIzq = new Transform3D();
    
    public Transform3D initTgSpRodillaIzq = new Transform3D();
    public Transform3D initTgSpRodillaDer = new Transform3D();
    
    public Transform3D initTgSpCodoIzq = new Transform3D();
    public Transform3D initTgSpCodoDer = new Transform3D();
    
    private boolean piernaDerechaAdelante = true; 
     Appearance app = new Appearance();
    
    public crearEscenaGrafica4() 
    {   
        Color c = new Color();
        float luminosidad = 1.0f;
        float luz = 1.0f;

        Transform3D t3dPanza = new Transform3D();
        Transform3D t3dCabeza = new Transform3D();
        Transform3D t3dHomDer = new Transform3D();
        Transform3D t3dSpHomDer = new Transform3D();
        Transform3D t3dHomIzq = new Transform3D();
        Transform3D t3dSpHomIzq = new Transform3D();
        Transform3D t3dSpCodoDer = new Transform3D();
        Transform3D t3dSpCodoIzq = new Transform3D();
        Transform3D t3dBraDer = new Transform3D();
        Transform3D t3dBraIzq = new Transform3D();
        Transform3D t3dMusDer = new Transform3D();
        Transform3D t3dMusIzq = new Transform3D();
        Transform3D t3dSpMusDer = new Transform3D();
        Transform3D t3dSpMusIzq = new Transform3D();
        Transform3D t3dPrnDer = new Transform3D();
        Transform3D t3dSpPrnDer = new Transform3D();
        Transform3D t3dPrnIzq = new Transform3D();
        Transform3D t3dSpPrnIzq = new Transform3D();
        
         tgMundo = new TransformGroup();
        tgPanza = new TransformGroup(t3dPanza);

        t3dPanza.set(new Vector3d(0.0f,0.0f,0.0f));
        t3dCabeza.set(new Vector3d(0.0f, 0.5f, 0.0f));
        t3dHomDer.set(new Vector3d(0.10f, -0.15f, 0.0f));
        t3dSpHomDer.set(new Vector3f(0.20f, 0.30f, 0.0f));
        t3dHomIzq.set(new Vector3d(-0.10f, -0.15f, 0.0f));
        t3dSpHomIzq.set(new Vector3f(-0.20f, 0.30f, 0.0f));
        t3dSpCodoDer.set(new Vector3f(0.0f, -0.15f, 0.0f));
        t3dSpCodoIzq.set(new Vector3f(0.0f, -0.15f, 0.0f));
        t3dBraDer.set(new Vector3d(0.0f, -0.15f, 0.0f));
        t3dBraIzq.set(new Vector3d(0.0f, -0.15f, 0.0f));
        t3dMusDer.set(new Vector3d(0.0f,-0.15f,0.0f));
        t3dSpMusDer.set(new Vector3d(0.10f,-0.30f,0.0f));
        t3dMusIzq.set(new Vector3d(0.0f,-0.15f,0.0f));
        t3dSpMusIzq.set(new Vector3d(-0.10f,-0.30f,0.0f));
        t3dPrnDer.set(new Vector3d(0.0f,-0.15f,0.0f));
        t3dSpPrnDer.set(new Vector3d(0.0f,-0.15f,0.0f));
        t3dPrnIzq.set(new Vector3d(0.0f,-0.15f,0.0f));
        t3dSpPrnIzq.set(new Vector3d(0.0f,-0.15f,0.0f));

       tgMundo = new TransformGroup();
       tgMundo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

       TransformGroup tgCabeza = new TransformGroup(t3dCabeza);
        TransformGroup tgHomDer = new TransformGroup(t3dHomDer);
        TransformGroup tgHomIzq = new TransformGroup(t3dHomIzq);
        TransformGroup tgBraDer = new TransformGroup(t3dBraDer);
        TransformGroup tgBraIzq = new TransformGroup(t3dBraIzq);
        TransformGroup tgMusDer = new TransformGroup(t3dMusDer);
        TransformGroup tgMusIzq = new TransformGroup(t3dMusIzq);
        TransformGroup tgPrnDer = new TransformGroup(t3dPrnDer);
        TransformGroup tgPrnIzq = new TransformGroup(t3dPrnIzq);
        
       
         tgSpHomDer = new TransformGroup(t3dSpHomDer);
        tgSpHomIzq = new TransformGroup(t3dSpHomIzq);
        tgSpCodoDer = new TransformGroup(t3dSpCodoDer);
        tgSpCodoIzq = new TransformGroup(t3dSpCodoIzq);
        tgSpMusDer = new  TransformGroup(t3dSpMusDer);
        tgSpMusIzq = new TransformGroup(t3dSpMusIzq);
        tgSpPrnDer = new TransformGroup(t3dSpPrnDer);
        tgSpPrnIzq = new TransformGroup(t3dSpPrnIzq);
         tgMundo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPanza.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpHomDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpHomIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpCodoDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpCodoIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpMusDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpMusIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpPrnDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSpPrnIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        
    
        // Crea una apariencia semitransparente blanca
Appearance appTransparente = Color.setSemiTransparente(0.5f);

// Crea el box con apariencia transparente en todas las caras
Box bxMundo = new Box(0.5f, -0.5f, 0.4f, Box.GENERATE_NORMALS, Color.setTransparente());

        Box bxPanza = new Box(0.20f, 0.3f, 0.1f, paraTextura,textura.crearTexturas("aTorso.jpg"));
        bxPanza.setAppearance(0,textura.crearTexturas("fTorso.jpg"));
        bxPanza.setAppearance(2,textura.crearTexturas("lTorso.jpg"));
        bxPanza.setAppearance(3,textura.crearTexturas("lTorso.jpg"));
        bxPanza.setAppearance(4,textura.crearTexturas("lTorso.jpg"));
        bxPanza.setAppearance(5,textura.crearTexturas("bTorso.jpg"));
        Box bxCabeza = new Box(0.24f, 0.2f, 0.14f, paraTextura,textura.crearTexturas("pelo.jpg"));
        bxCabeza.setAppearance(0,textura.crearTexturas("caraStve.jpg"));
        Box bxHomDer = new Box(0.1f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("lTorso.jpg"));
        bxHomDer.setAppearance(1,textura.crearTexturas("brazoDes.jpg"));
        bxHomDer.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxHomIzq = new Box(0.1f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("lTorso.jpg"));
        bxHomIzq.setAppearance(1,textura.crearTexturas("brazoDes.jpg"));
        bxHomIzq.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxBraDer = new Box(0.1f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("homTraje.jpg"));
        bxBraDer.setAppearance(1,textura.crearTexturas("brazoDes.jpg"));
        bxBraDer.setAppearance(4,textura.crearTexturas("brazoDes.jpg"));
        bxBraDer.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxBraIzq = new Box(0.1f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("homTraje.jpg"));
        bxBraIzq.setAppearance(1,textura.crearTexturas("brazoDes.jpg"));
        bxBraIzq.setAppearance(4,textura.crearTexturas("brazoDes.jpg"));
        bxBraIzq.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxMusDer = new Box(0.10f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("lTorso.jpg"));
        bxMusDer.setAppearance(1,textura.crearTexturas("pomaDer.jpg"));
        bxMusDer.setAppearance(4,textura.crearTexturas("bTorso.jpg"));
        bxMusDer.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxMusIzq = new Box(0.10f,0.15f,0.1f, paraTextura, textura.crearTexturas("lTorso.jpg"));
        bxMusIzq.setAppearance(1,textura.crearTexturas("pomaIzq.jpg"));
        bxMusIzq.setAppearance(4,textura.crearTexturas("bTorso.jpg"));
        bxMusIzq.setAppearance(5,textura.crearTexturas("brazoDes.jpg"));
        Box bxPrnDer = new Box(0.10f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("pie.jpg"));
        bxPrnDer.setAppearance(1,textura.crearTexturas("pieTra.jpg"));
        bxPrnDer.setAppearance(4,textura.crearTexturas("brazoDes.jpg"));
        bxPrnDer.setAppearance(5,textura.crearTexturas("lTorso.jpg"));
        Box bxPrnIzq = new Box(0.10f, 0.15f, 0.1f, paraTextura, textura.crearTexturas("pie.jpg"));
        bxPrnIzq.setAppearance(1,textura.crearTexturas("pieTra.jpg"));
        bxPrnIzq.setAppearance(4,textura.crearTexturas("brazoDes.jpg"));
        bxPrnIzq.setAppearance(5,textura.crearTexturas("lTorso.jpg"));
        
        Sphere spHomDer = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere spHomIzq = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere SpCodoDer = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere SpCodoIzq = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere SpMusDer = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere SpMusIzq = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere spPrnDer = new Sphere(0.01f, c.setColor(255, 0, 0));
        Sphere spPrnIzq = new Sphere(0.01f, c.setColor(255, 0, 0));        
        
        
       EscalarTG(tgPanza, 0.5f);
        MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(tgMundo);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        
        bgRaiz.addChild(myMouseRotate);
        bgRaiz.addChild(tgPanza);
        
        tgPanza.addChild(bxPanza);
        tgPanza.addChild(tgCabeza);
        tgPanza.addChild(tgSpHomDer);
        tgPanza.addChild(tgSpHomIzq);
        tgPanza.addChild(tgSpMusDer);
        tgPanza.addChild(tgSpMusIzq);
        tgSpHomDer.addChild(tgHomDer);
        tgSpHomIzq.addChild(tgHomIzq);
        tgSpHomDer.addChild(spHomDer);
        tgSpHomIzq.addChild(spHomIzq);
        tgSpMusDer.addChild(tgMusDer);
        tgSpMusIzq.addChild(tgMusIzq);
        tgSpMusDer.addChild(SpMusDer);
        tgSpMusIzq.addChild(SpMusIzq);
        tgHomDer.addChild(bxHomDer);
        tgHomIzq.addChild(bxHomIzq);
        tgMusDer.addChild(bxMusDer);
        tgMusIzq.addChild(bxMusIzq);
        tgHomDer.addChild(tgSpCodoDer);
        tgHomIzq.addChild(tgSpCodoIzq);
        tgMusDer.addChild(tgSpPrnDer);
        tgMusIzq.addChild(tgSpPrnIzq);
        
        tgSpCodoDer.addChild(tgBraDer);
        tgSpCodoIzq.addChild(tgBraIzq);
        tgSpCodoDer.addChild(SpCodoDer);
        tgSpCodoIzq.addChild(SpCodoIzq);
        tgSpPrnDer.addChild(tgPrnDer);
        tgSpPrnIzq.addChild(tgPrnIzq);
        tgSpPrnDer.addChild(spPrnDer);
        tgSpPrnIzq.addChild(spPrnIzq);
        
        tgBraDer.addChild(bxBraDer);
        tgBraIzq.addChild(bxBraIzq);
        tgPrnDer.addChild(bxPrnDer);
        tgPrnIzq.addChild(bxPrnIzq);
        tgCabeza.addChild(bxCabeza);
        
        float intensidad = 1.0f;
        // Luz lateral derecha
addPointLight(20.0f, 15.0f, 0.0f, r*intensidad, g*intensidad, b*intensidad);

// Luz lateral izquierda
addPointLight(-20.0f, 15.0f, 0.0f, r*intensidad, g*intensidad, b*intensidad);

// Luz centro bajo
addPointLight(0.0f, 12.0f, 0.0f, r*intensidad, g*intensidad, b*intensidad);

    }
    public void addPointLight(float x, float y, float z, float r, float g, float b) {
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

    PointLight pointLight = new PointLight(
         new Color3f(r, g, b),
            new Point3f(x, y, z),
            new Point3f(0.0f, 1.0f, 0.0f)
    );
    pointLight.setInfluencingBounds(bounds);
    bgRaiz.addChild(pointLight);
}

///CAMINAR SOBRE SU PROPIO EJE
    public void TrasladarGT(TransformGroup tg, float x,  float y, float z)
    {
         Transform3D leer = new Transform3D();
        Transform3D mover = new Transform3D();
        tg.getTransform(leer);
        
        mover.set(new Vector3f(x,y,z));
        leer.mul(mover);
        tg.setTransform(leer);
    }
//CAMBIAR TAMAÑO
   public void EscalarTG(TransformGroup tg, float x)
   {
       Transform3D leer = new Transform3D();
        Transform3D mover = new Transform3D();
        tg.getTransform(leer);
        
        mover.setScale(x);
        leer.mul(mover);
        tg.setTransform(leer);
   }       
    
    public void GirarTG(TransformGroup tg, int grados, String eje)
    {
        Transform3D leerArticulacion = new Transform3D();
        Transform3D moverArticulacion = new Transform3D();
        tg.getTransform(leerArticulacion);
        
        double angulo = Math.PI / 180 * grados; 

        if(eje.equals("X")) {
            moverArticulacion.rotX(angulo);
        } else if(eje.equals("Y")) {
            moverArticulacion.rotY(angulo);
        } else if(eje.equals("Z")) {
            moverArticulacion.rotZ(angulo);
        }
        leerArticulacion.mul(moverArticulacion);
        tg.setTransform(leerArticulacion);
    }
    public Vector3d getPosicionPersonaje() {
    Transform3D t3d = new Transform3D();
    tgPanza.getTransform(t3d);

    Vector3d pos = new Vector3d();
    t3d.get(pos);
    return pos;
}


     public void Caminar()
    {
       
        GirarTG(tgPanza, 0, "Z");
        
        if(pasos<10){
               GirarTG(tgSpMusDer, 5, "X");
               GirarTG(tgSpPrnDer, 5, "X");
               GirarTG(tgSpMusIzq, -5, "X");
               GirarTG(tgSpPrnIzq, 5, "X");
               
               GirarTG(tgSpHomIzq, 6, "X");
               GirarTG(tgSpCodoIzq, -4, "X");
               GirarTG(tgSpHomDer, -6, "X");
               GirarTG(tgSpCodoDer, -4, "X");
            }
        else
            if(pasos<20)
            {
               GirarTG(tgSpMusDer, -5, "X");
               GirarTG(tgSpPrnDer, -5, "X");
               GirarTG(tgSpMusIzq, 5, "X");
               GirarTG(tgSpPrnIzq, -5, "X");
               
               GirarTG(tgSpHomIzq, -6, "X");
               GirarTG(tgSpCodoIzq, 4, "X");
               GirarTG(tgSpHomDer, 6, "X");
               GirarTG(tgSpCodoDer, 4, "X");
        }else
             if(pasos<30)
             {
               GirarTG(tgSpMusDer, -5, "X");
               GirarTG(tgSpPrnDer, 5, "X");
               GirarTG(tgSpMusIzq, 5, "X");
               GirarTG(tgSpPrnIzq, 5, "X");
               
               GirarTG(tgSpHomIzq, -6, "X");
               GirarTG(tgSpCodoIzq, -4, "X");
               GirarTG(tgSpHomDer, 6, "X");
               GirarTG(tgSpCodoDer, -4, "X");
        }else
             if(pasos<40)
             {
               GirarTG(tgSpMusDer, 5, "X");
               GirarTG(tgSpPrnDer, -5, "X");
               GirarTG(tgSpMusIzq, -5, "X");
               GirarTG(tgSpPrnIzq, -5, "X");
               
               GirarTG(tgSpHomIzq, 6, "X");
               GirarTG(tgSpCodoIzq, 4, "X");
               GirarTG(tgSpHomDer, -6, "X");
               GirarTG(tgSpCodoDer, 4, "X");
             }
        pasos++;
    if (pasos >= 40) pasos = 0;

    TrasladarGT(tgPanza, 0.0f, 0.0f,  0.10f);

             TrasladarGT(tgPanza, 0.0f, 0.0f,  0.10f);
    }
     
    public TransformGroup getTgPanza() {
        return tgPanza;
    }

    public BranchGroup getBranchGroup() {
        return bgRaiz;
    }

    // Método que devuelve la bounding box actual del personaje
public BoundingRect getBoundingRectPersonaje() {
    Transform3D transform = new Transform3D();
    tgPanza.getTransform(transform);
    Vector3f pos = new Vector3f();
    transform.get(pos);

    float halfWidth = 0.20f;
    float halfDepth = 0.23f;

    return new BoundingRect(pos.x - halfWidth, pos.x + halfWidth,
                            pos.z - halfDepth, pos.z + halfDepth);
}

// Método que simula la bounding box en una posición específica (con adelanto según orientación)
public static BoundingRect getBoundingRectPersonaje(Vector3d posicion, float orientacion) {
    float halfWidth = 0.23f;
    float halfDepth = 0.23f;
    float adelanto = 0.10f;

    float dx = (float) Math.sin(orientacion) * adelanto;
    float dz = (float) Math.cos(orientacion) * adelanto;

    float x = (float) posicion.x + dx;
    float z = (float) posicion.z + dz;

    return new BoundingRect(
        x - halfWidth, x + halfWidth,
        z - halfDepth, z + halfDepth
    );
}

public static class BoundingRect {
    public float minX, maxX;
    public float minZ, maxZ;

    public BoundingRect(float minX, float maxX, float minZ, float maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public boolean intersects(BoundingRect other) {
        return (this.maxX >= other.minX && this.minX <= other.maxX &&
                this.maxZ >= other.minZ && this.minZ <= other.maxZ);
    }
}

     
    float edificioMinX = -5.0f;
    float edificioMaxX = 5.0f;
    float edificioMinZ = -5.0f;
    float edificioMaxZ = 5.0f;


public void moverPersonaje(float dx, float dz) {
    
    TrasladarGT(tgPanza, dx, 0.0f, dz);
    
    BoundingRect bbPersonaje = getBoundingRectPersonaje();
    
    if (bbPersonaje.minX < edificioMinX || bbPersonaje.maxX > edificioMaxX ||
        bbPersonaje.minZ < edificioMinZ || bbPersonaje.maxZ > edificioMaxZ) {
            
        TrasladarGT(tgPanza, -dx, 0.0f, -dz);
    }
}

public TransformGroup tgPiernaIzquierda;
public TransformGroup tgPiernaDerecha;
public TransformGroup tgBrazoIzquierdo;
public TransformGroup tgBrazoDerecho;

public TransformGroup getTgPiernaIzquierda() { return tgPiernaIzquierda; }

public TransformGroup getTgPiernaDerecha() {return tgPiernaDerecha;}

public TransformGroup getTgBrazoIzquierdo() {return tgBrazoIzquierdo;}

public TransformGroup getTgBrazoDerecho() {return tgBrazoDerecho;}

   public Transform3D getTransformPersonaje() {
    Transform3D t3d = new Transform3D();
    tgPanza.getTransform(t3d); // o el TransformGroup principal del personaje
    return t3d;
}
public static Appearance setSemiTransparente(float alpha) {
        Appearance apariencia = new Appearance();
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(new Color3f(1.0f, 1.0f, 1.0f));
        apariencia.setColoringAttributes(ca);

        TransparencyAttributes ta = new TransparencyAttributes();
        ta.setTransparencyMode(TransparencyAttributes.BLENDED);
        ta.setTransparency(alpha);
        apariencia.setTransparencyAttributes(ta);

        return apariencia;
    }

}


