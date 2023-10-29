package Simulador;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Scanner;

import Almacen.AlmacenCentral;
import Monedero.Monedero;
import Peces.Besugo;
import Peces.Caballa;
import Peces.Corvina;
import Peces.LenguadoEu;
import Peces.LubinaEu;
import Peces.LubinaRa;
import Peces.LucioNor;
import Peces.Pejerrey;
import Peces.Pez;
import Peces.Robalo;
import Peces.SalmonAt;
import Peces.SalmonCh;
import Peces.TilapiaNi;
import Piscifactoria.PiscRio;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.PecesDatos;
import propiedades.PecesProps;

public class Simulador {
  // public Estadisticas estadisticas = new Estadisticas( );

  public int dias;
  public int numeroPiscifactorias;
  public String nombreEmpresa;
  public String nombrePiscifactoria;
  private ArrayList<Piscifactoria> piscifactorias = new ArrayList<Piscifactoria>();
  public ArrayList<Tanque<? extends Pez>> tanques;
  public ArrayList<Pez> peces = new ArrayList<Pez>();
  public Scanner newScan = new Scanner(System.in);
  public PecesDatos[] nombrePeces;

  public Simulador(int dias) {
    this.dias = dias;
    
  }

  public static void main(String[] args) {
    Simulador simulador = new Simulador(0);

    simulador.init();
    simulador.menu();

  }

