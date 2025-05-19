package ar.com.unlam.pb2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.com.unlam.pb2.GestorTransporte.GestorTransporte;
import ar.com.unlam.pb2.paquete.Paquete;
import ar.com.unlam.pb2.transporte.Auto;
import ar.com.unlam.pb2.transporte.Bicicleta;
import ar.com.unlam.pb2.transporte.Camion;
import ar.com.unlam.pb2.transporte.Transporte;

public class TransporteTest {

	@Test
	public void testBicicletaPuedeLlevarPaquete() {
		Bicicleta bicicleta = new Bicicleta();
		Paquete paquete = new Paquete(0.5, 0.2, 0.5, 10, "CiudadA");

		assertTrue(bicicleta.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testBicicletaNoPuedeLlevarPaqueteExcesoDePeso() {
		Bicicleta bicicleta = new Bicicleta();
		Paquete paquete = new Paquete(0.5, 0.2, 0.5, 16, "CiudadA");

		assertFalse(bicicleta.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testBicicletaNoPuedeLlevarPaqueteExcesoDeVolumen() {
		Bicicleta bicicleta = new Bicicleta();
		Paquete paquete = new Paquete(1.0, 0.5, 0.5, 10, "CiudadA");

		assertFalse(bicicleta.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testBicicletaNoPuedeLlevarPaqueteConDestinoDiferente() {
		Bicicleta bicicleta = new Bicicleta();
		Paquete paquete1 = new Paquete(0.5, 0.2, 0.5, 10, "CiudadA");
		Paquete paquete2 = new Paquete(0.5, 0.2, 0.5, 5, "CiudadB");

		bicicleta.puedeLlevarPaquete(paquete1);

		assertFalse(bicicleta.puedeLlevarPaquete(paquete2));
	}

	@Test
	public void testAutoPuedeLlevarPaquete() {
		Auto automovil = new Auto();
		Paquete paquete = new Paquete(1.0, 1.0, 1.0, 100, "CiudadA");

		assertTrue(automovil.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testAutoNoPuedeLlevarPaqueteExcesoDePeso() {
		Auto automovil = new Auto();
		Paquete paquete = new Paquete(1.0, 1.0, 1.0, 501, "CiudadA");

		assertFalse(automovil.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testAutoNoPuedeLlevarPaqueteExcesoDeVolumen() {
		Auto automovil = new Auto();
		Paquete paquete = new Paquete(2.0, 2.0, 2.0, 100, "CiudadA");

		assertFalse(automovil.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testAutoPuedeLlevarTresPaquetes() {
		Auto automovil = new Auto();
		Paquete paquete1 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadA");
		Paquete paquete2 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadB");
		Paquete paquete3 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadC");

		assertTrue(automovil.puedeLlevarPaquete(paquete1));
		assertTrue(automovil.puedeLlevarPaquete(paquete2));
		assertTrue(automovil.puedeLlevarPaquete(paquete3));
	}

	@Test
	public void testAutoNoPuedeLlevarTresPaquetes() {
		Auto automovil = new Auto();
		Paquete paquete1 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadA");
		Paquete paquete2 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadB");
		Paquete paquete3 = new Paquete(0.5, 1.0, 1.0, 100, "CiudadC");
		Paquete paquete4 = new Paquete(0.1, 1.0, 1.0, 100, "CiudadD");
		assertTrue(automovil.puedeLlevarPaquete(paquete1));
		assertTrue(automovil.puedeLlevarPaquete(paquete2));
		assertTrue(automovil.puedeLlevarPaquete(paquete3));
		assertFalse(automovil.puedeLlevarPaquete(paquete4));
	}

	@Test
	public void testAutoNoPuedeLlevarPaqueteConDestinoRepetido() {
		Auto automovil = new Auto();
		Paquete paquete1 = new Paquete(1.0, 1.0, 1.0, 100, "CiudadA");
		Paquete paquete2 = new Paquete(1.0, 1.0, 1.0, 100, "CiudadA");

		automovil.puedeLlevarPaquete(paquete1);

		assertFalse(automovil.puedeLlevarPaquete(paquete2));
	}

	@Test
	public void testCamionPuedeLlevarPaquete() {
		Camion camion = new Camion();
		Paquete paquete = new Paquete(2.0, 2.0, 2.0, 1000, "CiudadA");

		assertTrue(camion.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testCamionNoPuedeLlevarPaqueteExcesoDePeso() {
		Camion camion = new Camion();
		Paquete paquete = new Paquete(2.0, 2.0, 2.0, 16001, "CiudadA");

		assertFalse(camion.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testCamionNoPuedeLlevarPaqueteExcesoDeVolumen() {
		Camion camion = new Camion();
		Paquete paquete = new Paquete(10.0, 10.0, 10.0, 5000, "CiudadA");

		assertFalse(camion.puedeLlevarPaquete(paquete));
	}

	@Test
	public void testRegistrarTransporte() {
		Bicicleta bicicleta = new Bicicleta();
		GestorTransporte gestor = new GestorTransporte();
		assertTrue(gestor.agregarTransporte(bicicleta));
	}

	@Test
	public void testNoRegistrarTransporte() {
		Bicicleta bicicleta = new Bicicleta();
		GestorTransporte gestor = new GestorTransporte();
		assertTrue(gestor.agregarTransporte(bicicleta));
		assertFalse(gestor.agregarTransporte(bicicleta));

	}

	@Test
	public void testAsignarPaqueteBicicletaDisponible() {
		Bicicleta bicicleta = new Bicicleta();
		GestorTransporte gestor = new GestorTransporte();
		gestor.agregarTransporte(bicicleta);
		Paquete paquete = new Paquete(0.5, 0.2, 0.5, 10, "CiudadA");

		assertNotNull(gestor.asignarPaquete(paquete));
	}


	

	@Test
	public void testNoAsignarPaqueteInvalidoBicicletaDisponible() {
		Bicicleta bicicleta = new Bicicleta();
		GestorTransporte gestor = new GestorTransporte();
		gestor.agregarTransporte(bicicleta);
		Paquete paquete = new Paquete(05, 0.2, 0.5, 500, "CiudadA");

		assertNull(gestor.asignarPaquete(paquete));
	}
	
	@Test
	 public void testAsignarPaqueteAAutoDisponibleYNoABicicletaDisponible() {
	        Bicicleta bicicleta = new Bicicleta();
	        GestorTransporte gestor= new GestorTransporte();
	        Auto auto=new Auto();
	        gestor.agregarTransporte(bicicleta);
	        gestor.agregarTransporte(auto);
	        Paquete paquete = new Paquete(0.5, 0.2, 0.5, 100, "CiudadA");
	        

	        assertNotNull(gestor.asignarPaquete(paquete));
	    }
}
