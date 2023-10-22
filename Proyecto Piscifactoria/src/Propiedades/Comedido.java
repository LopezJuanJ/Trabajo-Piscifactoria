package Propiedades;

import java.util.Random;

public class Comedido {
    protected boolean alimentado;

    public int comerComedido(int comida){
        Random random = new Random();
        
        int comerComida = random.nextInt(4);
        if (alimentado = false){ //Primero comprobar si esta alimentado
            if(comerComida == 0){// Tiene 25% de comer (1 entre 4) 
                comida--;
                alimentado = true;
            }
        }
        return comida;
    }
}
