package Peces;

import Peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;
import propiedades.PecesProps;

public class TilapiaNi extends Filtrador implements IRio {

    public TilapiaNi() {
        super(AlmacenPropiedades.TILAPIA_NILO);
    }

    public static void showIctio(){
    PecesDatos pez= AlmacenPropiedades.TILAPIA_NILO; 
      System.out.println("Nombre: " + pez.getNombre());
      System.out.println("Nombre Cientifico: " + pez.getCientifico());
      System.out.println("Madurez: " + pez.getMadurez());
      System.out.println("Tipo: " + pez.getTipo());
      System.out.println("Coste Compra: " + pez.getCoste());
      System.out.println("Huevos: " + pez.getHuevos());
      System.out.println("Ciclo: " + pez.getCiclo());
      System.out.println("Monedas Venta: " + pez.getMonedas());
      System.out.println("Optimo: " + pez.getOptimo());
      System.out.println("Tipo Piscifactoria: " + pez.getPiscifactoria());
      for (PecesProps propi : pez.getPropiedades()) {
        System.out.print("Propiedad: " + propi.getValue());
      }
    }

    
}
