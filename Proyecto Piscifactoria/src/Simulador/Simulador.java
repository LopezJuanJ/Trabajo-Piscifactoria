package Simulador;
import Peces.Besugo;
import Peces.Pez;
import Tanque.Tanque;
import estadisticas.Estadisticas;

public class Simulador {
  public int dias;
  public int numeroPiscifactorias;
  public String nombreEpresa;
  public String[] nombrePeces= {propiedades.AlmacenPropiedades.CARPIN_TRES_ESPINAS.getNombre(), propiedades.AlmacenPropiedades.KOI.getNombre(), propiedades.AlmacenPropiedades.CARPA.getNombre(), propiedades.AlmacenPropiedades.SALMON_CHINOOK.getNombre(), propiedades.AlmacenPropiedades.PEJERREY.getNombre(), propiedades.AlmacenPropiedades.COBIA.getNombre(), propiedades.AlmacenPropiedades.CABALLA.getNombre(), propiedades.AlmacenPropiedades.BESUGO.getNombre(), propiedades.AlmacenPropiedades.SARGO.getNombre(), propiedades.AlmacenPropiedades.LUBINA_RAYADA.getNombre(), propiedades.AlmacenPropiedades.DORADA.getNombre(), propiedades.AlmacenPropiedades.SALMON_ATLANTICO.getNombre() };
  
  public static void main(String[] args) {
    
    // Besugo besugo = new Besugo(true);
    // besugo.showStatus();
    Tanque tnq = new Tanque<Pez>("Tanqueta", 25);
    int i = tnq.getPeces().size();
    System.out.println(i);
  }

  //public Estadisticas estadisticas = new Estadisticas( );
    public void init(){

    }

  public void menu(){
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

  }

  public void selectPisc(){

  }

  public void selectTank(){

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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
}
