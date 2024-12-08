public class Item {
    private Produto prod;
    private int qtd_prod;

    public Item(Produto p, int qtd_p) {
        this.prod = p;
        this.qtd_prod = qtd_p;
    }

    // Getters:
    public Produto getProd() {
        return this.prod;
    }

    public int getQtd_prod() {
        return this.qtd_prod;
    }

    // Formata para exibição:
    public String toString() {
        return this.prod.toString() + " (QTD: " + this.qtd_prod + ")"; 
    }

    // Calcula o valor total do item:
    public double valorTotal() {
        return this.prod.getValor() * this.qtd_prod;
    }
}
