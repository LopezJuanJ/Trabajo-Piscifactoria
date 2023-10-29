package Peces;

import Peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;
import propiedades.PecesProps;

public class Caballa extends Carnivoro implements IMar {

    public Caballa(boolean sexo) {
        super(sexo, AlmacenPropiedades.CABALLA);
        
    }

   public static void showIctio(){
    PecesDatos pez= AlmacenPropiedades.CABALLA; 
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
