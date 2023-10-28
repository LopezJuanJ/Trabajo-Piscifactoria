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
  public ArrayList<Pez> peces = new ArrayList<Pez>();

  // public String[] nombrePeces= {propiedades.AlmacenPropiedades.CARPIN_TRES_ESPINAS.getNombre(), propiedades.AlmacenPropiedades.KOI.getNombre(), propiedades.AlmacenPropiedades.CARPA.getNombre(), propiedades.AlmacenPropiedades.SALMON_CHINOOK.getNombre(), propiedades.AlmacenPropiedades.PEJERREY.getNombre(), propiedades.AlmacenPropiedades.COBIA.getNombre(), propiedades.AlmacenPropiedades.CABALLA.getNombre(), propiedades.AlmacenPropiedades.BESUGO.getNombre(), propiedades.AlmacenPropiedades.SARGO.getNombre(), propiedades.AlmacenPropiedades.LUBINA_RAYADA.getNombre(), propiedades.AlmacenPropiedades.DORADA.getNombre(), propiedades.AlmacenPropiedades.SALMON_ATLANTICO.getNombre() };
  
  public static void main(String[] args) {
    
    Simulador simulador = new Simulador();
    simulador.init();
  }
    /**
     * Inicializa el simulador y permite al usuario ingresar el nombre de la empresa y la primera piscifactoría.
     */
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

    /**
     *Opciones del usuario.
     */
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


     /**
     * Muestra un menú para seleccionar una piscifactoría.
     */
  public void menuPisc(){
    System.out.println("Seleccione una opcion: ");
    System.out.println("--------------------------- Piscifactorías ---------------------------");
    System.out.println("[Peces vivos / Peces totales / Espacio total]");
    getDatosPisc();
    System.out.println("0-Cancelar");

  }

    /**
     * Obtiene los datos de las piscifactorías y los muestra en el menú.
     */
  public void getDatosPisc(){
    int indice = 1;
    for (Piscifactoria piscifactoria : piscifactorias){
      System.out.println(indice + ".- " + piscifactoria.getNombre() + "[" + piscifactoria.getVivosTotales() + "/"+ piscifactoria.getPecesTotales()+"/"+ piscifactoria.getEspacioTotal());
      indice++;

    }

  }

    /**
     * Permite al usuario seleccionar una piscifactoría.
     *
     * @return El índice de la piscifactoría seleccionada.
     */

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
    /**
     * Permite al usuario seleccionar un tanque de una piscifactoría.
     *
     * @return El índice del tanque seleccionado.
     */
  public  int  selectTank(){
    int valor =selectPisc()-1;
    Scanner scanner = new Scanner(System.in);
    int indice = 0;

    for(Piscifactoria piscifactoria: piscifactorias){
      if(indice == valor){
        piscifactoria.showTankStatus();
      }      
      indice++;
    }
    System.out.print("Selecciona el indice de un tanque: ");
    int seleccion = scanner.nextInt();
    return seleccion;
  }

    /**
     * Muestra el estado general de las piscifactorías, incluyendo sus nombres, estadísticas y monedas.
     */
  public void showGeneralStatus(){
      for (Piscifactoria piscifactoria: piscifactorias){
        piscifactoria.showStatus();
        piscifactoria.getComidaActual();
      }
      System.out.println(this.dias);
      Monedero monedero = Monedero.getInstance();
      System.out.println("Monedas: " + monedero.getMonedas());
  }
    /**
     * Muestra el estado específico de una piscifactoría seleccionada.
     */
  public void showSpecificStatus(){
    int indice = 0;
    int valor =selectPisc()-1;
    for (Piscifactoria piscifactoria: piscifactorias){
      if (indice == valor){
        piscifactoria.showTankStatus();
      }
      indice++;
    }
  }

    /**
     * Muestra el estado de los tanques de una piscifactoría seleccionada.
     */
    public void showTankStatus() {
      int tanqueMostrar = selectTank() - 1;
      int indice = 0;
      for (Piscifactoria piscifactoria : piscifactorias) {
        if (indice == tanqueMostrar) {
          piscifactoria.showFishStatus(tanqueMostrar);
        }
      }
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
 /**
   * Vende peces maduros en todas las piscifactorías.
   */
  public void sell() {
    int pezVendido =0;
    for (Piscifactoria piscifactoria : piscifactorias) {
      for (Tanque tanque : tanques) {
        for (Pez pez : peces) {
          if (pez.verificarMadurez()) {
            piscifactoria.sellFish();
            pezVendido ++;
            System.out.println("Piscifactoria" + piscifactoria.getNombre()+":");
          }
        }

      }
    }
  }
  
  /**
   * Limpia los tanques de la piscifactoría seleccionada eliminando los peces muertos.
   */
  public void cleanTank() {
    int indice = 0;
    int valor = selectPisc() - 1;

    for (Piscifactoria piscifactoria : piscifactorias) {
      if (indice == valor) {
        for (Tanque tanque : tanques) {
          for (Pez pez : peces)
            if (pez.isVida() == false) {
              tanque.limpiarPeces();
            }
        }
      }
       indice++;
    }
  }

  /**
   * Vacía los tanques de la piscifactoría seleccionada eliminando todos los peces.
   */
    
  public void emptyTank() {
    int indice = 0;
    int valor = selectPisc() - 1;

    for (Piscifactoria piscifactoria : piscifactorias) {
      if (indice == valor) {
        for (Tanque tanque : tanques) {
          for (Pez pez : peces)
            tanque.limpiarPeces();
        }
      }
      indice++;
    }
  }

  public void upgrade() {

  }

  /**
   * Obtiene el nombre de la piscifactoría.
   *
   * @return El nombre de la piscifactoría.
   */
  public String getNombrePiscifactoria() {
    return nombrePiscifactoria;
  }

  /**
   * Establece el nombre de la piscifactoría.
   *
   * @param nombrePiscifactoria El nuevo nombre de la piscifactoría.
   */
  public void setNombrePiscifactoria(String nombrePiscifactoria) {
    this.nombrePiscifactoria = nombrePiscifactoria;
  }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
}
