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

    public void showStatus(){
        System.out.println("=============== Tanque # ===============");
        System.out.println("Ocupacion: " + showCapacity());
        System.out.println("Peces vivos");
        System.out.println("Peces alimentados: ");
        System.out.println("Peces adultos: ");
        System.out.println("Hembras/Machos: ");
        System.out.println("Fertiles: ");
    }


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
        for(T pez : peces){
            pez.showStatus();
        }

    }
    public void nextDay(){
        for(T pez : peces){
            //pez.grow();
        }
    }
    public int showCapacity(){
        int ocupacion = (int)((double) peces.size()/capacidad * 100);
        this.capacidad = ocupacion;
        return capacidad;
    }
    
    public void reproduccion() {
        boolean machoFertil = false;
        boolean hembraFertil = false;
    
        for(T pez : peces){
            if(pez.isSexo() && pez.fertilidad){
                machoFertil = true;
            } else if(!pez.isSexo()  && pez.fertilidad){
                hembraFertil = true;
            }
    
            if(machoFertil && hembraFertil){
                System.out.println("Los peces se pueden reproducir");
                break;
            }
        }
    
        if(!machoFertil || !hembraFertil){
            System.out.println("Los peces no se pueden reproducir");
        }
    }
   
    
}
    