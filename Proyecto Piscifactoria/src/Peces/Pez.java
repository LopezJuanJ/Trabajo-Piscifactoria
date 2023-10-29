package Peces;

import java.util.Random;

import Almacen.AlmacenCentral;
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
    
    /** Método abstracto para que los subclases implementen la lógica de alimentación.
     * @param tanque
     * @param piscifactoria
     */
    public abstract void comer(Tanque<? extends Pez> tanque, Piscifactoria piscifactoria);
    
    /**
     * Constructor de la clase Pez.
     * @param sexo El sexo del pez (true --> macho, false --> hembra).
     * @param datos Los datos del pez en la libreria.
     */
    public Pez (boolean sexo, PecesDatos datos) {
        this.edad = 0;
        this.sexo = sexo;
        this.datos = datos;
        
    }
     /**
     * Muestra todos los datos del pez.
     */
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

   
   
    /**
     * Comprueba si el pez es maduro.
     * @return true --> maduro, false en caso contrario.
     */
    public boolean verificarMadurez(){
        if (this.edad >= datos.getMadurez()){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Método que comprobar si un pez esta alimentado.
     * @param comida Cantidad de comida restante.
     */
    public void comprobarComida(int comida){
            if (comida == 0){
            alimentado=false;
        }else{
            alimentado=true;
        }
             
    }

    
    /**
     * Método que permite al pez crecer. Se alimenta, aumenta su edad y se comprueba la fertilidad y su madurez.
     * @param tanque El tanque en el que se encuentra el pez.
     * @param piscifactoria La piscifactoria a la que pertenece el tanque.
     */

    public void grow(Tanque<? extends Pez> tanque, Piscifactoria piscifactoria ) {
        Random random = new Random();
        boolean ferti ;
        if(this.vida = true){
            AlmacenCentral almacenCentral = AlmacenCentral.getInstance();
            comer(tanque, piscifactoria);            
            if(!this.alimentado && !random.nextBoolean()){
                this.vida = false;
            }else{
                this.edad++;
                
            }
           if (verificarMadurez()){
                this.ciclo--;
           } 
           if( this.ciclo == 0){
            ferti = this.fertilidad=true;
           } else{
            ferti = this.fertilidad=false;
            this.fertilidad=false;
        }
        }
    }
    
   /**
     * Reinicia las propiedades del pez a sus valores iniciales.
     */  
    public void reset() {
        this.edad = 0;
        this.fertilidad = false;
        this.vida = true;
        this.alimentado = false;  

    }
    /**
     * Obtiene el estado de fertilidad del pez.
     * @return true --> fértil, false si no lo es.
     */
     public boolean isFertilidad() {
        return fertilidad;
    }

    /**
     * Establece el estado de fertilidad del pez.
     * @return true --> fértil, false si no lo es.
     */
    public void setFertilidad(boolean fertilidad) {
        this.fertilidad = fertilidad;
    }
    
    /**
     * Obtiene el estado de alimentación del pez.
     * @return true --> alimentado, false si no lo está
     */
    public boolean isAlimentado() {
        return alimentado;
    }

    /**
     * Establece el estado de alimentación del pez.
     * @return true --> alimentado, false si no lo está.
     */
    public void setAlimentado(boolean alimentado) {
        this.alimentado = alimentado;
    }

     /**
     * Obtiene el estado de vida del pez.
     * @return true --> vivo, false si no está vivo.
     */
    public boolean isVida() {
        return vida;
    }
    /**
     * Establece el estado de vida del pez.
     * @param vida true si el pez está vivo, false en caso contrario.
     */
    public void setVida(boolean vida) {
        this.vida = vida;
    }

     /**
     * Obtiene el sexo del pez.
     * @return true --> macho, false --> hembra.
     */
      public boolean isSexo() {
        return sexo;
    }
    /**
     * Establece el sexo del pez.
     * @return true --> macho, false --> hembra.
     */
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
     /**
     * Obtiene los datos de la librería del pez.
     * @return
     */
    public PecesDatos getDatos() {
        return datos;
    }


    /**
     *  Establece los datos de la librería del pez.
     * @param datos datos del pez
     */
    public void setDatos(PecesDatos datos) {
        this.datos = datos;
    }
  
    
}
