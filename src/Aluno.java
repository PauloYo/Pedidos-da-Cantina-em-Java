import java.io.BufferedWriter;
import java.io.IOException;

public class Aluno extends Usuario implements Salvavel {
    private double saldo;

    public Aluno(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String toString() {
        return this.nome + " - CPF: " + this.cpf + " (Saldo: R$" + String.format("%.2f", this.saldo) + ")";
    }

    public void inserirSaldo(double valor) {
        this.saldo += valor;
    }

    public boolean retirarSaldo(double valor) {
        if (this.saldo < valor){
            return false;
        }
        else {
            this.saldo -= valor;
            return true;
        }
    }

    public void salvarArq(BufferedWriter bw) throws IOException {
        bw.write("ALU\n");
        bw.write(this.cpf + "\n");
        bw.write(this.nome + "\n");
        bw.write(this.getSenha() + "\n");
    }
}
