package Stats;

import estadisticas.Estadisticas;
import propiedades.AlmacenPropiedades;

public class Stats {
    /**
     * Los peces que se encuentran implementados actualmente en el juego y que se registran en las estadisticas
     */
    private static String pecesImplementados[] = {AlmacenPropiedades.TILAPIA_NILO.getNombre(), AlmacenPropiedades.LUCIO_NORTE.getNombre(), AlmacenPropiedades.CORVINA.getNombre(), AlmacenPropiedades.SALMON_CHINOOK.getNombre(), AlmacenPropiedades.PEJERREY.getNombre(), AlmacenPropiedades.LENGUADO_EUROPEO.getNombre(), AlmacenPropiedades.CABALLA.getNombre(), AlmacenPropiedades.BESUGO.getNombre(), AlmacenPropiedades.ROBALO.getNombre(), AlmacenPropiedades.LUBINA_RAYADA.getNombre(), AlmacenPropiedades.LUBINA_EUROPEA.getNombre(), AlmacenPropiedades.SALMON_ATLANTICO.getNombre()};

    private static Estadisticas stats = new Estadisticas(pecesImplementados);

    private static Stats instancia = null;

    private Stats() {
        stats = new Estadisticas(pecesImplementados);
    }

    public static Stats getInstancia() {
        if (instancia == null) {
            instancia = new Stats();
        }
        return instancia;
    }

    public static Estadisticas getStats() {
        return stats;
    }
}
