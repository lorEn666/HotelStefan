package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.IoDatos;
import principal.OperacionHabitacion;
import principal.Reservar;

class testeo {

	OperacionHabitacion opHab;
	Reservar reserva;
	@BeforeEach
	void setUp() throws Exception {
		opHab = new OperacionHabitacion();
		reserva = new Reservar();
	}

	@Test
	void testDisponibilidadHabitaciones() {
		assertEquals(true, opHab.comprobarHabitacionTest(0));
	}
	

	@Test
	void testDisponibilidadHabitaciones_2() {
		try {
			opHab.comprobarHabitacion(60);
			assertFalse(false);
			//De esta manera si no hay excepción salta a false
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	void testValorLimiteFecha() {
		assertEquals(true, reserva.comprobarMesTest(2002, 12, 31));
	}
	
	@Test
	void testValorLimiteFecha_2() {
		assertEquals(false, reserva.comprobarMesTest(1900, 2, 29));
	}
	
	@Test
	void testValorLimiteFecha_3() {
		assertEquals(false, reserva.comprobarMesTest(2003, 2, 29));
	}
	
	@Test
	void testComprobacionUsuario() {
		assertEquals(true, IoDatos.comprobarUser("Borja", "12345"));
	}
	
	@Test
	void testComprobacionUsuario_2() {
		assertEquals(false, IoDatos.comprobarUser("Iván", "001122"));
	}
}
