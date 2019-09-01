package wencesanchez.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CambioMonedaMinimoTest {

    @Test
    public void testDadoUnaMonedaDevuelveUno() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();
        long cambioDeUno = cambioMonedaMinimo.devolverCambio(1);
        assertEquals(1, cambioDeUno, "cambioDeUno");

        long cambioDeCinco = cambioMonedaMinimo.devolverCambio(5);
        assertEquals(1, cambioDeCinco, "cambioDeCinco");

        long cambioDeDiez = cambioMonedaMinimo.devolverCambio(10);
        assertEquals(1, cambioDeDiez, "cambioDeDiez");
    }

    @Test
    public void testDadoElDobleDevuelveDosMonedas() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();
        long cambioDeDosDeUno = cambioMonedaMinimo.devolverCambio(2);
        assertEquals(2, cambioDeDosDeUno, "cambioDeDosDeUno");

        long cambioDeDosDeDiez = cambioMonedaMinimo.devolverCambio(20);
        assertEquals(2, cambioDeDosDeDiez, "cambioDeDosDeDiez");
    }

    @Test
    public void testDadoUnCompuestoDevuelveVarias() {
        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();
        long cambioDe8 = cambioMonedaMinimo.devolverCambio(8);

        assertEquals(4, cambioDe8, "cambio de 8");
    }
}