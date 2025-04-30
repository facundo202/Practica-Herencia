package transporte;
import paquete.*;
public class Auto extends Transporte {
	private String[] destinos = new String[3];
    private int cantidadDestinos = 0;

    public Auto() {
        super(500.0, 2.0);
    }

    private boolean agregarDestino(String destino) {
        for (int i = 0; i < cantidadDestinos; i++) {
            if (destinos[i].equals(destino)) return false;
        }
        if (cantidadDestinos < 3) {
            destinos[cantidadDestinos++] = destino;
            return true;
        }
        return false;
    }

    @Override
    public boolean puedeLlevarPaquete(Paquete paquete) {
        if (!puedeAgregarPaquete(paquete)) return false;
        if (!agregarDestino(paquete.getDestino())) return false;
        sumarPesoYVolumen(paquete);
        return true;
    }
}
