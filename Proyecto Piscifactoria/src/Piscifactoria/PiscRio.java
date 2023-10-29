package Piscifactoria;

import Peces.Besugo;
import Peces.Pez;
import Tanque.Tanque;

public class PiscRio extends Piscifactoria {
    public PiscRio(String nombre) {
        super(nombre);
        comidaActual = 25;
        comidaMaxima=25;
        capacidadMaxima=25;
        Tanque tanque = new Tanque<Pez>("Primer Tanque", capacidadMaxima);
        this.tanques.add(tanque);
    }

}
