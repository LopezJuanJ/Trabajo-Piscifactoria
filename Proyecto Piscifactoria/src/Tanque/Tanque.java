package Tanque;

import java.util.ArrayList;

import Peces.Pez;

public class Tanque <T extends Pez> {
    public ArrayList<T> peces;
    public int capacidad;
    
    
    public Tanque(ArrayList<T> peces, int capacidad) {
        this.peces = peces;
        this.capacidad = capacidad;
    }



    /**
     * 
     */
    
    public int getPecesMuertos() {
        int pecesMuertos = 0;
        for(T pez: peces){
            if(!pez.isVida()){
                pecesMuertos++;
            }
        }
        return pecesMuertos;
    }

    

    public void showFishStatus(){
        

    }
    public void nextDay(){
        for(T pez : peces){
            //pez.grow();
        }
    }
    public void showCapacity(){
        int ocupacion = (int)((double) peces.size()/capacidad * 100);
    }

}

    