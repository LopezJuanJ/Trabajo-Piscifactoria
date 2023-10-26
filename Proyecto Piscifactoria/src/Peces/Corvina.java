package Peces;

import Peces.Propiedades.CarnivoroVoraz;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import propiedades.AlmacenPropiedades;
import propiedades.PecesDatos;

public class Corvina extends CarnivoroVoraz  implements IRio{
    private PecesDatos datos = AlmacenPropiedades.CORVINA;

    public Corvina(boolean sexo) {
        super(sexo, AlmacenPropiedades.CORVINA);

    }

    
    
}
