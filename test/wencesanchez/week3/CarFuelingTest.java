package wencesanchez.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFuelingTest {

    @Test
    void testConDepositoLlenoNoPara() {
        assertEquals(0,
                new CarFueling(100,100,3,new double[]{50,70,90})
                        .obtenerMinimoRepostajes(),
                "Con depósito lleno no para");
        assertEquals(0, new CarFueling(100,101,3,new double[]{50,53,99})
                        .obtenerMinimoRepostajes(),
                "Con depósito lleno no para");
    }

    @Test
    void testParaUnaVez() {
        assertEquals(1, new CarFueling(300, 180, 4, new double[]{180,230,250,299})
                        .obtenerMinimoRepostajes(),
                "Para una vez");
        assertEquals(1, new CarFueling(500, 300, 3, new double[]{100,150,275})
                        .obtenerMinimoRepostajes(),
                "Para una vez");
    }

    @Test
    void testImposibleDevuelveMenosUno() {
        assertEquals(-1, new CarFueling(200,99, 2, new double[]{50,99})
                        .obtenerMinimoRepostajes(),
                        "Imposible");
    }

    @Test
    void testParaDosVeces() {
        assertEquals(3, new CarFueling(200, 67, 5, new double[]{54,66,115,181,182})
                        .obtenerMinimoRepostajes(),
                        "Para dos veces");
    }
}