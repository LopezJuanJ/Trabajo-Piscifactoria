package Propiedades;

import java.util.Random;

public class Activo {
    protected boolean alimentado;

    public void comerActivo(int comida){
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
    }
}
