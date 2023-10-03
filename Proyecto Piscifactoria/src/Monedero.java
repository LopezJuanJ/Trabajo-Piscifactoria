public class Monedero {
    private int monedas;

    public Monedero(int monedas) {
        this.monedas = monedas;
    }

    public int getMonedas() {
        return this.monedas;
    }

    public void sumarMonedas(int cantidad){
        this.monedas += cantidad;
    }

    public void restarMonedas(int cantidad){
        this.monedas -= cantidad;
    }

    public void saberMonedas(){
        System.out.println("Actualmente tienes: " + this.monedas + " monedas.");
    }
}
