package Peces;


import propiedades.PecesDatos;
import propiedades.AlmacenPropiedades;

public class Carpin extends Pez {
    private int edad = 0;
    private boolean sexo;
    private boolean fertilidad;
    private boolean vida;
    private boolean alimentado;
    private PecesDatos datos = AlmacenPropiedades.CARPIN_TRES_ESPINAS;
    public Carpin(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
        
    }   
}
