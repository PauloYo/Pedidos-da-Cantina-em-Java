import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e <seu nome aqui>
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in).useLocale(Locale.US);
        }
    }



    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        while (true) {
            try {
                // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
                String linha = this.lerLinha(msg);
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido por favor.");
            }
        }
    }

    /**
     * Faz a leitura de um ponto flutuante
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        while (true){
            try{
                // Imprime uma mensagem ao usuário, lê uma linha contendo um ponto flutuante e retorna este número
                String linha = this.lerLinha(msg);
                return Double.parseDouble(linha);
            }
            catch (NumberFormatException e){
                System.out.println("Entrada inválida! Digite um número double válido.");
            }
        }
    }

    /**********************/
    /** MENUS DO SISTEMA **/
    /**********************/

    /**
     * Exibe o menu principal até que o usuário opte por sair do programa.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Sistema s) {
        lerDados(s);

        if (s.sistemaVazio()) {
            System.out.println("** Inicializando o sistema **");
            this.cadAdmin(s);
        }

        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Login.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) login(s);
            else System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }

        salvarDados(s);

        System.out.println("\nSistema encerrado.\n");

    }

    /**
     * Exibe o menu do administrador até que o usuário deslogue.
     * @param a: Objeto a classe Admin.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Admin a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar novo administrador.\n" +
                "2) Cadastrar aluno.\n" +
                "3) Cadastrar produto.\n" +
                "4) Cadastrar sala.\n" +
                "0) Logout.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) {
                cadAdmin(s);
                }
            if (op == 2) {
                cadAluno(s);
                }
            if (op == 3) {
                cadProduto(s);
                }
            if (op == 4) {
                cadSala(s);
                }
            if (op < 0 || op > 4) {
                System.out.println("Opção inválida. Tente novamente: ");
                }

            op = this.lerInteiro(msg);
        }
    }

    /**
     * Exibe o menu do aluno até que o usuário deslogue.
     * @param a: Objeto a classe Aluno.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Aluno a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Fazer pedido.\n" +
                "2) Fazer entrega.\n" +
                "3) Meus pedidos.\n" +
                "4) Inserir crédito.\n" +
                "0) Logout.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) {
                fazerPedido(a, s);
                }
            if (op == 2) {
                entregarPedido(a, s);
                }
            if (op == 3) {
                meusPedidos(a, s);
                }
            if (op == 4) {
                inserirCredito(a, s);
                }
            if (op < 0 || op > 4) {
                System.out.println("Opção inválida. Tente novamente: ");
                }

            op = this.lerInteiro(msg);
        }
    }

    /**
     * Realiza o login de um usuário no sistema.
     * @param s: Um objeto da classe Sistema.
     */
    public void login(Sistema s) {
        System.out.println("\nBem vindo! Digite seus dados de login:");
        String cpf = this.lerLinha("CPF:");
        String senha = this.lerLinha("\nSenha:");

        Admin adm = s.getAdmin(cpf);
        if (adm != null) {
            if (adm.validarAcesso(senha)) {
                this.menu(adm, s);
            }
            else System.out.println("\nSenha inválida.");
        }
        else {
            Aluno a = s.getAluno(cpf);
            if (a != null) {
                if (a.validarAcesso(senha)) {
                    this.menu(a, s);
                }
                else System.out.println("\nSenha inválida");
            }
            else {
                System.out.println("\nUsuário inexistente");
            }
        }
    }

    /***************/
    /** CADASTROS **/
    /***************/

    /**
     * Lê os dados de um novo administrador e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAdmin(Sistema s) {
        System.out.println("\n** Cadastrando um novo administrador **\n");
        String cpf = this.lerLinha("Digite o cpf: ");

        while (s.getAdmin(cpf) != null) {
            cpf = this.lerLinha("\nUsuário já existente. Escolha outro cpf: ");
        }

        String nome = this.lerLinha("\nDigite o nome: ");
        String senha = this.lerLinha("\nDigite a senha: ");
        String email = this.lerLinha("\nDigite o email: ");

        Admin a = new Admin(cpf, nome, senha, email);
        s.addAdmin(a);

        System.out.println("\nUsuário " + a + " criado com sucesso.");
    }

    /**
     * Lê os dados de um novo aluno e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAluno(Sistema s) {
        System.out.println("\n** Cadastrando um novo aluno **\n");
        String cpf = this.lerLinha("Digite o cpf: ");

        while (s.getAluno(cpf) != null) {
            cpf = this.lerLinha("\nUsuário já existente. Escolha outro cpf: ");
        }

        String nome = this.lerLinha("\nDigite o nome: ");
        String senha = this.lerLinha("\nDigite a senha: ");

        Aluno a = new Aluno(cpf, nome, senha);
        s.addAluno(a);

        System.out.println("\nUsuário " + a + " criado com sucesso.");
    }

    /**
     * Lê os dados de um novo produto e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadProduto(Sistema s) {
        System.out.println("\n** Cadastrando um novo produto **\n");
        String nome = this.lerLinha("Digite o nome do produto: ");
        int estoque = this.lerInteiro("\nDigite a quantidade no estoque: ");
        double valor = this.lerDouble("\nDigite o preço do produto: ");

        String id = s.gerarCodigoProduto();

        Produto p = new Produto(nome, id, estoque, valor);
        s.addProd(p);

        System.out.println("\nProduto " + p + " criado com sucesso.");
    }

    /**
     * Lê os dados de uma nova sala e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadSala(Sistema s) {
        System.out.println("\n** Cadastrando uma nova sala **\n");
        String bloco = this.lerLinha("Digite o bloco da sala: ");
        String num = this.lerLinha("\nDigite o número da sala: ");
        String andar = this.lerLinha("\nDigite o andar da sala (S/T): ");

        Sala sala = new Sala(num, bloco, andar);
        s.addSala(sala);

        System.out.println("\nSala " + sala.toString() + " criada com sucesso.");
    }

    /***************************/
    /** FUNCIONALIDADES ALUNO **/
    /***************************/

    /**
     * Realiza um pedido de produtos por parte de um aluno.
     * @param a: Objeto da classe Aluno.
     * @param s: Objeto da classe Sistema.
     */
    public void fazerPedido(Aluno a, Sistema s) {
        System.out.println("\n** Fazendo um novo pedido **");
        
        String cod = s.gerarCodigoPedido();
        Pedido p = new Pedido(cod, a);
        
        Sala sala = lerSala(s);

        if (sala == null) {
            System.out.println("\nSala não encontrada.");
        } else {
            p.setSala(sala);

            int op;
            do {
                System.out.println("\n*********************\nEscolha uma opção:\n1) Inserir produto no carrinho.\n2) Fechar pedido.");
                op = this.lerInteiro(": ");
                
                if (op == 1) {
                    Item item = lerItem(s);
                    if (item != null) {
                        p.getCarrinho().add(item);
                    }
                } else if (op != 2) {
                    System.out.println("\nOpção inválida. Tente novamente.");
                }
            } while (op != 2);
            
            if (p.getCarrinho().size() == 0) {
                System.out.println("\nPedido vazio. Cancelando pedido.");
            } else {
                if (a.getSaldo() < p.valorTotal()) {
                    System.out.println("\nSaldo insuficiente. Cancelando pedido.");
                } else {
                    p.confirmar();
                    s.addPedido(p);
                }
            }
        }

        p.getCarrinho().sort(Comparator.comparing(Item::getQtd_prod).reversed()
                .thenComparing(item -> item.getProd().getValor(), Comparator.reverseOrder()));
    }

    /**
     * Lê uma sala disponível no sistema.
     * @param s: Objeto da classe Sistema.
     * @return Objeto da classe Sala.
     */
    private Sala lerSala(Sistema s) {
        System.out.println("\nSalas disponíveis:");
        s.listarSalas();

        String escolha = this.lerLinha("Digite a sala: ");
        Sala sala = s.getSala(escolha);

        return sala;
    }

    /**
     * Lê um item disponível no sistema.
     * @param s: Objeto da classe Sistema.
     * @return Objeto da classe Item.
     */
    private Item lerItem(Sistema s) {
        System.out.println("\nProdutos disponíveis:");
        s.listarProdutos();
        
        String id = this.lerLinha("Digite o id do produto: ");                    
        Produto prd = s.getProduto(id);

        if (prd == null) {
            System.out.println("\nProduto não encontrado.");
        } else {
            int qtd = this.lerInteiro("\nDigite a quantidade: ");
            while (qtd > prd.getEstoque()) {
                System.out.println("\n\nEstoque insuficiente. (Quantidade disponível: " + prd.getEstoque() + ")");
                qtd = this.lerInteiro("Digite novamente a quantidade: ");
            }
            Item i = new Item(prd, qtd);
            return i;
        }
        
        return null;
    }

    /**
     * Entrega um pedido feito por um aluno.
     * @param a: Objeto da classe Aluno.
     * @param s: Objeto da classe Sistema.
     */
    public void entregarPedido(Aluno a, Sistema s) {
        System.out.println("\n** Fazendo uma entrega de pedido **\n");
        
        System.out.println("\nPedidos disponíveis:");
        for (Pedido ped : s.filtrarPedidos(true)) {
            System.out.println(ped.toString());
        }

        String id = this.lerLinha("Digite a id do pedido a ser entregue: ");

        Pedido ped = s.getPedido(id);
        if (ped != null) {
            ped.atribuirEntregador(a);
            ped.marcarComoEntregue();
            System.out.println("\nPedido atribuído com sucesso!\nVocê receberá 80% da taxa de entrega.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
        
    }

    public void meusPedidos(Aluno a, Sistema s){

        ArrayList<Pedido> pedidosFiltrados = s.filtrarPedidos(a);

        pedidosFiltrados.sort(
            Comparator.comparing((Pedido p) -> p.getCarrinho().size()).reversed()
                    .thenComparing(Pedido::valorTotal, Comparator.reverseOrder())
        );
        
        System.out.println("\nPedidos de " + a.toString() + ":");
        for (Pedido ped : pedidosFiltrados) {
            System.out.println(ped.toString());
        }
    }

    public void inserirCredito(Aluno a, Sistema s){
        double valor = this.lerDouble("\nDigite um valor de credito a ser inserido ao seu saldo: ");
        a.inserirSaldo(valor);
    }

    private void lerDados(Sistema s) {
        try {
            FileReader f = new FileReader("dados.txt");
            BufferedReader b = new BufferedReader(f);

            while (true) {
                String linha = b.readLine();
                if (linha.equals("ADM")) {
                    String cpf = b.readLine();
                    String nome = b.readLine();
                    String senha = b.readLine();
                    String email = b.readLine();
                    Admin a = new Admin(cpf, nome, senha, email);
                    s.addAdmin(a);
                } else if (linha.equals("ALU")) {
                    String cpf = b.readLine();
                    String nome = b.readLine();
                    String senha = b.readLine();
                    Aluno a = new Aluno(cpf, nome, senha);
                    s.addAluno(a);
                } else {
                    break;
                }
            }
            b.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler o arquivo.");
        } catch (IOException e) {
            System.out.println("Deu ruim em outro bagui.");
        }
    }

    private void salvarDados(Sistema s) {
        try {
            FileWriter f = new FileWriter("dados.txt");
            BufferedWriter b = new BufferedWriter(f);

            for (Admin a : s.getAllAdmins()) {
                a.salvarArq(b);
            }

            for (Aluno a : s.getAllAlunos()) {
                a.salvarArq(b);
            }

            b.write("FIM\n");

            b.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo.");
        }
        System.out.println("Dados salvos com sucesso.");
        
    }

}