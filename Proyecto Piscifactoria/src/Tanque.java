public class Tanque {
    private int numero;
    private int capacidadMaxima;
    private List<Pez> peces;

    public Tanque(int numero, int capacidadMaxima) {
        this.numero = numero;
        this.capacidadMaxima = capacidadMaxima;
        this.peces = new ArrayList<>();
    }

    public void addPez(Pez pez) {
        peces.add(pez);
    }

    public void showStatus() {
        DecimalFormat df = new DecimalFormat("0.00");
        int ocupacion = peces.size();
        double ocupacionPorcentaje = (double) ocupacion / capacidadMaxima * 100;
        int pecesVivos = 0; // Calcular la cantidad de peces vivos
        // Otros cálculos relevantes

        System.out.println("=============== Tanque " + numero + " ===============");
        System.out.println("Ocupación: " + ocupacion + " / " + capacidadMaxima + " (" + df.format(ocupacionPorcentaje) + "%)");
        System.out.println("Peces vivos: " + pecesVivos + " / " + ocupacion + " (" + df.format((double) pecesVivos / ocupacion * 100) + "%)");
        // Otros datos a mostrar
    }

    public void showFishStatus() {
        for (Pez pez : peces) {
            System.out.println(pez);
        }
    }

    public void showCapacity() {
        System.out.println("Tanque " + numero + " de la piscifactoría x al " + (peces.size() * 100 / capacidadMaxima) + "% de capacidad.");
        System.out.println("[" + peces.size() + "/" + capacidadMaxima + "]");
    }

    public void nextDay() {
    }
    
    
}
