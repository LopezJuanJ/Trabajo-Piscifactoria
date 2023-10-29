package Almacen;


public class AlmacenCentral {
    protected int comida;
    private static AlmacenCentral instance;


    public AlmacenCentral() {
        this.comida = 200;
    }
/**
     * Obtiene la instancia del Almacen central.
     * @return la intancia del Almacen central , devolvera null si no esta creado
     */
    public static AlmacenCentral getInstance() {
        // if (instance == null) {
        //     instance = new AlmacenCentral();
        // }
        return instance;   

    }
    /**
     * Resta la comida indicada en la cantidad.
     * @param cantidad cantidad a restar en la comida.
     */
    public void restarComida(int cantidad){
        if(comida > 0){
            comida-=cantidad;
        }else{

            System.out.println("Sin comida en el Almacen");
        }
    }

    /**.
     * Obtiene la cantidad de comida del almacén.
     * @return devuelve la comida del almacén.
     */
    public int getComida() {
        return comida;
    }



    /**
     * Establece la cantidad de comida.
     * @param comida la cantidad de comida en el almacén.
     */
    public void setComida(int comida) {
        this.comida = comida;
    }

}
