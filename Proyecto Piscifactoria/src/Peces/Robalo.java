package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Robalo extends Carnivoro implements IMar{
    private PecesDatos datos = AlmacenPropiedades.ROBALO;

    public Robalo(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }

    

}
