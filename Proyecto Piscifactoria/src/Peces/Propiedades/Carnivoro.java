package Peces.Propiedades;

import java.util.Random;

import Peces.Pez;
import propiedades.PecesDatos;

public class Carnivoro extends Pez{
    public Carnivoro(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    protected boolean alimentado;

    public int comerCarnivoro(int pecesMuertos, int comida){
        Random random = new Random();
        boolean comerMuerto = random.nextBoolean();
        boolean eliminarPez = random.nextBoolean();
        if (this.alimentado = false){ //Primero comprobar si esta alimentado
            if (comerMuerto = true){//Puede comer un muerto 
                
                alimentado=true;
                if(eliminarPez=true){ //comprobamos si se elimina o no
                    pecesMuertos--;
                }
                return 1; 

            } else {
                return 0;
            }
        } else{
            return 0; 
        }
    }
}
