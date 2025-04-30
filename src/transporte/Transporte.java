package transporte;

import paquete.*;

public abstract class Transporte {
    protected final double MAX_PESO;
    protected final double MAX_VOLUMEN;
    protected double pesoTotal = 0;
    protected double volumenTotal = 0;

    public Transporte(double maxPeso, double maxVolumen) {
        this.MAX_PESO = maxPeso;
        this.MAX_VOLUMEN = maxVolumen;
    }

    protected boolean puedeAgregarPaquete(Paquete paquete) {
        return (pesoTotal + paquete.getPeso()) <= MAX_PESO &&
               (volumenTotal + paquete.getVolumen()) <= MAX_VOLUMEN;
    }

    protected void sumarPesoYVolumen(Paquete paquete) {
        pesoTotal += paquete.getPeso();	
        volumenTotal += paquete.getVolumen();
    }

    public abstract boolean puedeLlevarPaquete(Paquete paquete);
}
