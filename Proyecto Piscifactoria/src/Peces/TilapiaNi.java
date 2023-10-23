package Peces;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class TilapiaNi extends Pez {
    private PecesDatos datos = AlmacenPropiedades.TILAPIA_NILO;

    public TilapiaNi(boolean sexo, PecesDatos datos) {
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