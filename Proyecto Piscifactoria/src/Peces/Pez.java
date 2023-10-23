package Peces;
import java.util.Arrays;
import java.util.Random;

import Peces.Propiedades.Activo;
import Peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;
import propiedades.PecesProps;


public abstract class Pez {

    protected int edad = 0;
    private boolean sexo;
    private boolean fertilidad;
    private boolean vida;
    private boolean alimentado;
    protected PecesDatos datos;
    

  
    public Pez (boolean sexo, PecesDatos datos) {
        this.edad = 0;
        this.sexo = true;
        this.datos = datos;
        
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


    /**
     * Método para saber la posibilidad de vida de un pez
     */
    public void comprobarVida(){
        Random random = new Random();
        if (alimentado = false){
            if (random.nextBoolean()){
                this.edad++;
            } else {
                this.vida=false;
            }
        }
    }

    


    public void grow(String nombrePez) {
        PecesDatos datos = AlmacenPropiedades.getPropByName(nombrePez);
       

    }
    public void reset() {
        this.edad = 0;
        this.fertilidad = false;
        this.vida = true;
        this.alimentado = false;  

    }
    
}
