public class Usuario {
    protected String cpf, nome;
    private String senha;

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public boolean validarAcesso(String s) {
        return s.equals(this.senha);
    }

    public String toString() {
        return this.nome + " - CPF: " + this.cpf;
    }

    public String getCPF() {
        return this.cpf;
    }
}
