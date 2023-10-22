package Propiedades;

public class Voraz {
    protected boolean alimentado;

    public void comerVoraz(int comida){
        if(alimentado=false){
            comida-=2;
            alimentado=true;
        }
        
    }
}
