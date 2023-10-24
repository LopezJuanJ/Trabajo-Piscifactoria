package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class LubinaEu extends Carnivoro {
    private PecesDatos datos = AlmacenPropiedades.LUBINA_EUROPEA;   

 public LubinaEu(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        //TODO Auto-generated constructor stub
    }
    
    
}
