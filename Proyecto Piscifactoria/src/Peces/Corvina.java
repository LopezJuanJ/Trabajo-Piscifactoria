package Peces;

import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Corvina extends Pez {
    private PecesDatos datos = AlmacenPropiedades.CORVINA;

    public Corvina(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
    }

    
    
}
