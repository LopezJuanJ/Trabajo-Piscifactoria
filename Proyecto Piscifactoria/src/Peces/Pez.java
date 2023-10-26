package Peces;

import java.security.cert.TrustAnchor;
import java.util.Random;

import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;


public abstract class Pez {

    protected int edad = 0;
    protected boolean sexo;

    public boolean fertilidad;
    protected boolean vida;
    protected boolean alimentado;
    protected PecesDatos datos;
    protected int ciclo;
    public abstract void comer(Tanque tanque, Piscifactoria piscifactoria);
    

    public Pez (boolean sexo, PecesDatos datos) {
        this.edad = 0;
        this.sexo = sexo;
        this.datos = datos;
        
    }
    public boolean isFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(boolean fertilidad) {
        this.fertilidad = fertilidad;
    }
    public boolean isAlimentado() {
        return alimentado;
    }

    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
    }
    public void showStatus() {
        System.out.println("---------------" + this.datos.getNombre() + "---------------");
        System.out.println("Edad " + edad + "dias");
        System.out.println("Sexo: " + sexo);
        if(alimentado = true){
            System.out.println("Alimentado: Si");
        } else {
            System.out.println("Alimentado: No");
        }

        if (fertilidad = true) {
            System.out.println("Fertilidad: Si");
        } else {
            System.out.println("Fertilidad: No");
        };

        if(vida = true){
            System.out.println("Vivo: Si");
        } else {
            System.out.println("Vivo: No");
        }

        if (edad > 5){
            System.out.println("Adulto: Si");
        }else{
            System.out.println("Adulto: No");
        }
    }

   
   

    
    public boolean verificarMadurez(){
        if (this.edad >= datos.getMadurez()){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Método que comprobar si un pez esta alimentado 
     * @param comida Cantidad de comida restante en el almacén 
     */
    public void comprobarComida(int comida){
            if (comida == 0){
            alimentado=false;
        }else{
            alimentado=true;
        }
             
    }



    public void grow(Tanque<? extends Pez> tanque, Piscifactoria piscifactoria ) {
        Random random = new Random();
        if(this.vida = true){
            comer(tanque, piscifactoria);            
            if(!alimentado && !random.nextBoolean()){
                this.vida = false;
            }else{
                this.edad++;
                
            }
           if (verificarMadurez()){
                this.ciclo--;
           } 
           if( this.ciclo == 0){
            this.fertilidad=true;
           } else{
            this.fertilidad=false;
        }
        }
    }
    
    
    public void reset() {
        this.edad = 0;
        this.fertilidad = false;
        this.vida = true;
        this.alimentado = false;  

    }


    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

      public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

  
}
