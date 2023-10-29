package Peces.Propiedades;

import java.util.Random;

import Peces.Pez;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;

public class Voraz extends Pez {
    public Voraz(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    public Voraz(PecesDatos datos) {
        super(false, datos);
        //TODO Auto-generated constructor stub
    }

    protected boolean alimentado;

     /**
     * Implementacion para que un pez Voraz coma.
     * @param tanque El tanque en el que se encuentra el pez.
     * @param piscifactoria La piscifactoria a la que pertenece el tanque.
     */
    @Override
    public void comer(Tanque tanque, Piscifactoria piscifactoria) {
        int comida = piscifactoria.getComidaActual();
        if(alimentado=false){
            comida-=2;
            alimentado=true;
        }


    }
}
