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

    protected boolean alimentado;


    @Override
    public void comer(Tanque tanque, Piscifactoria piscifactoria) {
        int comida = piscifactoria.getComidaActual();
        if(alimentado=false){
            comida-=2;
            alimentado=true;
        }


    }
}
