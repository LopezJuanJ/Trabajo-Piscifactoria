package Peces.Propiedades;

import java.util.Random;

import Peces.Pez;
import propiedades.PecesDatos;

public class Activo extends Pez {
    public Activo(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    protected boolean alimentado;

    public int comerActivo(int comida){
        Random random = new Random();
        if (alimentado = false){
            if(comida >0){
                if (random.nextBoolean()){
                //Come
                comida-=2;
                alimentado=true;
            }
            }
             
        }
        return comida;
    }
}
