
package Muebles;
import ESCENARIO.Color;
import colisiones.ObjetoConColision;
import colisiones.Pared;
import static colisiones.Pared.crearPared;
import java.util.List;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.PointLight;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;



public class Fuera extends BranchGroup{
    private TransformGroup tgSalon;
    public Puerta miPuerta1;
    public Puerta miPuerta2;
    public Fuera(boolean conPiso,List<ObjetoConColision> obstaculos) {
    tgSalon = new TransformGroup();
    tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 
    tgSalon.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 


    tgSalon.addChild(crearPared(15.0f, 0.1f, 31f,
            new Vector3d(-4.5, 6.7, 6.0), crearApariencia(255,255,255)));

    tgSalon.addChild(crearPared(19.4f, 1.0f, 32.0f,
            new Vector3d(-4.5, 7.4, 6.0), crearApariencia(238,128,31)));

    tgSalon.addChild(crearPared(19.4f, 0.1f, 32.0f,
            new Vector3d(-4.5, 7.4, 6.0), crearApariencia(255,255,255)));

    miPuerta1 = new Puerta(
    new Vector3d(3.3, 0.0, 4.8),   
    new Vector3d(0.0, 1.3, 0.0)    
    );
    tgSalon.addChild(miPuerta1.getTransformGroup());
    miPuerta2 = new Puerta(
        new Vector3d(3.3, 0.0, 7.6),
        new Vector3d(0.0, 1.3, 0.0)
    );
    tgSalon.addChild(miPuerta2.getTransformGroup());



    

    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 0.90f,
            new Vector3d(3.9, 3.3, 3.0), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, 1.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, 0.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, -1.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, -3.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9,- 4.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, -6.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, -7.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 0.70f,
            new Vector3d(3.9, 3.3, -9.0), crearApariencia(239,149,76)));

    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(3.2, 4.6, -3.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(3.2, 2.4, -3.0), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(1.7f, 0.9f, 12.0f,
            new Vector3d(3.9, 7.0, -3.0), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.40f, 1.0f, 12.0f,
            new Vector3d(3.5, 3.6, -3.0), crearApariencia(255,255,255)));



    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 0.90f,
            new Vector3d(-12.8, 3.3, 3.0), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, 1.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, 0.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, -1.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, -3.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, -4.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, -6.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, -7.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 0.70f,
            new Vector3d(-12.8, 3.3, -9.0), crearApariencia(239,149,76)));

    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(-12.2, 4.6, -3.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(-12.2, 2.4, -3.0), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(1.7f, 0.9f, 12.0f,
            new Vector3d(-12.8, 7.0, -3.0), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.9f, 12.0f,
            new Vector3d(-12.2, 3.3, -3.0), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearParedConColision(0.1f, 1.0f, 6.0f,
            new Vector3d(3.3, 2.8, 6.1), Color.setSemiTransparente(0.20f),"ep", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 2.1f, 1.4f,
            new Vector3d(3.3, 1.3, 4.1), Color.setSemiTransparente(0.20f),"ep", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 2.1f, 1.4f,
            new Vector3d(3.3, 1.3, 8.3), Color.setSemiTransparente(0.20f), "ep", obstaculos));





    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 1.0f,
            new Vector3d(3.9, 3.3, 21.5), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, 20.0), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, 17.9), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, 16.4), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, 14.9), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, 13.4), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(3.2, 3.3, 11.9), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(3.2, 3.9, 10.9), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(1.7f, 8.0f, 1.0f,
            new Vector3d(3.9, 3.3, 9.5), crearApariencia(239,149,76)));

    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(3.2, 4.6, 15.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(3.2, 2.4, 15.5), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(1.7f, 0.9f, 12.0f,
            new Vector3d(3.9, 7.0, 15.5), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.9f, 12.0f,
            new Vector3d(3.2, 3.3, 15.5), crearApariencia(255,255,255)));




    tgSalon.addChild(Pared.crearPared(1.8f, 8.0f, 0.90f,
            new Vector3d(-12.8, 3.3, 21.5), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, 20.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, 18.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, 17.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, 15.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, 14.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 8.0f, 0.70f,
            new Vector3d(-12.0, 3.3, 12.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.5f, 6.5f, 0.10f,
            new Vector3d(-12.0, 3.9, 11.0), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(1.8f, 8.0f, 0.70f,
            new Vector3d(-12.8, 3.3, 9.5), crearApariencia(239,149,76)));

    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(-12.2, 4.6, 15.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.2f, 12.0f,
            new Vector3d(-12.2, 2.4, 15.5), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearPared(1.8f, 0.9f, 20.0f,
            new Vector3d(-12.8, 7.0, 11.9), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.10f, 0.9f, 12.0f,
            new Vector3d(-12.2, 3.3, 15.5), crearApariencia(255,255,255)));




    tgSalon.addChild(Pared.crearPared(1.7f, 0.9f, 7.0f,
            new Vector3d(3.9, 7.0, 6.5), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.01f, 0.9f, 30.4f,
            new Vector3d(3.3, 6.0, 6.5), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.01f, 1.9f, 12.0f,
            new Vector3d(3.1, 3.4, -2.9), crearApariencia(251,173,104)));
    tgSalon.addChild(Pared.crearPared(0.01f, 1.9f, 12.0f,
            new Vector3d(3.1, 3.4, 15.3), crearApariencia(251,173,104)));
    tgSalon.addChild(Pared.crearPared(0.01f, 1.0f, 12.0f,
            new Vector3d(3.3, 0.7, -2.9), crearApariencia(239,149,76)));
    tgSalon.addChild(Pared.crearPared(0.01f, 1.0f, 12.0f,
            new Vector3d(3.3, 0.7, 15.3), crearApariencia(239,149,76)));



    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 5.3, 4.1), Color.setSemiTransparente(0.20f),"va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 5.3,6.9 ), Color.setSemiTransparente(0.10f), "va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f,4.1f, 1.4f,
            new Vector3d(-12.3, 5.3, 5.5), Color.setSemiTransparente(0.10f),"va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 5.3, 8.3), Color.setSemiTransparente(0.20f), "va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 1.3, 4.1), Color.setSemiTransparente(0.20f),"va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 1.3,6.9 ), Color.setSemiTransparente(0.10f), "va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f,4.1f, 1.4f,
            new Vector3d(-12.3, 1.3, 5.5), Color.setSemiTransparente(0.10f),"va", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(0.1f, 4.1f, 1.4f,
            new Vector3d(-12.3, 1.3, 8.3), Color.setSemiTransparente(0.20f), "va", obstaculos));

    tgSalon.addChild(Pared.crearParedConColision(16.0f, 1.0f, 0.1f,
            new Vector3d(-5.0, 3.5, 21.4 ), crearApariencia(255,255,255), "paredAbajoDer", obstaculos));

    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 1.4, 21.3),crearApariencia(239,149,76), "paredFrontalFondo", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 5.0, 21.3), crearApariencia(239,149,76), "paredSeparadoraOficinas", obstaculos)); ////
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(-8.9, 1.4, 21.3),crearApariencia(239,149,76), "paredFrontalFondo", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(-8.9, 5.0, 21.3), crearApariencia(239,149,76), "paredSeparadoraOficinas", obstaculos)); ///////// UTILIZAR PARA SEPARAR OFICINAS
    
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 1.5f, 0.1f,
            new Vector3d(-4.5, 0.8, 21.3), crearApariencia(239,149,76), "ventanaAbajo", obstaculos )); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f,
            new Vector3d(-4.5, 2.9, 21.3), crearApariencia(239,149,76), "ventanaArriba", obstaculos)); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 1.4f, 0.1f,
            new Vector3d(-4.5, 4.4, 21.3), crearApariencia(239,149,76), "ventanaAbajo", obstaculos )); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f,
            new Vector3d(-4.5, 6.2, 21.3), crearApariencia(239,149,76), "ventanaArriba", obstaculos)); // no tocar
    tgSalon.addChild(Pared.crearPared(1.0f, 6.7f, 0.4f,
            new Vector3d(-6.3, 3.5, 21.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(1.0f, 6.7f, 0.4f,
            new Vector3d(-2.7, 3.5, 21.5), crearApariencia(255,255,255)));

    tgSalon.addChild(Pared.crearParedConColision(16.0f, 1.0f, 0.1f,
            new Vector3d(-5.0, 3.5, -9.4 ), crearApariencia(255,255,255), "paredAbajoDer", obstaculos));

    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 1.4, -9.3),crearApariencia(239,149,76), "paredFrontalFondo", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(0.0, 5.0, -9.3), crearApariencia(239,149,76), "paredSeparadoraOficinas", obstaculos)); ////

    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(-8.9, 1.4, -9.3),crearApariencia(239,149,76), "paredFrontalFondo", obstaculos));
    tgSalon.addChild(Pared.crearParedConColision(6.0f, 3.0f, 0.1f,
            new Vector3d(-8.9, 5.0, -9.3), crearApariencia(239,149,76), "paredSeparadoraOficinas", obstaculos)); ///////// UTILIZAR PARA SEPARAR OFICINAS
    
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 1.5f, 0.1f,
            new Vector3d(-4.5, 0.8, -9.3), crearApariencia(239,149,76), "ventanaAbajo", obstaculos )); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f,
            new Vector3d(-4.5, 2.9, -9.3), crearApariencia(239,149,76), "ventanaArriba", obstaculos)); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 1.4f, 0.1f,
            new Vector3d(-4.5, 4.4, -9.3), crearApariencia(239,149,76), "ventanaAbajo", obstaculos )); // no tocar
    tgSalon.addChild(Pared.crearParedConColision(2.9f, 0.5f, 0.1f,
            new Vector3d(-4.5, 6.2, -9.3), crearApariencia(239,149,76), "ventanaArriba", obstaculos)); // no tocar
    tgSalon.addChild(Pared.crearPared(1.0f, 6.7f, 0.4f,
            new Vector3d(-6.3, 3.5, -9.5), crearApariencia(255,255,255)));
    tgSalon.addChild(Pared.crearPared(1.0f, 6.7f, 0.4f,
            new Vector3d(-2.7, 3.5, -9.5), crearApariencia(255,255,255)));


    tgSalon.addChild(Pared.crearPared(3.0f, 1.0f, 0.1f,
            new Vector3d(-4.3, 5.4, 21.3), Color.setSemiTransparente(0.1f)));
    tgSalon.addChild(Pared.crearPared(3.0f, 1.0f, 0.1f,
            new Vector3d(-4.3, 5.5, -9.4), Color.setSemiTransparente(0.1f)));
    tgSalon.addChild(Pared.crearPared(3.0f, 1.0f, 0.1f,
            new Vector3d(-4.3, 2.2, -9.4), Color.setSemiTransparente(0.1f)));

    addPointLight(0.0f, 35.0f, 10.0f, 116*luz, 128*luz, 129*luz);// ilumina la parte de arriba
        addPointLight(10.0f, 10.0f, 1.0f, 116*luminosidad, 128*luminosidad, 129*luminosidad);// ilumnina la parte de abajo
        addPointLight(10.0f, -10.0f, -5.0f, 116*luminosidad, 128*luminosidad, 129*luminosidad);
        addPointLight(0.0f, -30.0f, 05.0f, 116*luz, 128*luz, 129*luz);
        addPointLight(150.0f, -10.0f, 2.0f, 116*luz, 128*luz, 129*luz);
     }
    int luminosidad;
    int luz;


    
    public void addPointLight(float x, float y, float z, float r, float g, float b) {
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

        PointLight pointLight = new PointLight(
            new Color3f(r, g, b),
            new Point3f(x, y, z),
            new Point3f(1.0f, 0.0f, 0.0f)
        );
        pointLight.setInfluencingBounds(bounds);
        tgSalon.addChild(pointLight);
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

