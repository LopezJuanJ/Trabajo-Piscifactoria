package Peces;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Corvina extends Pez {
    private PecesDatos datos = AlmacenPropiedades.CORVINA;

    public Corvina(boolean sexo, PecesDatos datos) {
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
    @Override
    public void comer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }
}
