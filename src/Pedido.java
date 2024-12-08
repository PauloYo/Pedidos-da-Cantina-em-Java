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

    // Getters:
    public Aluno getCliente(){
        return this.cliente;
    }

    public String getCod() {
        return this.cod;
    }

    public ArrayList<Item> getCarrinho() {
        return this.carrinho;
    }

    // Setters:
    public void setSala(Sala s) {
        this.sal = s;
    }	

    // Formata para exibição:
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

    // Calcula o valor total do pedido:
    public double valorTotal() {
        double total = 0.00;
        for (Item i : carrinho) {
            total += i.valorTotal();
        }
        total += 1.00; // Taxa de entrega fixa
        return total;
    }

    // Atribui um entregador ao pedido:
    public void atribuirEntregador(Aluno a) {
        this.entregador = a;
    }

    // Verifica se o pedido está disponível:
    public boolean disponivel() {
        return !this.entregue;
    }

    // Entrega o pedido:
    public void marcarComoEntregue() {
        this.entregue = true;
        this.entregador.inserirSaldo(0.80); // 80% da taxa de entrega vai para o entregador
    }

    // Confirma o pedido:
    public void confirmar() {
        this.cliente.retirarSaldo(valorTotal());
        for (Item i : carrinho) {
            i.getProd().retirarDeEstoque(i.getQtd_prod());
        }
    }
}