  /**
   * Inicializa el simulador y permite al usuario ingresar el nombre de la empresa
   * y la primera piscifactoría.
   */
  public void init() {
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
   * Opciones del usuario.
   */
  public void menu() {
      int seleccion;
      do {
          Scanner scanner = new Scanner(System.in);
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
          System.out.print("Selecciona una opcion: ");
          seleccion = newScan.nextInt();
          switch (seleccion) {
              case 1:
                  this.showGeneralStatus();
                  break;
              case 2:
                  this.showSpecificStatus();
                  break;
              case 3:
                  this.showTankStatus();
                  break;
              case 4:

                  break;
              case 5:
                  this.showIctio();
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
              case 14:

                  break;
              case 98:

                  break;
              case 99:

                  break;
          }
      } while (seleccion != 14);
  }

  /**
   * Muestra un menú para seleccionar una piscifactoría.
   */
  public void menuPisc() {
    System.out.println("Seleccione una opcion: ");
    System.out.println("--------------------------- Piscifactorías ---------------------------");
    System.out.println("[Peces vivos / Peces totales / Espacio total]");
    getDatosPisc();
    System.out.println("0-Cancelar");

  }

  /**
   * Obtiene los datos de las piscifactorías y los muestra en el menú.
   */
  public void getDatosPisc() {
    int indice = 1;
    for (Piscifactoria piscifactoria : piscifactorias) {
      System.out.println(indice + ".- " + piscifactoria.getNombre() + "[" + piscifactoria.getVivosTotales() + "/"
          + piscifactoria.getPecesTotales() + "/" + piscifactoria.getEspacioTotal() + "]");
      System.out.println("Comida de la piscifactoria: " + piscifactoria.getComidaActual());
      indice++;

    }

  }

  /**
   * Permite al usuario seleccionar una piscifactoría.
   *
   * @return El índice de la piscifactoría seleccionada.
   */

  public int selectPisc() {
    Scanner scanner = new Scanner(System.in);
    menuPisc();
    System.out.print("Seleccione una piscifactoría (0-" + (piscifactorias.size()) + "): ");
    int selPisc = scanner.nextInt();
    if (selPisc > 0) {
      return selPisc;
    } else {
      return 0;
    }
  }

  /**
   * Permite al usuario seleccionar un tanque de una piscifactoría.
   *
   * @return El índice del tanque seleccionado.
   */
  public int selectTank() {
    int valor = selectPisc() - 1;
    Scanner scanner = new Scanner(System.in);
    int indice = 0;

    for (Piscifactoria piscifactoria : piscifactorias) {
      if (indice == valor) {
        System.out.println();
        piscifactoria.showTankStatus();
      }
      indice++;
    }
    System.out.print("Selecciona el indice de un tanque: ");
    int seleccion = scanner.nextInt();
    return seleccion;
  }

  /**
   * Muestra el estado general de las piscifactorías, incluyendo sus nombres,
   * estadísticas y monedas.
   */
  public void showGeneralStatus() {
      getDatosPisc();
    System.out.println("Dias: " + this.dias);
    System.out.println("Monedas: " + Monedero.getInstance().getMonedas());

    AlmacenCentral almacenCentral = AlmacenCentral.getInstance();
    if (almacenCentral == null) {
      System.out.println("No dispone de Almacen Central");
    } else {
      System.out.println("Almacen con " + almacenCentral.getComida() + "/" + almacenCentral.getComidaMax()
          + " de comida, esta al " + (almacenCentral.getComida() / almacenCentral.getComidaMax()) * 100 + "%");
    }
  }

  /**
   * Muestra el estado específico de una piscifactoría seleccionada.
   */
  public void showSpecificStatus() {
    int indice = 0;
    int valor = selectPisc() - 1;
    if(valor<1 || valor>piscifactorias.size()){
      piscifactorias.get(valor).showTankStatus();
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

  public void showStats() {

  }

  public void showIctio() {
    int sel;
    System.out.println("1.Tilapia del Nilo");
    System.out.println("2.Lucio del norte");
    System.out.println("3.Corvina");
    System.out.println("4.Salmon Chinook ");
    System.out.println("5.Pejerrey");
    System.out.println("6.Lenguado Europeo");
    System.out.println("7.Caballa");
    System.out.println("8.Robalo");
    System.out.println("9.Lubimna Rayada");
    System.out.println("10.Lubina Europea");
    System.out.println("11. Salmon atlantico");
    System.out.println("12.Besugo");
    System.out.print("Selecciona un Pez: ");
    sel = newScan.nextInt();
    newScan.nextLine();
    switch (sel) {
      case 1:
        TilapiaNi.showIctio();
        break;
      case 2:
        LucioNor.showIctio();
        break;
      case 3:
        Corvina.showIctio();
        break;
      case 4:
        SalmonCh.showIctio();
        break;
      case 5:
        Pejerrey.showIctio();
        break;
      case 6:
        LenguadoEu.showIctio();
        break;
      case 7:
        Caballa.showIctio();
        break;
      case 8:
        Robalo.showIctio();
        break;
      case 9:
        LubinaRa.showIctio();
        break;
      case 10:
        LubinaEu.showIctio();
        break;
      case 11:
        SalmonAt.showIctio();
        break;
      case 12:
        Besugo.showIctio();
        break;
      

      default:
        break;
    }
  }

  public void nextDay() {

  }

  public void addFood(Piscifactoria piscifactoria) {
    System.out.println("-----------------Comprar Comida-----------------");
    System.out.println("1.5 de comida");
    System.out.println("2.10 de comida");
    System.out.println("3.25 de comida");
    System.out.println("4. Llenar");
    int seleccion = newScan.nextInt();
    if (seleccion==1){
        if(piscifactoria.getComidaMaxima()- piscifactoria.getComidaActual()>=5){
          piscifactoria.setComidaActual(piscifactoria.getComidaActual()+5);
          Monedero.getInstance().comprar(5);
        }
    } else if(seleccion == 2){
      if(piscifactoria.getComidaMaxima()- piscifactoria.getComidaActual()>=10){
        piscifactoria.setComidaActual(piscifactoria.getComidaActual()+10);
        Monedero.getInstance().comprar(10);
      }
    } else if (seleccion==3) {
      if(piscifactoria.getComidaMaxima()- piscifactoria.getComidaActual()>=25){
        piscifactoria.setComidaActual(piscifactoria.getComidaActual()+25);
        Monedero.getInstance().comprar(20);
      }
    } else if (seleccion==4) {
      int valorAAumentar = piscifactoria.getComidaMaxima() - piscifactoria.getComidaActual();
      if (valorAAumentar < 25){
        piscifactoria.setComidaActual(piscifactoria.getComidaActual()+valorAAumentar);
        Monedero.getInstance().comprar(valorAAumentar);
      } else {


      }
    }
  }

  public void addFish() {

  }

  /**
   * Vende peces maduros en todas las piscifactorías.
   */
  public void sell() {
    int pezVendido = 0;
    for (Piscifactoria piscifactoria : piscifactorias) {
      for (Tanque tanque : tanques) {
        for (Pez pez : peces) {
          if (pez.verificarMadurez()) {
            piscifactoria.sellFish();
            pezVendido++;
            System.out.println("Piscifactoria" + piscifactoria.getNombre() + ":");
          }
        }

      }
    }
  }

  /**
   * Limpia los tanques de la piscifactoría seleccionada eliminando los peces
   * muertos.
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
   * Vacía los tanques de la piscifactoría seleccionada eliminando todos los
   * peces.
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
