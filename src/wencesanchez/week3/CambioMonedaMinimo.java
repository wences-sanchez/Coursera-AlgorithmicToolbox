package wencesanchez.week3;

import java.util.Scanner;

public class CambioMonedaMinimo {
    // Tenemos tres tipos de monedas para devolver el cambio
    private static long[] valoresMonedasDisponibles = {1, 5, 10};

    public long devolverCambio(long dineroADevolver) {
        long minimoMonedasDevueltas = 0;
        int i = 3;
        while(i >= 1) {
            // Buscamos el máximo óptimo para el movimiento voraz
            // Un máximo de la cantidad implicará un mínimo del número de monedas devueltas, que es lo que buscamos.
            long dineroDelTipoMonedaParaDevolver = valoresMonedasDisponibles[i-1];
            long minimoMonedasDelTipo = 0;
            while(dineroDelTipoMonedaParaDevolver <= dineroADevolver) {
                minimoMonedasDelTipo++;
                // Añadimos otra moneda del valor tipo definido
                dineroDelTipoMonedaParaDevolver += valoresMonedasDisponibles[i-1];
            }
            dineroADevolver -= minimoMonedasDelTipo * valoresMonedasDisponibles[i-1];
            minimoMonedasDevueltas += minimoMonedasDelTipo;
            i--;
        }
        return minimoMonedasDevueltas;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long dineroADevolver = scanner.nextLong();

        CambioMonedaMinimo cambioMonedaMinimo = new CambioMonedaMinimo();

        System.out.println(cambioMonedaMinimo.devolverCambio(dineroADevolver));
    }
}
