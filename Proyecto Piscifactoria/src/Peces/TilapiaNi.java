package Peces;

import Peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;

public class TilapiaNi extends Filtrador implements IRio {

    public TilapiaNi(boolean sexo) {
        super(sexo, AlmacenPropiedades.TILAPIA_NILO);
    }

    

    
}
