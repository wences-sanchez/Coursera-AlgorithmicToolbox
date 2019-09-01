package wencesanchez.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Esta es una implementación práctica del algoritmo que se pidió se codificase
 */
public class MochilaContinua {
    private final long numItems;
    private long capacidadMochila;
    private long[] valores;
    private long[] pesos;
    private List<ItemMochila> itemsCandidatos;

    public MochilaContinua(long numItems, long capacidadMochila, List<ItemMochila> itemsCandidatos) {
        this.numItems = numItems;
        this.capacidadMochila = capacidadMochila;
        this.itemsCandidatos = new ArrayList<>(itemsCandidatos);

        Collections.sort(itemsCandidatos);
    }

    public double obtenerValorMaximoEnMochila() {
        double valorMaximoEnMochila = 0;
        for(int i=0; i < numItems; i++) {
            if (capacidadMochila == 0) return valorMaximoEnMochila;
            double elemento = Math.min(itemsCandidatos.get(i).getPeso(), capacidadMochila);

            valorMaximoEnMochila += elemento * (
                    itemsCandidatos.get(i).getValor() / itemsCandidatos.get(i).getPeso());

            itemsCandidatos.get(i).setPeso(itemsCandidatos.get(i).getPeso() - elemento);
            capacidadMochila -= elemento;
        }
        return valorMaximoEnMochila;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numItems = scanner.nextInt();
        long capacidadMochila = scanner.nextLong();
        List<ItemMochila> itemsCandidatos = new ArrayList<>();

        for(int i=0; i < numItems; i++) {
            long valor = scanner.nextLong();
            long peso = scanner.nextLong();
            itemsCandidatos.add(new ItemMochila(valor,peso));
        }

        MochilaContinua mochilaContinua = new MochilaContinua(numItems,capacidadMochila,itemsCandidatos);
        System.out.printf("%.4f", mochilaContinua.obtenerValorMaximoEnMochila());

        scanner.close();
    }
}
