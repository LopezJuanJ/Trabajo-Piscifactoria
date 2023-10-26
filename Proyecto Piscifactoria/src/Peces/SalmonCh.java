package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class SalmonCh extends Carnivoro implements IRio {
   private PecesDatos datos = AlmacenPropiedades.SALMON_CHINOOK; 

   public SalmonCh(boolean sexo, PecesDatos datos) {
      super(sexo, datos);
      //TODO Auto-generated constructor stub
   }

   


}
