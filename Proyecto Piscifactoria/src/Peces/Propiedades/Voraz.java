package Peces.Propiedades;

import Peces.Pez;
import propiedades.PecesDatos;

public class Voraz extends Pez {
    public Voraz(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    protected boolean alimentado;

    public int comerVoraz(int comida){
        if(alimentado=false){
            comida-=2;
            alimentado=true;
        }
        return comida;
    }
}
