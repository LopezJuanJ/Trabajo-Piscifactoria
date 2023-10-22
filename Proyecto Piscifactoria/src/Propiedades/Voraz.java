package Propiedades;

public class Voraz {
    protected boolean alimentado;

    public int comerVoraz(int comida){
        if(alimentado=false){
            comida-=2;
            alimentado=true;
        }
        return comida;
    }
}
