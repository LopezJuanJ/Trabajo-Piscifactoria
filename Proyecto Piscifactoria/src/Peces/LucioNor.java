package Peces;

import Peces.Propiedades.CarnivoroActivo;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class LucioNor extends CarnivoroActivo{
   private PecesDatos datos = AlmacenPropiedades.LUCIO_NORTE; 

   public LucioNor(boolean sexo) {
      super(sexo, AlmacenPropiedades.LUCIO_NORTE);

      //TODO Auto-generated constructor stub
   }

}
