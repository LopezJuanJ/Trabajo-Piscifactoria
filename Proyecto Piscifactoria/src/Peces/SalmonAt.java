package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class SalmonAt extends Carnivoro implements IMar, IRio{

    public SalmonAt(boolean sexo) {
        super(sexo, AlmacenPropiedades.SALMON_ATLANTICO);
        //TODO Auto-generated constructor stub
    }


}
