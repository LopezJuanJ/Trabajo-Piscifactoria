package Peces.Propiedades;


import java.util.Random;

import Peces.Pez;
import propiedades.PecesDatos;


public class Filtrador extends Pez {
    
    public Filtrador(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }


    private boolean alimentado;
   

    public int comerFiltrador(int comida){
        Random random = new Random();
        if (alimentado = false){
            if (random.nextBoolean()){
                //Come
                comida--;
                alimentado=true;
            } 
        }
        return comida;
    }
}
