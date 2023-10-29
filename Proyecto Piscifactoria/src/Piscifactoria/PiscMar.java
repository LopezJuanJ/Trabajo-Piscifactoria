package Piscifactoria;

import Peces.Pez;
import Tanque.Tanque;

public class PiscMar extends Piscifactoria {

    public PiscMar(String nombre) {
        super(nombre);
        comidaActual = 100;
        comidaMaxima=100;
        capacidadMaxima=100;
        Tanque tanque = new Tanque<Pez>("Primer Tanque", capacidadMaxima);
        this.tanques.add(tanque);
    }
    
}
