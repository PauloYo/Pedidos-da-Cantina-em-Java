public abstract class Usuario {
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

    public abstract String toString();

    public String getCPF() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    protected String getSenha() {
        return this.senha;
    }
}
