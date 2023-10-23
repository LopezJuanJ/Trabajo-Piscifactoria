package Peces;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Besugo extends Pez {
  private PecesDatos datos = AlmacenPropiedades.BESUGO;  

  public Besugo(boolean sexo, PecesDatos datos) {
    super(sexo, datos);
    //TODO Auto-generated constructor stub
  }
  public boolean verificarFertilidad(){  
    if (this.edad >= datos.getMadurez()){
        return true;
    }else{
        return false;
    }
}


public boolean verificarMadurez(){
    if (this.edad >= datos.getMadurez()){
        return true;
    }else{
        return false;
    }
}
}
