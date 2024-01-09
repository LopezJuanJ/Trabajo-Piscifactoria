package Peces.Propiedades;


import java.util.Random;

import Peces.Pez;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;


public class Filtrador extends Pez {
    
    public Filtrador(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }
    public Filtrador(PecesDatos datos) {
        super(false, datos);
        //TODO Auto-generated constructor stub
    }

    private boolean alimentado;

    /**
     * Implementacion para que un pez Filtrador coma.
     * @param tanque El tanque en el que se encuentra el pez.
     * @param piscifactoria La piscifactoria a la que pertenece el tanque.
     */
    @Override
    public void comer(Tanque tanque, Piscifactoria piscifactoria) {
       Random random = new Random();
       int comida = piscifactoria.getComidaActual();
       boolean comer = random.nextBoolean();
       if(alimentado == false){
        if(comer==true){
            comida--;
            alimentado=true;
        } else{

        }

       }
    }


    
}
