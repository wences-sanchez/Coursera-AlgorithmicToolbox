package wencesanchez.week3;

import java.util.Scanner;

public class CarFueling {

    private double _kmsTotales;
    private double _depositoTotal;
    private int _numCiudades;
    private double[] _distancias;

    public CarFueling() {}

    public CarFueling(double kmsTotales, double depositoTotal, int numCiudades, double[] distancias) {
        this._kmsTotales = kmsTotales;
        this._depositoTotal = depositoTotal;
        this._numCiudades = numCiudades;
        this._distancias = new double[numCiudades+2];
        this._distancias[0] = 0;
        for(int i=1; i < numCiudades; i++) {
            this._distancias[i+1] = distancias[i];
        }
        this._distancias[numCiudades] = kmsTotales;
    }

    public long obtenerMinimoRepostajes(int[] distancias, long numCiudades, double depositoTotal) {
        int indCiudadActual = 0;
        long numRepostajes = 0;
        while(indCiudadActual <= numCiudades) {
            int indUltimaCiudad = indCiudadActual;
            while (indCiudadActual <= numCiudades
                    && depositoTotal >= distancias[indCiudadActual+1] - distancias[indUltimaCiudad]) {
                indCiudadActual++;
            }
            // Si no podemos llegar a la siguiente ciudad (con el depósito lleno en esta casuística) devolvemos -1
            if (indCiudadActual == indUltimaCiudad) {
                return -1;
            }
            if (indCiudadActual <= numCiudades) {
                numRepostajes++;
            }
        }
        return numRepostajes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kmsTotales = scanner.nextInt();
        double depositoTotal = scanner.nextDouble();
        int numCiudades = scanner.nextInt();
        int[] distancias = new int[numCiudades+2];
        distancias[0] = 0;
        for(int i=1; i <= numCiudades; i++) {
            distancias[i] = scanner.nextInt();
        }
        distancias[numCiudades+1] = kmsTotales;

        System.out.println(new CarFueling().obtenerMinimoRepostajes(distancias,numCiudades,depositoTotal));
    }
}
