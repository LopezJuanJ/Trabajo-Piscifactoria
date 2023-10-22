package Propiedades;

import java.util.Random;

public class Carnivoro {
    protected boolean alimentado;

    public int comerOmnivoro(int pecesMuertos, int comida){
        Random random = new Random();
        boolean comerMuerto = random.nextBoolean();
        boolean eliminarPez = random.nextBoolean();
        if (alimentado = false){ //Primero comprobar si esta alimentado
            if (comerMuerto = true){//Puede comer un muerto 
                alimentado=true; 
                if(eliminarPez=true){ //comprobamos si se elimina o no
                    pecesMuertos--;
                }
            } 
        }
        return comida;
    }
}
