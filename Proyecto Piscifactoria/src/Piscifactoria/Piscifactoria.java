package Piscifactoria;

import java.util.ArrayList;

import Monedero.Monedero;
import Peces.IRio;
import Peces.Pez;
import Simulador.Simulador;
import Tanque.Tanque;
import propiedades.PecesDatos;

public class Piscifactoria {
    protected int comidaActual;
    protected int comidaMaxima;
   
    protected int capacidadMaxima;
    protected String nombre;
    protected Simulador simulador;
    protected String tipo;
    public ArrayList<Tanque<? extends Pez>> tanques;
    
     /**
     * Constructor de la clase Piscifactoria.
     * @param nombre El nombre de la piscifactoria.
     */
    public Piscifactoria(String nombre) {
        this.nombre = nombre;
        this.tanques = new ArrayList<Tanque<? extends Pez>>() ;
        this.comidaMaxima = obtenerComidaMaximaTanq();
        this.capacidadMaxima = obtenerCapacidadMaximaTanq();
    }
     /**
     * Muestra todos los datos del pez.
     */
    public void showStatus() {
        System.out.println("===============" + this.nombre + "===============");
        System.out.println("Tanques: " + getCantTanques());
        System.out.println("Ocupación: peces / max (x%)");
        System.out.println("Peces vivos: vivos / total (x%)");
        System.out.println("Peces alimentados: alimentados / vivos (x%)");
        System.out.println("Hembras / Machos: H/M");
        System.out.println("Fértiles: fértiles / vivos");
        System.out.println("Almacén de comida: actual / max (x%)");
    }

    /**
     * Muestra un menú de la información de cada tanque.
     */
    public void showTankStatus() {
        for ( Tanque<? extends Pez> tnq: tanques) {

            String nombreTanque = tnq.getNombre();
            tnq.showStatus();
            System.out.println(tnq.getTipoPezTank());
        }

    }

    /**
     * Muestra los peces de un determindo tanque.
     * @param indice El índice del tanque que se desea mostrar.
     */
    public void showFishStatus(int indice) {
        int contador =0;
        for ( Tanque<? extends Pez> tnq: tanques) {
            if (indice == contador){
                 tnq.showFishStatus();
            }
            contador++;
        }
    }

    /**
     * Muestra el estado del depósito de comida en la piscifactoria.
     */
    public void showFood(){
        System.out.println("Deposito de comida de la piscifactoria"+ this.nombre+ "al" + (comidaActual/comidaMaxima)*100 + "% de capacidad" + comidaActual +"/"+ comidaMaxima);     
    }

    /**
     * Muestra la ocupación de un tanque
     */
    public void showCapacity(){
        for (Tanque tanque : tanques){
            tanque.showCapacity(this.nombre);
        }
    }
    /**
     * Simula el avance de un día en la piscifactoria, actualizando el estado de los tanques.
     */
    public void nextDay() {
        for (Tanque<? extends Pez> tanque : tanques) {
            tanque.nextDay(tanque, this);
            if (comidaActual !=0){
                
            }
            
        }
    }

    /**
     * Vende peces que son adultos y fértiles, obteniendo monedas y actualizando el monedero.
     */
    public void sellFish() {
         for ( Tanque<? extends Pez> tanque : tanques) {
            for (Pez pez : tanque.getPeces()){
                if(pez.isVida() == true && pez.verificarMadurez()){
                    PecesDatos datos = pez.getDatos();
                    int precio = datos.getMonedas();
                    Monedero monedero = Monedero.getInstance();
                    monedero.vender(precio);
                }
                }
         }
    }
     /**
     * Realiza una mejora en la cantidad de comida disponible en la piscifactoria.
     * @param comidaSumada La cantidad de comida a añadir al depósito.
     */
    public void upgradeFood(int comidaSumada) {
        int capacidadMaxActu = comidaMaxima;
        this.setComidaMaxima(capacidadMaxActu + comidaMaxima);
    }
     /**
     * Obtiene el nombre de la piscifactoria.
     * @return Nombre de la piscifactoria.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la piscifactoria.
     * @return Nombre de la piscifactoria.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     /**
     * Obtiene la cantidad máxima de comida de un tanque, dependiendo del tipo de piscifactoria.
     * @return La cantidad máxima comida de un tanque.
     */
    public int obtenerComidaMaximaTanq() {
        if (this instanceof IRio) {
            return 25;
        } else {
            return 100;
        }
    }
    /**
     * Obtiene la canpacidad máxima de comida de un tanque, dependiendo del tipo de piscifactoria.
     * @return La capacidad máxima comida de un tanque.
     */
    public int obtenerCapacidadMaximaTanq() {
        if (this instanceof IRio) {
            return 25;
        } else {
            return 100;
        }
    }

    /**
     * Establece la cantidad máxima de comida en la piscifactoria.
     * @param comidaMaxima La nueva cantidad máxima de comida en la piscifactoria.
     */
    public void setComidaMaxima(int comidaMaxima) {
        this.comidaMaxima = comidaMaxima;
    }

    /**
     * Obtiene la cantidad actual de comida en la piscifactoria.
     * @return La cantidad actual de comida en la piscifactoria.
     */
    public int getComidaActual() {
        return comidaActual;
    }

    /**
     * Establece la cantidad actual de comida en la piscifactoria.
     * @param comidaActual La nueva cantidad actual de comida en la piscifactoria.
     */
    public void setComidaActual(int comidaActual) {
        this.comidaActual = comidaActual;
    }

    /**
     * Obtiene la cantidad máxima de comida en la piscifactoria.
     * @return La cantidad máxima de comida en la piscifactoria.
     */
    public int getComidaMaxima() {
        return comidaMaxima;
    }

    /**
     * Obtiene la cantidad de tanques en la piscifactoria.
     * @return La cantidad de tanques en la piscifactoria.
     */
    public int getCantTanques(){
        int contador = 0;
        for (Tanque<? extends Pez> tanque : tanques){
            contador++;
        }
        return contador;
    }
    /**
     * Obtiene el espacio total disponible en la piscifactoria para tanques.
     * @return espacio total.
     */
     public int getEspacioTotal(){
        int espacio = getCantTanques()*obtenerCapacidadMaximaTanq();
        return espacio;
    }
    /**
     * Obtiene el número total de peces en la piscifactoria.
     * @return número total de peces.
     */
    public  int getPecesTotales(){
        int total=0;
        for (Tanque<? extends Pez> tanque : tanques){
            total+=tanque.getPeces().size();
        }
        return total;
    }
    /**
     * Obtiene el número total de peces vivos en la piscifactoria.
     * @return numero peces vivos.
     */
    public int getVivosTotales(){
        int vivos =0;
        for (Tanque<? extends Pez> tanque: tanques){
            vivos+=tanque.getPecesVivos();
        }
        return vivos;
    }
    


}
