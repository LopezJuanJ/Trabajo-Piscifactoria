package Piscifactoria;

import java.util.ArrayList;

import Peces.IRio;
import Peces.Pez;
import Tanque.Tanque;

public  class Piscifactoria {
    protected int comidaActual;
    protected int comidaMaxima;
    protected int espacioMaximo;
    protected String nombre;
    
   
    protected String tipo;
    public ArrayList<Tanque<? extends Pez>> tanques;
    
     public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int obtenerComidaMaximaPis(){
        if(this instanceof IRio){
        return  25;
    }else{
        return 100;
    }   
    }

    
    public int obtenerCapacidadMaximaPis(){
        if(this instanceof IRio){
        return  25;
    }else{
        return 100;
    }
    }
    public Piscifactoria(String nombre) {
        
        this.nombre = nombre;
    }
    public int getComidaMaxima() {
        return comidaMaxima;
    }
    public void setComidaMaxima(int comidaMaxima) {
        this.comidaMaxima = comidaMaxima;
    }
    public int getComidaActual() {
        return comidaActual;
    }
    public void setComidaActual(int comidaActual) {
        this.comidaActual = comidaActual;
    }

    public void showStatus(){
    System.out.println("=============== nombre ===============");
    System.out.println("Tanques: ");
    System.out.println("Ocupación: peces / max (x%)");
    System.out.println("Peces vivos: vivos / total (x%)");
    System.out.println("Peces alimentados: alimentados / vivos (x%)");
    System.out.println("Hembras / Machos: H/M");
    System.out.println("Fértiles: fértiles / vivos");
    System.out.println("Almacén de comida: actual / max (x%)");
    }
    public void showTankStatus(){
    for (Tanque tanque: tanques){
        
        String nombreTanque = tanque.getNombre();
        Tanque<? extends Pez> tnq = new Tanque<Pez>(nombreTanque, obtenerCapacidadMaximaPis());
        tnq.showStatus();
    }
     
    

    }
    public void showFishStatus(){
        Tanque<? extends Pez> tnq = new Tanque<Pez>(nombre, comidaActual);
        tnq.showFishStatus();
    }
    public void showCapacity(){
    
    }
    public void showFood(){
    
    }
    public void nextDay(){

    }
    public void sellFish(){
    
    }
    public void upgradeFood(){
    
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  
}
