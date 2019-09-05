package wencesanchez.week3;

import java.util.Scanner;

public class CarFueling {

    private double kmsTotales;
    private double depositoTotal;
    private final int numCiudades;
    private final double[] distancias;

    public CarFueling(double kmsTotales, double depositoTotal, int numCiudades, double[] distancias) {
        this.kmsTotales = kmsTotales;
        this.depositoTotal = depositoTotal;
        this.numCiudades = numCiudades;
        this.distancias = distancias.clone();
    }

    public long obtenerMinimoRepostajes() {
        double depositoActual = depositoTotal;
        double kmsRecorridos = 0;
        int indCiudadActual = 0;
        int indCiudadMaxTemp = 0;
        long numRepostajes = 0;
        while(indCiudadActual < numCiudades) {

            while (indCiudadMaxTemp < numCiudades-1 && depositoActual >= distancias[indCiudadMaxTemp] - kmsRecorridos) {
                depositoActual -= distancias[indCiudadMaxTemp] - kmsRecorridos;
                kmsRecorridos = distancias[indCiudadMaxTemp];
                // Actualizamos la variable del bucle while
                indCiudadMaxTemp++;
            }
            // Si no podemos llegar a la siguiente ciudad (con el depósito lleno en esta casuística) devolvemos -1
            if (indCiudadMaxTemp == numCiudades) {
                if (depositoTotal < kmsTotales - distancias[numCiudades-1]) {
                    return -1;
                }
            }
            else if (depositoTotal < distancias[indCiudadMaxTemp] - distancias[indCiudadMaxTemp-1]) {
                return -1;
            }
            if (indCiudadMaxTemp == numCiudades-1) {

                if (depositoActual >= distancias[indCiudadMaxTemp] - kmsRecorridos) {
                    depositoActual -= distancias[indCiudadMaxTemp] - kmsRecorridos;
                    kmsRecorridos = distancias[indCiudadMaxTemp];
                    // indCiudadMaxTemp++;
                }
            }
            else if (depositoActual <= distancias[indCiudadMaxTemp] - distancias[indCiudadMaxTemp-1]){
                depositoActual = depositoTotal;
                numRepostajes++;
            }
            indCiudadActual++;
        }
        // Si el depósito actual (que aquí es igual que total) es menor que lo que queda
        if (depositoTotal < (kmsTotales - distancias[numCiudades-1])) {
            return -1;
        } // Si depositoTotal >= distancia
        else if (depositoActual < kmsTotales - distancias[numCiudades-1]) {
            numRepostajes++;
        }
        return numRepostajes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double kmsTotales = scanner.nextDouble();
        double depositoTotal = scanner.nextDouble();
        int numCiudades = scanner.nextInt();
        double[] distancias = new double[numCiudades];
        for(int i=0; i < numCiudades; i++) {
            distancias[i] = scanner.nextDouble();
        }

        System.out.println(new CarFueling(kmsTotales,depositoTotal,numCiudades,distancias).obtenerMinimoRepostajes());
    }
}
