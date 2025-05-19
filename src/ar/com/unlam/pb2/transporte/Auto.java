package ar.com.unlam.pb2.transporte;
import java.util.HashSet;
import java.util.Set;

import ar.com.unlam.pb2.paquete.*;
public class Auto extends Transporte {
	private Set<String> destinos = new HashSet<>();
	private static final int MAX_DESTINOS = 3;

    public Auto() {
        super(500.0, 2.0);
    }

    private boolean agregarDestino(String destino) {
    	if (destinos.contains(destino)) { 
    		return false;
    	}
        if (destinos.size() < MAX_DESTINOS) {
            destinos.add(destino);
            return true;
        }
        return false;

    }

    @Override
    public boolean puedeLlevarPaquete(Paquete paquete) {
        if (!puedeAgregarPaquete(paquete)) {
        	return false;
        }
        if (!agregarDestino(paquete.getDestino())) {
        	return false;
        }
        sumarPesoYVolumen(paquete);
        return true;
    }
}
