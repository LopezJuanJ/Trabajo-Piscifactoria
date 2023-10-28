package Almacen;
public class Almacen {
    protected int comida;
    

    public Almacen(int comida) {
        this.comida = comida;
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
