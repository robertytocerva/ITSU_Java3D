package colisiones;


import javax.media.j3d.TransformGroup;

public class ObjetoConColision {
    private String nombre;
    private TransformGroup tg;
    private double ancho, largo;

    public ObjetoConColision(String nombre, TransformGroup tg, double ancho, double largo) {
        this.nombre = nombre;
        this.tg = tg;
        this.ancho = ancho / 2.0; // radio para comparación
        this.largo = largo / 2.0;
    }

    public TransformGroup getTransformGroup() { return tg; }
    public double getAncho() { return ancho; }
    public double getLargo() { return largo; }
    public String getNombre() { return nombre; }
}
