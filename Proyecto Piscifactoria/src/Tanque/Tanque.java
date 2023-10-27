package Tanque;

import java.util.ArrayList;

import Peces.IRio;
import Peces.Pez;
import Piscifactoria.Piscifactoria;

public class Tanque<T extends Pez> {
    public ArrayList<T> peces;

    public int capacidadMax;
    public String nombre;

    public Tanque(String nombre, int capacidadMax) {
        this.peces = new ArrayList<>();
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;

    }

    public ArrayList<T> getPeces() {
        return peces;
    }

    public void setPeces(ArrayList<T> peces) {
        this.peces = peces;
    }

    public void showStatus() {
        System.out.println("=============== Tanque # ===============");
        System.out.println("Ocupacion: " + getPeces() + "/" + capacidadMax + "("+ (getPeces().size() / capacidadMax) * 100 + "%)");
        System.out.println("Peces vivos" + getPecesVivos() + "/" + getPeces().size() + "("+ (getPecesVivos() / getPeces().size()) * 100 + "%)");
        System.out.println("Peces alimentados: " + getPecesAlimentados() + "/" + getPecesVivos() + "("+ (getPecesAlimentados() / getPecesVivos()) * 100 + "%)");
        System.out.println("Peces adultos: " + getPecesMaduros() + "/" + getPecesVivos() + "("+ (getPecesMaduros() / getPecesVivos() * 100) + "%)");
        System.out.println("Hembras/Machos: " + getMachos() + "/" + getHembras());
        System.out.println("Fertiles: " + getPecesFertiles() + "/" + getPecesVivos() + "("+ (getPecesFertiles() / getPecesVivos() * 100) + "%)");
    }

    public void showFishStatus() {
        for (T pez : peces) {
            pez.showStatus();
        }

    }

    public void nextDay(Tanque<? extends Pez> tanque, Piscifactoria piscifactoria) {
        for (T pez : peces) {
            pez.grow(tanque, piscifactoria);
        }
    }

    public void reproduccion() {
        boolean machoFertil = false;
        boolean hembraFertil = false;

        for (T pez : peces) {
            if (pez.isSexo() && pez.fertilidad) {
                machoFertil = true;
            } else if (!pez.isSexo() && pez.fertilidad) {
                hembraFertil = true;
            }

            if (machoFertil && hembraFertil) {
                System.out.println("Los peces se pueden reproducir");
                break;
            }
        }

        if (!machoFertil || !hembraFertil) {
            System.out.println("Los peces no se pueden reproducir");
        }
    }
    
    public void showCapacity(){
        Piscifactoria psc = new Piscifactoria(nombre);
        System.out.println("Tanque " + this.nombre + " de la piscifactoria " + psc.getNombre() + " al " + (getPeces().size()/capacidadMax)*100 + "% de capacidad" + getPeces().size() + "/" + capacidadMax );
    }

    public int getCantPecesTotal() {
        int contador = 0;
        for (T pez : peces) {
            contador++;
        }
        return contador;
    }

    public int getMachos() {
        int getMachos = 0;
        for (T pez : peces) {
            if (pez.isSexo() && pez.isVida()) {
                getMachos++;
            }
        }
        return getMachos;
    }

    public int getHembras() {
        int getHembras = 0;
        for (T pez : peces) {
            if (!pez.isSexo() && pez.isVida()) {
                getHembras++;
            }
        }
        return getHembras;
    }

    public int getPecesFertiles() {
        int pecesFertiles = 0;
        for (T pez : peces) {
            if (pez.isFertilidad() == true) {
                pecesFertiles++;
            }
        }
        return pecesFertiles;
    }

    public int getPecesMuertos() {
        int pecesMuertos = 0;
        for (T pez : peces) {
            if (!pez.isVida()) {
                pecesMuertos++;
            }
        }
        return pecesMuertos;
    }

    public int getPecesVivos() {
        int pecesVivos = 0;
        for (T pez : peces) {
            if (pez.isVida()) {
                pecesVivos++;
            }
        }
        return pecesVivos;
    }

    public int getPecesAlimentados() {
        int getPecesAlimentados = 0;
        for (T pez : peces) {
            if (pez.isAlimentado()) {
                getPecesAlimentados++;
            }
        }
        return getPecesAlimentados;
    }

    public int getPecesMaduros() {
        int getPecesMaduros = 0;
        for (T pez : peces) {
            if (pez.verificarMadurez()) {
                getPecesMaduros++;
            }
        }
        return getPecesMaduros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
