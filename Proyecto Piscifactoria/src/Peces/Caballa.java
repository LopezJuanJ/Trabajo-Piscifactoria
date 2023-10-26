package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class Caballa extends Carnivoro implements IMar {

    public Caballa(boolean sexo) {
        super(sexo, AlmacenPropiedades.CABALLA);
        
    }

    
    
}
