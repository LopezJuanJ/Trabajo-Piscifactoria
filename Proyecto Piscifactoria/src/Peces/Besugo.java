package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Besugo extends Carnivoro {
  private PecesDatos datos = AlmacenPropiedades.BESUGO;  

  public Besugo(boolean sexo, PecesDatos datos) {
    super(sexo, datos);
    //TODO Auto-generated constructor stub
  }

}
