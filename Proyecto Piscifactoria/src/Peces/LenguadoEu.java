package Peces;


import propiedades.PecesDatos;
import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class LenguadoEu extends  Carnivoro{
    private int edad = 0;
    
    private PecesDatos datos = AlmacenPropiedades.LENGUADO_EUROPEO;
   
    public LenguadoEu(boolean sexo) {
        super(sexo, AlmacenPropiedades.LENGUADO_EUROPEO);
        
    }
     
}
