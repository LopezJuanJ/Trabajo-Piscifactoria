package Monedero;

public class Monedero {
    private int monedas;
    private static Monedero instance;

    private Monedero() {
        this.monedas = 100;
    }

    public static Monedero getInstance() {
        if (instance == null) {
            instance = new Monedero();
        }
        return instance;
    }

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

    public void comprar(int cantidad) {
        this.monedas -= cantidad;
    }

    public void saberMonedas() {
        System.out.println("Actualmente tienes: " + this.monedas + " monedas.");
    }

    public boolean posibilidadCompra(int cantidad) {
        return cantidad <= monedas;
    }
}