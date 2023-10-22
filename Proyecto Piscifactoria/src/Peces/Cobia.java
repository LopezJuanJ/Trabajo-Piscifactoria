package Peces;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Cobia extends Pez {
  private PecesDatos datos = AlmacenPropiedades.COBIA;  

  public Cobia(boolean sexo, PecesDatos datos) {
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
