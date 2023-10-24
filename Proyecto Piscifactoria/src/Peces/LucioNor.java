package Peces;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class LucioNor extends Pez{
   private PecesDatos datos = AlmacenPropiedades.LUCIO_NORTE; 

   public LucioNor(boolean sexo, PecesDatos datos) {
      super(sexo, datos);
      //TODO Auto-generated constructor stub
   }

   

@Override
public void comer() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'comer'");
}
}
