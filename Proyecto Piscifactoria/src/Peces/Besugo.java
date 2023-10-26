package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class Besugo extends Carnivoro implements IMar {

  public Besugo(boolean sexo) {
    super(sexo, AlmacenPropiedades.BESUGO);
  }

}
