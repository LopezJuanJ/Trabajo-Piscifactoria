package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Pejerrey extends Carnivoro implements IRio {
    private PecesDatos datos = AlmacenPropiedades.PEJERREY;

    public Pejerrey(boolean sexo) {
        super(sexo, AlmacenPropiedades.PEJERREY);

        //TODO Auto-generated constructor stub
    }


    
}
