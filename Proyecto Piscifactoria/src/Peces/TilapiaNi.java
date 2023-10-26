package Peces;

import Peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class TilapiaNi extends Filtrador implements IRio {
    private PecesDatos datos = AlmacenPropiedades.TILAPIA_NILO;

    public TilapiaNi(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
    }

    

    
}
