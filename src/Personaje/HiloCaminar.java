package Personaje;

import java.util.logging.Level;
import java.util.logging.Logger;


    public class HiloCaminar extends Thread
    {
        crearEscenaGrafica4 escena  = new crearEscenaGrafica4();       
        
        public HiloCaminar(crearEscenaGrafica4 es)
        {
            escena = es;
        }
        public void run()
        {
            while (true) 
            {                
                escena.Caminar();
                
                try {
                    Thread.sleep(90);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloCaminar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
         }
    
    }

