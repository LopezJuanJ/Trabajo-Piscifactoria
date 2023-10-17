package Peces;

import java.util.function.Supplier;

import propiedades.PecesDatos;

public class Carpin extends Pez {
    private int edad = 0;
    private boolean sexo;
    private boolean fertilidad;
    private boolean vida;
    private boolean alimentado;
    protected PecesDatos datos;
    
    public Carpin(boolean sexo, PecesDatos datos) {
        super(sexo, datos);

    }   
}
