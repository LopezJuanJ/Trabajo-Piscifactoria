package Peces;

import Peces.Propiedades.CarnivoroActivo;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;
import propiedades.PecesProps;

public class LucioNor extends CarnivoroActivo implements IRio{

   public LucioNor() {
      super(AlmacenPropiedades.LUCIO_NORTE);

      //TODO Auto-generated constructor stub
   }
public static void showIctio(){
    PecesDatos pez= AlmacenPropiedades.LUCIO_NORTE; 
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
