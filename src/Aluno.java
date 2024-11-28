public class Aluno extends Usuario{
    private double saldo;

    public Aluno(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
        this.saldo = 0;
    }

    public String toString() {
        return super.toString() + " (Saldo: R$" + String.format("%.2f", this.saldo) + ")";
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
}
