public class Produto {
    private String nome, cod;
    private int estoque;
    private double valor;

    public Produto(String n, String c, int q, double v) {
        this.nome = n;
        this.cod = c;
        this.estoque = q;
        this.valor = v;
    }
 
    public String getCod() {
        return this.cod;
    }

    // public String getNome() {
    //     return nome;
    // }

    public int getEstoque() {
        return estoque;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return this.cod + ": " + this.nome;
    }

    public void retirarDeEstoque(int q) {
        if (q > this.estoque) {
            System.out.println("Estoque insuficiente.");
        } else {
            this.estoque -= q;
        }
    }
}
