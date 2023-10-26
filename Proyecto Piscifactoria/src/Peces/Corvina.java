package Peces;

import Peces.Propiedades.CarnivoroVoraz;

import propiedades.AlmacenPropiedades;

public class Corvina extends CarnivoroVoraz  implements IRio{

    public Corvina(boolean sexo) {
        super(sexo, AlmacenPropiedades.CORVINA);

    }

    
    
}
