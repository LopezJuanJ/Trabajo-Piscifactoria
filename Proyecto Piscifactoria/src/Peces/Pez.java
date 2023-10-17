package Peces;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public abstract class Pez {

    private int edad = 0;
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
         


        if(vida = true){
            System.out.println("Vivo: Si");
        } else {
            System.out.println("Vivo: No");
        }



        if (fertilidad = true) {
            System.out.println("Fertilidad: Si");
        } else {
            System.out.println("Fertilidad: No");
        };

        if (edad > 5){
            System.out.println("Adulto: Si");
        }else{
            System.out.println("Adulto: No");
        }
    }

    


    public void grow() {

    }
    public void reset() {
        edad = 0;
        fertilidad = false;
        vida = true;
        alimentado = false;  

    }
    
}
