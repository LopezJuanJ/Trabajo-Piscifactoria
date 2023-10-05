public abstract class Pez {
    private final String pez;
    private final String nombreCientifico;
    private int edad;
    private final String sexo;
    private boolean fertilidad;
    private boolean vida;
    private boolean alimentado;
    

  
    public Pez(String pez, String nombreCientifico, int edad, String sexo, boolean fertilidad, boolean vida,boolean alimentado) {
        this.pez = pez;
        this.nombreCientifico = nombreCientifico;
        this.edad = edad;
        this.sexo = sexo;
        this.fertilidad = fertilidad;
        this.vida = vida;
        this.alimentado = alimentado;
    }
    public void showStatus() {
        System.out.println("---------------"+ pez +"---------------");
        System.out.println("Edad " + edad + "dias");
        System.out.println("Sexo: " + sexo);
        verificarAlimentacion(alimentado);
        verificarVida(vida);
        System.out.println("Adulto: ");
        mostrarFertilidad(fertilidad);
    }

    private void verificarAlimentacion(boolean alimentado) {
        if(alimentado = true){
            System.out.println("Alimentado: Si");
        } else {
            System.out.println("Alimentado: No");
        }
    }

    private void verificarVida(boolean vida) {
        if(vida = true){
            System.out.println("Vivo: Si");
        } else {
            System.out.println("Vivo: No");
        }
    }

    public void mostrarFertilidad(boolean fertilidad) {
        if (fertilidad = true) {
            System.out.println("Fertilidad: Si");
        } else {
            System.out.println("Fertilidad: No");
        }
    }


    public void grow() {

    }
    public void reset() {
        edad = 0;
        fertilidad = false;
        vida = true;
        alimentado = false;  

    }
    
}
