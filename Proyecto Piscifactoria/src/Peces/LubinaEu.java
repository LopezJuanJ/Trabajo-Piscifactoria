package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class LubinaEu extends Carnivoro implements IMar,IRio {
    private PecesDatos datos = AlmacenPropiedades.LUBINA_EUROPEA;   

 public LubinaEu(boolean sexo) {
    super(sexo, AlmacenPropiedades.LUBINA_EUROPEA);

        //TODO Auto-generated constructor stub
    }
    
    
}
