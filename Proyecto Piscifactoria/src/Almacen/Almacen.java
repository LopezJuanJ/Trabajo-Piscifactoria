public class Almacen {
    protected int comida;
    

    public void restarComida(int cantidad){
        if(comida > 0){
            comida-=cantidad;
        }else{

            System.out.println("Sin comida en el Almacen");
        }
    }


    public int getComida() {
        return comida;
    }


    public void setComida(int comida) {
        this.comida = comida;
    }
}
