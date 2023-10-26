package Peces;


import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class LenguadoEu extends  Carnivoro implements IMar{    
   
    public LenguadoEu(boolean sexo) {
        super(sexo, AlmacenPropiedades.LENGUADO_EUROPEO);
        
    }
     
}
