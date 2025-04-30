package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import paquete.Paquete;
import transporte.Auto;
import transporte.Bicicleta;
import transporte.Camion;

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
    public void testAutomovilPuedeLlevarPaquete() {
        Auto automovil = new Auto();
        Paquete paquete = new Paquete(1.0, 1.0, 1.0, 100, "CiudadA");

        assertTrue(automovil.puedeLlevarPaquete(paquete));
    }

    @Test
    public void testAutomovilNoPuedeLlevarPaqueteExcesoDePeso() {
        Auto automovil = new Auto();
        Paquete paquete = new Paquete(1.0, 1.0, 1.0, 501, "CiudadA");

        assertFalse(automovil.puedeLlevarPaquete(paquete));
    }

    @Test
    public void testAutomovilNoPuedeLlevarPaqueteExcesoDeVolumen() {
    	Auto automovil = new Auto();
        Paquete paquete = new Paquete(2.0, 2.0, 2.0, 100, "CiudadA");

        assertFalse(automovil.puedeLlevarPaquete(paquete));
    }

    @Test
    public void testAutomovilNoPuedeLlevarPaqueteConDestinoRepetido() {
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
}

