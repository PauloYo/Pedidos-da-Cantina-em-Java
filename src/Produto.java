public class Produto {
    private String nome, id;
    private int estoque;
    private double valor;

    public Produto(String n, String i, int q, double v) {
        this.nome = n;
        this.id = i;
        this.estoque = q;
        this.valor = v;
    }
 
    public String getID() {
        return this.id;
    }

    // public String getNome() {
    //     return nome;
    // }

    // public int getQtd() {
    //     return estoque;
    // }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return this.id + ": " + this.nome;
    }


//falta aplicar esse em algum lugar
    public void retirarDeEstoque(int q) {
        if (q > this.estoque) {
            System.out.println("Estoque insuficiente.");
        } else {
            this.estoque -= q;
        }
    }
}
