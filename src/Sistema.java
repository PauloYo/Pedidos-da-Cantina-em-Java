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
        this.prods = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    // Métodos para adicionar elementos:

    public void addAdmin(Admin adm) {
        this.adms.add(adm);
    }

    public void addAluno(Aluno aln) {
        this.alunos.add(aln);
    }

    public void addProd(Produto prd) {
        this.prods.add(prd);
    }

    public void addPedido(Pedido ped) {
        this.pedidos.add(ped);
    }

    public void addSala(Sala sal) {
        this.salas.add(sal);
    }

    // Getters:

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
            if (id.equals(s.getBloco() + s.getNumero() + s.getAndar())) {
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

    // Verifica se o sistema acabou de inicializar (sem adms):

    public boolean sistemaVazio() {
        return this.adms.size() == 0;
    }

    // Métodos para gerar códigos únicos:

    public String gerarCodigoProduto() {
        return "PROD-" + (this.prods.size() + 1);
    }

    public String gerarCodigoPedido() {
        return "PEDIDO-" + (this.pedidos.size() + 1);
    }

    // Métodos de listar os elementos:

    public void listarProdutos() {
        for(Produto p : this.prods) {
            System.out.println(p);
        }
    }

    public void listarSalas() {
        for(Sala s : this.salas) {
            System.out.println(s);
        }
    }

    // Métodos para filtrar elementos:

    public ArrayList<Pedido> filtrarPedidos(boolean disponivel) {
        ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();
        for(Pedido p : this.pedidos) {
            if (p.disponivel() == disponivel) {
                pedidosFiltrados.add(p);
            }
        }

        return pedidosFiltrados;
    }

    public ArrayList<Pedido> filtrarPedidos(Aluno aln) {
        ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();
        for(Pedido p : this.pedidos) {
            if (p.getCliente().equals(aln)) {
                pedidosFiltrados.add(p);
            }
        }

        return pedidosFiltrados;
    }
}
