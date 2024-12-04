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

    public boolean sistemaVazio() {
        return this.adms.size() == 0;
    }

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

    public ArrayList<Produto> getProdutos() {
        return this.prods;
    }

}
