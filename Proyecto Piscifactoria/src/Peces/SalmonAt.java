package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class SalmonAt extends Carnivoro implements IMar, IRio{
    private PecesDatos datos = AlmacenPropiedades.SALMON_ATLANTICO;

    public SalmonAt(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }


}
