package Peces.Propiedades;

import java.util.Random;

import Peces.Pez;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;

public class CarnivoroActivo extends Pez{
    protected boolean alimentado;

    public CarnivoroActivo(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }
    public CarnivoroActivo(PecesDatos datos) {
        super(false, datos);
        //TODO Auto-generated constructor stub
    }
 /**
     * Implementacion para que un pez Activo y Carnivoro coma.
     * @param tanque El tanque en el que se encuentra el pez.
     * @param piscifactoria La piscifactoria a la que pertenece el tanque.
     */
    @Override
    public void comer(Tanque tanque, Piscifactoria piscifactoria) {
        Random random = new Random();
        int comida = piscifactoria.getComidaActual();
         int pecesMuertos = tanque.getPecesMuertos();
         boolean comerMuerto = random.nextBoolean();
         boolean eliminarPez = random.nextBoolean();
         if (this.alimentado == false){ //Primero comprobar si esta alimentado
             if(pecesMuertos> 0){
             if (comerMuerto == true){//Puede comer un muerto 
                 alimentado=true;
                 if(eliminarPez==true){ //comprobamos si se elimina o no
                     pecesMuertos--;
                 }                
             }else{
                if(random.nextBoolean()){
                    comida-=2;
                }else{
                    comida--;
                }
             }  
         } else{ 
         } 
             }
        
    }
}
