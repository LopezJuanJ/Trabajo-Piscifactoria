package Piscifactoria;

import java.util.ArrayList;
import java.util.Scanner;

import Monedero.Monedero;
import Peces.IRio;
import Peces.Pez;
import Simulador.Simulador;
import Stats.Stats;
import Tanque.Tanque;
import estadisticas.Estadisticas;
import propiedades.PecesDatos;

public class Piscifactoria {
    protected int comidaActual;
    public Scanner newScan = new Scanner(System.in);
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
    public double porcentaje(int numero1, int numero2){
        if (numero2 == 0) {
            return 0.0;
        }
        double porcentaje = (double) numero1 / numero2 * 100;
        porcentaje = Math.round(porcentaje * 10) / 10.0;
        return porcentaje;
    }

     /**
     * Muestra todos los datos del pez.
     */
    public void showStatus() {
        System.out.println("===============" + this.nombre + "===============");
        System.out.println("Tanques: " + getCantTanques());
        System.out.println("Ocupación: " + this.getPecesTotales() +"/"+this.getEspacioTotal()+ " (" +porcentaje(this.getPecesTotales(),this.getEspacioTotal()) + "%)");
        System.out.println("Peces vivos: " + this.getVivosTotales()+"/"+getPecesTotales() + " (" + porcentaje(this.getVivosTotales(),getPecesTotales()) +"%)");
        System.out.println("Peces alimentados:" + this.getPecesAlimentadossTotales()+"/"+this.getVivosTotales() + " (" + porcentaje(this.getPecesAlimentadossTotales(),this.getVivosTotales())+"%)");
        System.out.println("Hembras / Machos: " );
        System.out.println("Fértiles: fértiles / vivos");
        System.out.println("Almacén de comida: " + this.getComidaActual()+ "/" + this.getComidaMaxima());
    }

    /**
     * Muestra un menú de la información de cada tanque.
     */
    public void showTankStatus() {
        int indice =1;
        for ( Tanque<? extends Pez> tnq: tanques) {
            System.out.println(indice);
            tnq.showStatus();
            System.out.println("Tipo: " + tnq.getTipoPezTank());
            indice++;
        }

    }

    public void addTank(int tipo){
        System.out.print("Dime Nombre del tanque");
        String nom = newScan.nextLine();
        Tanque tanque = new Tanque<Pez>(nom, tipo);
        this.tanques.add(tanque);
        if (tipo==25){
            Monedero.getInstance().comprar(150);
        }else{
            Monedero.getInstance().comprar(600);
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
                    Monedero.getInstance().vender(precio);
                    Stats.getStats().registrarVenta(pez.getDatos().getNombre(), pez.getDatos().getMonedas());
                }
            }
             tanque.limpiarPeces();


         }
    }
     /**
     * Realiza una mejora en la cantidad de comida disponible en la piscifactoria.
     *
     */
    public void upgradeFood() {
        Monedero monedas = Monedero.getInstance();
        int cantAument = 0;
       if (this instanceof IRio) {
            if(!(this.comidaMaxima==250)){
                if(monedas.getMonedas()>=100){
                    monedas.comprar(100);
                    setComidaMaxima(25+this.comidaMaxima);
                    cantAument = 25;
                    System.out.println("Almacen de la comida de la piscifactoria "+ this.nombre + " mejorado. Su cacidad en " + cantAument + " hasta un total de " + this.capacidadMaxima); 
                } else{
                    System.out.println("Dinero Insuficiente");
                }
            }
        } else {
            if(!(this.comidaMaxima==1000)){
                if(monedas.getMonedas()>=200){
                    monedas.comprar(200);                    
                    setComidaMaxima(100+this.comidaMaxima);
                    cantAument = 100;
                    System.out.println("Almacen de la comida de la piscifactoria "+ this.nombre + " mejorado. Su cacidad en " + cantAument + " hasta un total de " + this.capacidadMaxima); 
                } else{
                    System.out.println("Dinero Insuficiente");
                }
            }
        }

    }

    public  void deleteEmptyTank(int indice){

        if (tanques.get(indice).peces.isEmpty()) {
            tanques.remove(indice);
        } else {
            System.out.println("El tanque tiene peces, no puede ser eliminado.");
        }
    }
        public Tanque<? extends Pez> buscarTanq(Pez p) {
            ArrayList<Tanque<? extends Pez>> compatibles = new ArrayList<>();
            for (Tanque<? extends Pez> tanque : tanques) {
                if (tanque.compararTipo(p)) {
                    compatibles.add(tanque);
                }
            }
            return compatibles.get(0);
        }

    public void anadirPez(Pez pez) {
        Tanque tanqueOptimo = buscarTanq(pez);
        if (tanqueOptimo == null) {
            System.out.println("No tienes un tanque disponible!");
            return;
        }
        tanqueOptimo.addFish(pez);

        System.out.println("Se ha comprado: " + pez.getDatos().getNombre());
        int precio = pez.getDatos().getCoste();
        Monedero.getInstance().comprar(precio);
    }
    public void anadirPez98(Pez pez) {
        Tanque tanqueOptimo = buscarTanq(pez);
        if (tanqueOptimo == null) {
            System.out.println("No tienes un tanque disponible!");
            return;
        }
        tanqueOptimo.addFish(pez);

        System.out.println("Se ha comprado: " + pez.getDatos().getNombre());
        int precio = pez.getDatos().getCoste();
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
    public void buscarTanqueOptimo(){

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
        for (Tanque<? extends Pez> tanque : this.tanques){
            contador++;
        }
        return contador;
    }
    /**
     * Obtiene el espacio total disponible en la piscifactoria para tanques.
     * @return espacio total.
     */
     public int getEspacioTotal(){
        int espacio = this.getCantTanques()*this.obtenerCapacidadMaximaTanq();
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

    public  int getPecesAlimentadossTotales(){
        int total=0;
        for (Tanque<? extends Pez> tanque : tanques){
            total+=tanque.getPecesAlimentados();
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
