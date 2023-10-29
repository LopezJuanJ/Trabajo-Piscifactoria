package Peces;

import Peces.Propiedades.CarnivoroVoraz;

import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;
import propiedades.PecesProps;

public class Corvina extends CarnivoroVoraz  implements IRio{

    public Corvina(boolean sexo) {
        super(sexo, AlmacenPropiedades.CORVINA);

    }

    public static void showIctio(){
    PecesDatos pez= AlmacenPropiedades.CORVINA; 
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
