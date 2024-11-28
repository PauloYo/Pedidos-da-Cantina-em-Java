import java.util.ArrayList;

public class Pedido {
    private String cod;
    private Aluno cliente, entregador;
    private Sala s;
    private ArrayList<Item> carrinho;
    private boolean entregue;

    public Pedido(String cod, Aluno cl, Aluno ent, Sala s) {
        this.cod = cod;
        this.cliente = cl;
        this.entregador = ent;
        this.s = s;
        this.carrinho = new ArrayList<>();
        this. entregue = false;
    }

    public String toString() {
        String s = "Codigo do Pedido: " + this.cod + "\nProdutos:";
        for (Item i : carrinho) {
            s += "\n" + i.toString()
        }
        s += "\nStatus: ";
        if (this.entregue) s += "Entregue";
        else s += "Aberto";
        s += "Valor Total: ";
        return s;
    }

    public double valorTotal() {
        double total = 0;
        for (Item i : carrinho) {
            total += i.valorTotal();
        }
        return total;
    }
    
}
