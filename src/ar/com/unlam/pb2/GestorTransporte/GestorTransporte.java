package ar.com.unlam.pb2.GestorTransporte;

import ar.com.unlam.pb2.transporte.*;
import ar.com.unlam.pb2.paquete.*;

import java.util.ArrayList;
import java.util.List;

public class GestorTransporte {
	private List<Transporte> transportes = new ArrayList<>();

	public boolean agregarTransporte(Transporte transporte) {
		 if (transportes.contains(transporte)) {
	            return false; 
	        }
	        transportes.add(transporte);
	        return true;
	}

	public Transporte asignarPaquete(Paquete paquete) {
		for (Transporte vehiculo : transportes) {
			if (vehiculo.puedeLlevarPaquete(paquete)) {
				return vehiculo;
			}
		}
		return null; 
	}

	public List<Transporte> getTransportes() {
		return transportes;
	}
	
	
}