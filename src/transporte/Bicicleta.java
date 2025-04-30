package transporte;

import paquete.*;

public class Bicicleta extends Transporte {
    private Paquete[] paquetes = new Paquete[2];
    private int cantidadPaquetes = 0;
    private String destino;

    public Bicicleta() {
        super(15.0, 0.125);
    }

    @Override
    public boolean puedeLlevarPaquete(Paquete p) {
        if (cantidadPaquetes >= 2) return false;
        if (!puedeAgregarPaquete(p)) return false;
        if (destino == null) destino = p.getDestino();
        else if (!destino.equals(p.getDestino())) return false;
        paquetes[cantidadPaquetes++] = p;
        sumarPesoYVolumen(p);
        return true;
    }
}




