package Monedero;

public class Monedero {
    private int monedas;
    private static Monedero instance;

    private Monedero() {
        this.monedas = 100;
    }

    /**
     * Obtiene la instancia del monedero.
     * @return la instancia del monedero
     */
    public static Monedero getInstance() {
        if (instance == null) {
            instance = new Monedero();
        }
        return instance;
    }

    /**
     * Obtiene la cantidad de monedas en el monedero.
     * @return La cantidad de monedas en el monedero.
     */
    public int getMonedas() {
        return this.monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    /**
     * Aumenta al monedero al realizar una venta
     * @param cantidad cantidad a añadir al monedero
     */
    public void vender(int cantidad) {
        this.monedas += cantidad;
    }

     /**
     * Aumenta la cantidad de monedas en el monedero al realizar una venta.
     * @param cantidad La cantidad a añadir al monedero.
     */
    public void comprar(int cantidad) {
        this.monedas -= cantidad;
    }
    /**
     * Imprime la cantidad actual de monedas en el monedero.
     */
    public void saberMonedas() {
        System.out.println("Actualmente tienes: " + this.monedas + " monedas.");
    }

}