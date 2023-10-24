package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class SalmonCh extends Carnivoro {
   private PecesDatos datos = AlmacenPropiedades.SALMON_CHINOOK; 

   public SalmonCh(boolean sexo, PecesDatos datos) {
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
