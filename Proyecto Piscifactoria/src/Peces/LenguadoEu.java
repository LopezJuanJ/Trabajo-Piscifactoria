package Peces;


import propiedades.PecesDatos;
import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class LenguadoEu extends  Carnivoro{
    private int edad = 0;
    
    private PecesDatos datos = AlmacenPropiedades.LENGUADO_EUROPEO;
    public LenguadoEu(boolean sexo, PecesDatos datos) {
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
