import java.util.ArrayList;

public class Sistema {
    private ArrayList<Aluno> alunos;
    private ArrayList<Admin> adms;
    private ArrayList<Produto> prods;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Sala> salas;

    public Sistema() {
        this.alunos = new ArrayList<>();
        this.adms = new ArrayList<>();
    }

    // Métodos de adição

    public void addAdmin(Admin a) {
        this.adms.add(a);
    }

    public void addAluno(Aluno a) {
        this.alunos.add(a);
    }

    public void addProd(Produto p) {
        this.prods.add(p);
    }

    public void addPedido(Pedido p) {
        this.pedidos.add(p);
    }

    public void addSala(Sala s) {
        this.salas.add(s);
    }

    // Métodos de verificação

    public boolean sistemaVazio() {
        return this.adms.size() == 0;
    }

    // Métodos de buscar elementos

    public Aluno getAluno(String cpf) {
        for(Aluno a : this.alunos) {
            if (cpf.equals(a.getCPF())) return a;
        }

        return null;
    }

    public Admin getAdmin(String cpf) {
        for(Admin a : this.adms) {
            if (cpf.equals(a.getCPF())) return a;
        }

        return null;
    }

    public Produto getProduto(String cod) {
        for(Produto p : this.prods) {
            if (cod.equals(p.getCod())) {
                return p;
            }
        }
        return null;
    }

    public Sala getSala(String id) {
        for(Sala s : this.salas) {
            if (id.equals(s.getID())) {
                return s;
            }
        }
        return null;
    }

    public Pedido getPedido(String cod) {
        for(Pedido p : this.pedidos) {
            if (cod.equals(p.getCod())) {
                return p;
            }
        }
        return null;
    }

    // Métodos de buscar listas

    public ArrayList<Produto> getProdutos() {
        return this.prods;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public ArrayList<Sala> getSalas() {
        return this.salas;
    }

}
