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
    
    public Piscifactoria(String nombre) {
        this.nombre = nombre;
        this.tanques = new ArrayList<Tanque<? extends Pez>>() ;
        this.comidaMaxima = obtenerComidaMaximaTanq();
        this.capacidadMaxima = obtenerCapacidadMaximaTanq();
    }


    public int getComidaMaxima() {
        return comidaMaxima;
    }

    public int getCantTanques(){
        int contador = 0;
        for (Tanque<? extends Pez> tanque : tanques){
            contador++;
        }
        return contador;
    }
    
   
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

    public int getEspacioTotal(){
        int espacio = getCantTanques()*obtenerCapacidadMaximaTanq();
        return espacio;
    }

    public  int getPecesTotales(){
        int total=0;
        for (Tanque tanque : tanques){
            total+=tanque.getPeces().size();
        }
        return total;
    }

    public int getVivosTotales(){
        int vivos =0;
        for (Tanque tanque: tanques){
            vivos+=tanque.getPecesVivos();
        }
        return vivos;
    }
    public void showTankStatus() {
        for ( Tanque<? extends Pez> tnq: tanques) {

            String nombreTanque = tnq.getNombre();
            tnq.showStatus();
            System.out.println(tnq.getTipoPezTank());
        }

    }

    public void showFishStatus(int indice) {
        int contador =0;
        for ( Tanque<? extends Pez> tnq: tanques) {
            if (indice == contador){
                 tnq.showFishStatus();
            }
            contador++;
        }
    }

    public void showFood(){
        System.out.println("Deposito de comida de la piscifactoria"+ this.nombre+ "al" + (comidaActual/comidaMaxima)*100 + "% de capacidad" + comidaActual +"/"+ comidaMaxima);     
    }

    public void showCapacity(){
        for (Tanque tanque : tanques){
            tanque.showCapacity(this.nombre);
        }
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

    public int obtenerComidaMaximaTanq() {
        if (this instanceof IRio) {
            return 25;
        } else {
            return 100;
        }
    }

    public int obtenerCapacidadMaximaTanq() {
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
