package Propiedades;


import java.util.Random;


public class Filtrador {
    
    private boolean alimentado;
   

    public void comerFiltrador(int comida){
        Random random = new Random();
        if (alimentado = false){
            if (random.nextBoolean()){
                //Come
                comida--;
                alimentado=true;
            } 
        }
    }
}
