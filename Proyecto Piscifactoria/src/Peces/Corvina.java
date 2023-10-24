package Peces;

import Peces.Propiedades.CarnivoroVoraz;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Corvina extends CarnivoroVoraz {
    private PecesDatos datos = AlmacenPropiedades.CORVINA;

    public Corvina(boolean sexo, PecesDatos datos) {
        super(sexo, datos);
    }

    
    
}
