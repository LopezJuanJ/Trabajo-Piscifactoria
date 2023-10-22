package Peces;


import propiedades.PecesDatos;
import propiedades.AlmacenPropiedades;

public class Carpin extends Pez {
    private int edad = 0;
    
    private PecesDatos datos = AlmacenPropiedades.CARPIN_TRES_ESPINAS;
    public Carpin(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        
    }
    public boolean verificarFertilidad(){  
        if (this.edad >= datos.getMadurez()){
            return true;
        }else{
            return false;
        }
    }

    
    public boolean verificarMadurez(){
        if (this.edad >= datos.getMadurez()){
            return true;
        }else{
            return false;
        }
    }  
}
