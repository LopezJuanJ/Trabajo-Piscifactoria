package Peces.Propiedades;

import java.util.Random;

import Peces.Pez;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;

public class Activo extends Pez {
    public Activo(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    protected boolean alimentado;

     @Override
    public void comer(Tanque tanque, Piscifactoria piscifactoria) {
       Random random = new Random();
        int comida = piscifactoria.getComidaActual();
        if(alimentado= false){
        comida--;
        if(random.nextBoolean()){
            comida--;
            alimentado=true;
        }else{
            alimentado=true;
        }
       } 
    }

}    

