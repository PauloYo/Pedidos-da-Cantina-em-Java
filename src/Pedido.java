import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pedido {
    private String cod;
    private Aluno cliente, entregador;
    private Sala sal;
    private ArrayList<Item> carrinho;
    private boolean entregue;

    public Pedido(String cod, Aluno cl) {
        this.cod = cod;
        this.cliente = cl;
        this.entregador = null;
        this.sal = null;
        this.carrinho = new ArrayList<>();
        this.entregue = false;
    }

    // GETs

    public ArrayList<Item> getCarrinho() {
        return carrinho;
    }

    public Aluno getCliente(){
        return this.cliente;
    }

    public String getCod() {
        return this.cod;
    }

    // SETs

    public void setSala(Sala s) {
        this.sal = s;
    }

    // OUTROS

    public String toString() {
        String s = "\nCodigo do Pedido: " + this.cod + "\nProdutos:";
        for (Item i : carrinho) {
            s += "\n" + i.toString();
        }
        s += "\nStatus: ";
        if (this.entregue) s += "Entregue";
        else s += "Aberto";
        s += "\nValor Total: R$" + String.format("%.2f", valorTotal());
        return s;
    }

    public double valorTotal() {
        double total = 0.00;
        for (Item i : carrinho) {
            total += i.valorTotal();
        }
        return total;
    }

    public void atribuirEntregador(Aluno a) {
        this.entregador = a;
    }

    public boolean disponivel() {
        return !this.entregue;
    }

    public void entregue() {
        this.entregue = true;
    }

    public void confirmar() {
        this.cliente.retirarSaldo(valorTotal());
        for (Item i : carrinho) {
            i.getProd().retirarDeEstoque(i.getQtd_prod());
        }
    }
}
