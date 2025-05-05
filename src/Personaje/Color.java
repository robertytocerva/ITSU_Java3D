
package Personaje;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.Color3f;


public class Color 
{
    Appearance appColor;
    public Appearance setColor(int a, int b, int c)
    {
        appColor = new Appearance();
        Color3f color= new Color3f(a/255f,b/255f,c/255f);
        ColoringAttributes atributoscolor = new ColoringAttributes(color,ColoringAttributes.SHADE_FLAT);
        appColor.setColoringAttributes((atributoscolor));
        return appColor;
    }
     public static Appearance setSemiTransparente(float nivel) {
        Appearance app = new Appearance();

        TransparencyAttributes ta = new TransparencyAttributes();
        ta.setTransparencyMode(TransparencyAttributes.BLENDED);
        ta.setTransparency(nivel); // entre 0.0 (sólido) y 1.0 (invisible)
        app.setTransparencyAttributes(ta);

        ColoringAttributes ca = new ColoringAttributes(new Color3f(1f, 1f, 1f), ColoringAttributes.SHADE_FLAT);
        app.setColoringAttributes(ca);

        return app;
    }
     public static Appearance setTransparente() {
        Appearance app = new Appearance();

        TransparencyAttributes ta = new TransparencyAttributes();
        ta.setTransparencyMode(TransparencyAttributes.FASTEST);
        ta.setTransparency(1.0f); // invisible
        app.setTransparencyAttributes(ta);

        ColoringAttributes ca = new ColoringAttributes(new Color3f(1f, 1f, 1f), ColoringAttributes.SHADE_FLAT);
        app.setColoringAttributes(ca);

        return app;
    }
}
