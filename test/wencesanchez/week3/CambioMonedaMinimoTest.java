package wencesanchez.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CambioMonedaMinimoTest {

    @Test
    public void testDadoUnaMonedaDevuelveUno() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();

        assertEquals(1, cambioMonedaMinimo.devolverCambio(1), "cambio de 1");
        assertEquals(1, cambioMonedaMinimo.devolverCambio(5), "cambio de 5");
        assertEquals(1, cambioMonedaMinimo.devolverCambio(10), "cambio de 10");
    }

    @Test
    public void testDadoElDobleDevuelveDosMonedas() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();

        assertEquals(2, cambioMonedaMinimo.devolverCambio(2), "cambio de dos de 1");
        assertEquals(2, cambioMonedaMinimo.devolverCambio(20), "cambio de dos de 10");
        assertEquals(2, cambioMonedaMinimo.devolverCambio(6), "cambio de 5 y 1");
        assertEquals(2, cambioMonedaMinimo.devolverCambio(11), "cambio de 10 y 1");
    }

    @Test
    public void testDadoUnCompuestoDevuelveVarias() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();
        long cambioDe8 = cambioMonedaMinimo.devolverCambio(8);

        assertEquals(4, cambioDe8, "cambio de 8");
        assertEquals(5, cambioMonedaMinimo.devolverCambio(9), "cambio de 9");
        assertEquals(4, cambioMonedaMinimo.devolverCambio(17), "cambio de 17");
        assertEquals(3, cambioMonedaMinimo.devolverCambio(25), "cambio de 10, 10 y 5");
    }
}