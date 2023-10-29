package Tanque;

import java.util.ArrayList;

import Peces.IRio;
import Peces.Pez;
import Piscifactoria.Piscifactoria;

public class Tanque<T extends Pez> {
    public ArrayList<T> peces;

    public int capacidadMax;
    public String nombre;
    public  String tipo;

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

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
    public double porcentaje(int numero1, int numero2){
        if (numero2 == 0) {
            return 0.0;
        }
        double porcentaje = (double) numero1 / numero2 * 100;
        porcentaje = Math.round(porcentaje * 10) / 10.0;
        return porcentaje;
    }

    /**
     * Muestra todos los datos del Tanque.
     */
    public void showStatus() {
        System.out.println("=============== Tanque " + this.nombre + "===============");

                System.out.println("Ocupacion: " + this.getPeces().size() + "/" + capacidadMax + "("+ (this.getPeces().size() / capacidadMax) * 100 + "%)");
                System.out.println("Peces vivos: " + this.getPecesVivos() + "/" + this.getPeces().size() + "("+ porcentaje(this.getCantPecesVivos(),this.getPeces().size()) + "%)");
                System.out.println("Peces alimentados: " + this.getPecesAlimentados() + "/" + this.getPecesVivos() + "("+ porcentaje(this.getPecesAlimentados(), this.getPecesVivos()) + "%)");
                System.out.println("Peces adultos: " + this.getPecesMaduros() + "/" + this.getPecesVivos() + "("+ porcentaje(this.getPecesMaduros(), this.getPecesVivos()) + "%)");
                System.out.println("Hembras/Machos: " + this.getMachos() + "/" + this.getHembras());
                System.out.println("Fertiles: " + this.getPecesFertiles() + "/" + this.getPecesVivos() + "("+ porcentaje(this.getPecesFertiles(),this.getPecesVivos()) + "%)");
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
    public boolean compararTipo(Pez p) {
        if (this.peces.size()==this.getCapacidadMax()) {
            return false;
        }
        if (peces.isEmpty()) {
            return true;
        }
        return peces.get(0).getClass() == p.getClass();
    }
    public void addFish(Pez pez){
        this.peces.add((T) pez);
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
            if(peces.isEmpty()){
                return "NO hay peces en el tanque";
            }
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
