package Tanque;

import java.util.ArrayList;

import Peces.IRio;
import Peces.Pez;
import Piscifactoria.Piscifactoria;
import propiedades.PecesDatos;

public class Tanque<T extends Pez> {
    public ArrayList<T> peces;

    public int capacidadMax;
    public String nombre;
    public  String tipo;
    
    /**
     * Constructor de la clase Tanque.
     * @param nombre El nombre del tanque.
     * @param capacidadMax La capacidad máxima de peces que puede albergar el tanque.
     */

    public Tanque(String nombre, int capacidadMax) {

        this.peces = new ArrayList<>();
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;

    }

    /**
     * Muestra todos los datos del Tanque.
     */

    public void showStatus() {
        System.out.println("=============== Tanque" + this.nombre + "===============");
        System.out.println("Ocupacion: " + getPeces() + "/" + capacidadMax + "("+ (getPeces().size() / capacidadMax) * 100 + "%)");
        System.out.println("Peces vivos" + getPecesVivos() + "/" + getPeces().size() + "("+ (getPecesVivos() / getPeces().size()) * 100 + "%)");
        System.out.println("Peces alimentados: " + getPecesAlimentados() + "/" + getPecesVivos() + "("+ (getPecesAlimentados() / getPecesVivos()) * 100 + "%)");
        System.out.println("Peces adultos: " + getPecesMaduros() + "/" + getPecesVivos() + "("+ (getPecesMaduros() / getPecesVivos() * 100) + "%)");
        System.out.println("Hembras/Machos: " + getMachos() + "/" + getHembras());
        System.out.println("Fertiles: " + getPecesFertiles() + "/" + getPecesVivos() + "("+ (getPecesFertiles() / getPecesVivos() * 100) + "%)");
    }

    /**
     * Muestra la información de todos los peces del Tanque.
     */

    public void showFishStatus() {
        for (T pez : peces) {
            pez.showStatus();
        }

    }
    
    /**
     * Simula el avance de un día en el tanque, actualizando el estado de los peces.
     * @param tanque El tanque actual.
     * @param piscifactoria La piscifactoria a la que pertenece el tanque.
     */
    public void nextDay(Tanque<? extends Pez> tanque, Piscifactoria piscifactoria) {
        for (T pez : peces) {
            pez.grow(tanque, piscifactoria);
        }
    }

    /**
     * Elimina todos los peces.
     */
    public void limpiarPeces() {
        peces.clear();
    }
 

    public void reproduccion(boolean fertilidad) {
        boolean machoFertil = false;
        boolean hembraFertil = false;

        for (T pez : peces) {
            if (pez.isSexo() && pez.fertilidad) {
                machoFertil = true;
            } else if (!pez.isSexo() && pez.fertilidad) {
                hembraFertil = true;
                int cantHuevos= pez.getDatos().getHuevos();
                if(cantHuevos%2==0){
                    int machos = cantHuevos/2;
                    for (int i=0; i <= machos; i++){
                       // Pez pezChico = new Pez(true, pez.getDatos());
                    }   
                }
            }

            if (machoFertil && hembraFertil) {
                System.out.println("Los peces se pueden reproducir");
                break;
            }
        }

        if (!machoFertil || !hembraFertil) {
            System.out.println("Los peces no se pueden reproducir");
        }
    }
     /**
     * Muestra información sobre la capacidad actual del tanque y el porcentaje de ocupación.
     * @param nombrePisc El nombre de la piscifactoria a la que pertenece el tanque.
     */
    public void showCapacity(String nombrePisc){
        System.out.println("Tanque " + this.nombre + " de la piscifactoria " + nombrePisc + " al " + (this.getPeces().size()/this.capacidadMax)*100 + "% de capacidad" + this.getPeces().size() + "/" + this.capacidadMax );
    }

    /**
     * Obtiene el tipo de pez alojado en el tanque.
     * @return El tipo de pez alojado en el tanque.
     */
      public String getTipoPezTank(){
        return  peces.get(0).getDatos().getNombre();
    }
    /**
     * Obtiene la lista de peces en el tanque.
     * @return La lista de peces en el tanque.
     */
    public ArrayList<T> getPeces() {
        return peces;
    }
    /**
     * Establece la lista de peces en el tanque.
     * @param peces La nueva lista de peces en el tanque.
     */
    public void setPeces(ArrayList<T> peces) {
        this.peces = peces;
    }
    /**
    * Obtiene la cantidad de peces vivos en el tanque.
    * @return La cantidad de peces vivos en el tanque.
     */
    public int getCantPecesVivos() {
        int contador = 0;
        for (T pez : peces) {
            if(pez.isVida()){
                contador++;
            }
        }
        return contador;
    }
    /**
     * Obtiene la cantidad de peces machos vivos en el tanque.
     * @return La cantidad de peces machos vivos en el tanque.
     */
    public int getMachos() {
        int getMachos = 0;
        for (T pez : peces) {
            if (pez.isSexo() && pez.isVida()) {
                getMachos++;
            }
        }
        return getMachos;
    }
    /**
     * Obtiene la cantidad de peces hembras vivas en el tanque.
     * @return La cantidad de peces hembras vivas en el tanque.
     */
    public int getHembras() {
        int getHembras = 0;
        for (T pez : peces) {
            if (!pez.isSexo() && pez.isVida()) {
                getHembras++;
            }
        }
        return getHembras;
    }
 
    /**
     * Obtiene la cantidad de peces vivos en el tanque.
     * @return La cantidad de peces vivos en el tanque.
     */
    public int getPecesFertiles() {
        int pecesFertiles = 0;
        for (T pez : peces) {
            if (pez.isFertilidad() == true) {
                pecesFertiles++;
            }
        }
        return pecesFertiles;
    }
    /**
     * Obtiene la cantidad de peces muertos en el tanque.
     * @return La cantidad de peces muertos en el tanque.
     */
    public int getPecesMuertos() {
        int pecesMuertos = 0;
        for (T pez : peces) {
            if (!pez.isVida()) {
                pecesMuertos++;
            }
        }
        return pecesMuertos;
    }
    /**
     * Obtiene la cantidad de peces vivos en el tanque.
     * @return La cantidad de peces vivos en el tanque.
     */
    public int getPecesVivos() {
        int pecesVivos = 0;
        for (T pez : peces) {
            if (pez.isVida()) {
                pecesVivos++;
            }
        }
        return pecesVivos;
    }
    /**
     * Obtiene la cantidad de peces alimentados en el tanque.
     * @return peces alimentados en el tanque.
     */
    public int getPecesAlimentados() {
        int getPecesAlimentados = 0;
        for (T pez : peces) {
            if (pez.isAlimentado()) {
                getPecesAlimentados++;
            }
        }
        return getPecesAlimentados;
    }
    /**
     * Obtiene la cantidad de peces maduros en el tanque.
     * @return peces maduros en el tanque.
     */
    public int getPecesMaduros() {
        int getPecesMaduros = 0;
        for (T pez : peces) {
            if (pez.verificarMadurez()) {
                getPecesMaduros++;
            }
        }
        return getPecesMaduros;
    }
    /**
     * Obtiene el nombre del tanque.
     * @return nombre del tanque.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del tanque.
     * @param nombre nombre del tanque.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
