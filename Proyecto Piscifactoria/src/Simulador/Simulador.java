package Simulador;

import java.util.ArrayList;
import java.util.Scanner;

import Almacen.AlmacenCentral;
import Monedero.Monedero;
import Peces.Pez;
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

  public PecesDatos[] nombrePeces;

  public Simulador(int dias) {
    this.dias = dias;
    // this.nombrePeces = new PecesDatos[]{
    // propiedades.AlmacenPropiedades.TILAPIA_NILO,
    // propiedades.AlmacenPropiedades.LUCIO_NORTE,
    // propiedades.AlmacenPropiedades.CORVINA,
    // propiedades.AlmacenPropiedades.SALMON_CHINOOK,
    // propiedades.AlmacenPropiedades.PEJERREY,
    // propiedades.AlmacenPropiedades.LENGUADO_EUROPEO,
    // propiedades.AlmacenPropiedades.CABALLA,
    // propiedades.AlmacenPropiedades.BESUGO,
    // propiedades.AlmacenPropiedades.ROBALO,
    // propiedades.AlmacenPropiedades.LUBINA_RAYADA,
    // propiedades.AlmacenPropiedades.LUBINA_EUROPEA,
    // propiedades.AlmacenPropiedades.SALMON_ATLANTICO
    // };
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
    int seleccion = scanner.nextInt();
    switch (seleccion) {
      case 1:
        this.showGeneralStatus();
        break;
      case 2:
        this.selectPisc();
        break;
      case 3:
        this.showTankStatus();
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
      case 14:

        break;
      case 98:

        break;
      case 99:

        break;
    }
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
          + piscifactoria.getPecesTotales() + "/" + piscifactoria.getEspacioTotal());
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
    for (Piscifactoria piscifactoria : piscifactorias) {
      piscifactoria.showStatus();
      piscifactoria.getComidaActual();
    }
    System.out.println("Dias: " + this.dias);
    Monedero monedero = Monedero.getInstance();
    System.out.println("Monedas: " + monedero.getMonedas());

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
    for (Piscifactoria piscifactoria : piscifactorias) {
      if (indice == valor) {
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

  public void showStats() {

  }

  public int showIctio() {
    Scanner scanner = new Scanner(System.in);
    int sel;
    int indice = 1;
    for (PecesDatos pez : nombrePeces) {
      System.out.println(indice);
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
      indice++;
    }
    System.out.print("Selecciona una opcion: ");
    sel = scanner.nextInt();
    return sel;
  }

  public void nextDay() {

  }

  public void addFood() {

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
