package Monedero;
public class Monedero {
    private int monedas;

    public Monedero(int monedas) {
        this.monedas = monedas;
    }

    public int getMonedas() {
        return this.monedas;
    }
    
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }
    

    public void vender(int cantidad){
        this.monedas += cantidad;
    }

    public void comprar(int cantidad){
        this.monedas -= cantidad;
    }

    public void saberMonedas(){
        System.out.println("Actualmente tienes: " + this.monedas + " monedas.");
    }

    public boolean posibilidadCompra(int cantidad){
        if(cantidad< monedas){
            return false;
        }else{
            return true;
        }
    }
}
