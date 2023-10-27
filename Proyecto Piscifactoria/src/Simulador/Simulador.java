package Simulador;
import java.util.ArrayList;
import java.util.Scanner;

import Peces.Besugo;
import Peces.Pez;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import estadisticas.Estadisticas;

public class Simulador {
  //public Estadisticas estadisticas = new Estadisticas( );

  public int dias;
  public int numeroPiscifactorias;
  public String nombreEpresa;
  public String nombrePiscifactoria;
  private ArrayList<Piscifactoria> piscifactorias = new ArrayList<Piscifactoria>();
  public ArrayList<Tanque<? extends Pez>> tanques;

  // public String[] nombrePeces= {propiedades.AlmacenPropiedades.CARPIN_TRES_ESPINAS.getNombre(), propiedades.AlmacenPropiedades.KOI.getNombre(), propiedades.AlmacenPropiedades.CARPA.getNombre(), propiedades.AlmacenPropiedades.SALMON_CHINOOK.getNombre(), propiedades.AlmacenPropiedades.PEJERREY.getNombre(), propiedades.AlmacenPropiedades.COBIA.getNombre(), propiedades.AlmacenPropiedades.CABALLA.getNombre(), propiedades.AlmacenPropiedades.BESUGO.getNombre(), propiedades.AlmacenPropiedades.SARGO.getNombre(), propiedades.AlmacenPropiedades.LUBINA_RAYADA.getNombre(), propiedades.AlmacenPropiedades.DORADA.getNombre(), propiedades.AlmacenPropiedades.SALMON_ATLANTICO.getNombre() };
  
  public static void main(String[] args) {
    
    // Besugo besugo = new Besugo(true);
    // besugo.showStatus();
    Tanque<? extends Pez> tnq = new Tanque<Pez>("Tanqueta", 25);
    int i = tnq.getPeces().size();
    System.out.println(i);
  }
  
    public void init(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Escribe el nombre de la empresa: ");
      this.nombreEpresa = scanner.nextLine();

      System.out.println("Por favor, ingrese el nombre de la piscifactoría:");
      String nombrePiscifactoria = scanner.nextLine();
    }

  public void menu(){
    System.out.println("=========Menu=========");
    System.out.println("1. Estado general");
    System.out.println("2. Estado piscifactoria");
    System.out.println("3. Estado tanques");
    System.out.println("4. Informes");
    System.out.println("5. Ictiopedia");
    System.out.println("6. Pasar dia");
    System.out.println("7. Comprar comida");
    System.out.println("8. Comprar peces");
    System.out.println("9. Vender peces");
    System.out.println("10. Limpiar tanques");
    System.out.println("11. Vaciar tanque");
    System.out.println("12. Mejorar");
    System.out.println("13. Pasar varios dias");
    System.out.println("14. Salir");
  }



  public void menuPisc(){
    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();
       switch (opcion) {
              case 1:

                  break;
              case 2:

                  break;
              case 3:

                  break;
              case 4:

                  break;
              case 5:

                  break;
              case 6:

                  break;
              case 7:

                  break;
              case 8:

                  break;
              case 9:

                  break;
              case 10:

                  break;
              case 11:

                  break;
              case 12:

                  break;
              case 13:

                  break;
          }
     

}

  

  public void selectPisc(){
    Scanner scanner = new Scanner(System.in);
    int indice = 0; 
    System.out.println("Menú de Piscifactorías:");
    for (Piscifactoria piscifactoria : piscifactorias) {
      System.out.println(indice + ". " + piscifactoria.getNombre());
      indice++;
    }
  
    System.out.print("Seleccione una piscifactoría (1-" + (piscifactorias.size()) + "): ");
    int selPisc = scanner.nextInt();
    
    if (selPisc >= 1 && selPisc <= piscifactorias.size()) {
        return;
    }
  }

  public void selectTank(){
     Scanner scanner = new Scanner(System.in);
    int indiceTnq = 0; 
    System.out.println("Menú de Tanques");

    for (Tanque<? extends Pez> tnq : tanques) {
      System.out.println(indiceTnq + ". " + tnq.getNombre()); 
      indiceTnq++;
    }
     System.out.print("Seleccione un Tanque (1-" + (piscifactorias.size()) + "): ");
    int selTank = scanner.nextInt();
  }

  public void showGeneralStatus(){
 
  }

  public void showSpecificStatus(){

  }

  public void showTankStatus(){

  }

  public void showStats(){

  }
  public void showIctio(){
    
  }
  public void nextDay(){
    
  }
  public void addFood(){
    
  }
  public void addFish(){
    
  }
  public void sell(){
    
  }
  public void cleanTank(){
    
  }
  public void emptyTank(){
    
  }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
  public void upgrade(){
    
  }
  
  public String getNombrePiscifactoria() {
    return nombrePiscifactoria;
  }

  public void setNombrePiscifactoria(String nombrePiscifactoria) {
    this.nombrePiscifactoria = nombrePiscifactoria;
  }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
}
