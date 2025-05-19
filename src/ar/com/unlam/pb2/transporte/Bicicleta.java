package ar.com.unlam.pb2.transporte;

import java.util.ArrayList;
import java.util.List;

import ar.com.unlam.pb2.paquete.*;

public class Bicicleta extends Transporte {
	private List<Paquete> paquetes = new ArrayList<>();
	private String destino;

	public Bicicleta() {
		super(15.0, 0.125);
	}

	@Override
	public boolean puedeLlevarPaquete(Paquete paquete) {
		if (paquetes.size() >= 2) {
			return false;
		}
		if (!puedeAgregarPaquete(paquete)) {
			return false;
		}
		if (destino == null) {
			destino = paquete.getDestino();
		} else if (!destino.equals(paquete.getDestino())) {
			return false;
		}
		paquetes.add(paquete);
		sumarPesoYVolumen(paquete);
		return true;
	}

}
