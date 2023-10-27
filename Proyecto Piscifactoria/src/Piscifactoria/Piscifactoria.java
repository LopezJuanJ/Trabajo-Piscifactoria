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
   
    protected int espacioMaximo;
    protected String nombre;
    protected Simulador simulador;
    protected String tipo;
    public ArrayList<Tanque<? extends Pez>> tanques;
    
    public Piscifactoria(String nombre) {
        this.nombre = nombre;
    }
    public int getComidaMaxima() {
        return comidaMaxima;
    }


   
    public void showStatus() {
        System.out.println("===============" + simulador.getNombrePiscifactoria() + "===============");
        System.out.println("Tanques: ");
        System.out.println("Ocupación: peces / max (x%)");
        System.out.println("Peces vivos: vivos / total (x%)");
        System.out.println("Peces alimentados: alimentados / vivos (x%)");
        System.out.println("Hembras / Machos: H/M");
        System.out.println("Fértiles: fértiles / vivos");
        System.out.println("Almacén de comida: actual / max (x%)");
    }

    public void showTankStatus() {
        for ( Tanque<? extends Pez> tanque : tanques) {

            String nombreTanque = tanque.getNombre();
            Tanque<? extends Pez> tnq = new Tanque<Pez>(nombreTanque, obtenerCapacidadMaximaPis());
            tnq.showStatus();
        }

    }

    public void showFishStatus(String nombreTanque) {
        Tanque<? extends Pez> tnq = new Tanque<Pez>(nombreTanque , obtenerCapacidadMaximaPis());
        tnq.showFishStatus();
    }

    public void showFood(){
        System.out.println("Deposito de comida de la piscifactoria"+ this.nombre+ "al" + (comidaActual/comidaMaxima)*100 + "% de capacidad" + comidaActual +"/"+ comidaMaxima);     
    }

    public void showCapacity(){
        Tanque<? extends Pez> tnq = new Tanque(nombre, comidaActual);
        System.out.println("Tanque " + this.nombre + " de la piscifactoria " + getNombre() + " al " + (tnq.getPeces().size()/tnq.capacidadMax)*100 + "% de capacidad" + tnq.getPeces().size() + "/" + tnq.capacidadMax);

    }

    public void nextDay() {
        for (Tanque<? extends Pez> tanque : tanques) {
            tanque.nextDay(tanque, this);
            if (comidaActual !=0){
                
            }
            
        }
    }

    public void sellFish() {
         for ( Tanque<? extends Pez> tanque : tanques) {
            String nombreTanque = tanque.getNombre();
          Tanque<? extends Pez> tnq = new Tanque<Pez>(nombreTanque , obtenerCapacidadMaximaPis());
            for (Pez pez : tnq.getPeces()){
                if(pez.isVida() == true && pez.verificarMadurez()){
                    PecesDatos datos = pez.getDatos();
                    int precio = datos.getMonedas();
                    Monedero monedero = Monedero.getInstance();
                    monedero.vender(precio);
                }
                }
         }
    }

    public void upgradeFood(int comidaSumada) {
        int capacidadMaxActu = comidaMaxima;
        this.setComidaMaxima(capacidadMaxActu + comidaMaxima);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int obtenerComidaMaximaPis() {
        if (this instanceof IRio) {
            return 25;
        } else {
            return 100;
        }
    }

    public int obtenerCapacidadMaximaPis() {
        if (this instanceof IRio) {
            return 25;
        } else {
            return 100;
        }
    }


    public void setComidaMaxima(int comidaMaxima) {
        this.comidaMaxima = comidaMaxima;
    }

    public int getComidaActual() {
        return comidaActual;
    }

    public void setComidaActual(int comidaActual) {
        this.comidaActual = comidaActual;
    }
    


}
