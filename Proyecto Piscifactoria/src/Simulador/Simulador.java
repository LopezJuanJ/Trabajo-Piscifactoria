package Simulador;
import java.util.ArrayList;
import java.util.Scanner;

import Monedero.Monedero;
import Peces.Pez;
import Piscifactoria.PiscRio;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;

public class Simulador {
  //public Estadisticas estadisticas = new Estadisticas( );

  public int dias;
  public int numeroPiscifactorias;
  public String nombreEmpresa;
  public String nombrePiscifactoria;
  private ArrayList<Piscifactoria> piscifactorias = new ArrayList<Piscifactoria>();
  public ArrayList<Tanque<? extends Pez>> tanques;

  // public String[] nombrePeces= {propiedades.AlmacenPropiedades.CARPIN_TRES_ESPINAS.getNombre(), propiedades.AlmacenPropiedades.KOI.getNombre(), propiedades.AlmacenPropiedades.CARPA.getNombre(), propiedades.AlmacenPropiedades.SALMON_CHINOOK.getNombre(), propiedades.AlmacenPropiedades.PEJERREY.getNombre(), propiedades.AlmacenPropiedades.COBIA.getNombre(), propiedades.AlmacenPropiedades.CABALLA.getNombre(), propiedades.AlmacenPropiedades.BESUGO.getNombre(), propiedades.AlmacenPropiedades.SARGO.getNombre(), propiedades.AlmacenPropiedades.LUBINA_RAYADA.getNombre(), propiedades.AlmacenPropiedades.DORADA.getNombre(), propiedades.AlmacenPropiedades.SALMON_ATLANTICO.getNombre() };
  
  public static void main(String[] args) {
    
    Simulador simulador = new Simulador();
    simulador.init();
  }
  
    public void init(){
      Scanner scanner = new Scanner(System.in);

      Monedero monedero = Monedero.getInstance();
      System.out.print("Escribe el nombre de la entidad/empresa/partida: ");
      this.nombreEmpresa = scanner.nextLine();

      System.out.print("Por favor, ingrese el nombre de la piscifactoría:");
      String nombrePiscifactoria = scanner.nextLine();

      PiscRio inicial = new PiscRio(nombrePiscifactoria);
      piscifactorias.add(inicial);
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
    System.out.println("Seleccione una opcion: ");
    System.out.println("--------------------------- Piscifactorías ---------------------------");
    System.out.println("[Peces vivos / Peces totales / Espacio total]");
    System.out.println("0-Cancelar");
    getDatosPisc();

  }

  public void getDatosPisc(){
    int indice = 1;
    for (Piscifactoria piscifactoria : piscifactorias){
      System.out.println(indice + ".- " + piscifactoria.getNombre() + "[" + piscifactoria.getVivosTotales() + "/"+ piscifactoria.getPecesTotales()+"/"+ piscifactoria.getEspacioTotal());
      indice++;

    }

  }

  

  public int selectPisc(){
    Scanner scanner = new Scanner(System.in);

    menuPisc();
  
    System.out.print("Seleccione una piscifactoría (0-" + (piscifactorias.size()) + "): ");
    int selPisc = scanner.nextInt();
    if(selPisc>0){
      return selPisc;
    }else {
     return 0;
    }



  }

  public  int  selectTank(){
    Scanner scanner = new Scanner(System.in);
    int indice =1;
    for(Piscifactoria piscifactoria: piscifactorias){
      System.out.println(indice);
      piscifactoria.showTankStatus();

      indice++;
    }
    System.out.print("Selecciona el indice de un tanque: ");
    int seleccion = scanner.nextInt();
    return seleccion;
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
