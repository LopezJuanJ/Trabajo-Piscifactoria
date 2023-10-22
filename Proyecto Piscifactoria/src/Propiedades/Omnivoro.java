package Propiedades;

import java.util.Random;

public class Omnivoro {
    protected boolean alimentado;

    public int comerOmnivoro(int pecesMuertos, int comida){
        Random random = new Random();
        boolean comerMuerto = random.nextBoolean();
        boolean eliminarPez = random.nextBoolean();
        int comerComida = random.nextInt(4);
        if (alimentado = false){ //Primero comprobar si esta alimentado
            if (comerMuerto = true){ //Puede comer un muerto 
                alimentado=true;
                if(eliminarPez=true){ //comprobamos si se elimina o no
                    pecesMuertos--;
                }
            } else if(comerComida == 0){// Si no come un pez , tiene 25% de comer (1 entre 4) 
                comida--;
                alimentado=true;
            }
        }
        return comida;
    }

}
