package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Caballa extends Carnivoro {
    private PecesDatos datos = AlmacenPropiedades.CABALLA;

    public Caballa(boolean sexo) {
        super(sexo, AlmacenPropiedades.CABALLA);
        
    }

    
    
}
