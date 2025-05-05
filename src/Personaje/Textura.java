
package Personaje;

import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import java.io.File;
import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;


public class Textura {
    public Appearance crearTexturas (String nomarch)
    {
        File file = new File("");
        String ruta = file.getAbsolutePath()+
                "\\src\\img\\";
        TextureLoader loader = new 
            TextureLoader((ruta+nomarch),new Container());
        Texture texture = loader.getTexture();
        Appearance app = new Appearance();
        app.setTexture(texture);
/////////////////////////////////////////////////////////////////////////
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE); 
        app.setTextureAttributes(texAttr);
        
        Material material = new Material();
        material.setAmbientColor(new Color3f(0.2f, 0.2f, 0.2f));
        material.setDiffuseColor(new Color3f(0.5f, 0.5f, 0.5f)); 
        material.setSpecularColor(new Color3f(0.1f, 0.1f, 0.1f)); 
        material.setShininess(50.0f);
        app.setMaterial(material);
        
        return app;
        
    }

}
