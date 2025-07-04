package ar.com.unlam.pb2.transporte;
import ar.com.unlam.pb2.paquete.*;

public class Camion extends Transporte {
    public Camion() {
        super(16000.0, 20.0);
    }

    @Override
    public boolean puedeLlevarPaquete(Paquete paquete) {
        if (!puedeAgregarPaquete(paquete)) {
        	return false;
        }
        sumarPesoYVolumen(paquete);
        return true;
    }
}
