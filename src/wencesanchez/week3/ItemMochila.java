package wencesanchez.week3;

public class ItemMochila implements Comparable<ItemMochila> {
    private double valor;
    private double peso;

    public ItemMochila(double valor, double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    @Override
    public int compareTo(ItemMochila o) {
        // Si this < o, devolver negativo
        // 10 < 20 ---> 10 - 20 = negativo.
        if ((this.valor / this.peso) < (o.valor / o.peso)) {
            return -1;
        }
        if ((this.valor / this.peso) > (o.valor / o.peso)) {
            return 1;
        }
        return 0;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
