import java.io.BufferedWriter;
import java.io.IOException;

public class Admin extends Usuario implements Salvavel {
    private String email;

    public Admin(String cpf, String nome, String senha, String email) {
        super(cpf, nome, senha);
        this.email = email;
    }

    public String toString() {
        return super.toString() + " (ADMIN)";
    }

    public void salvarArq(BufferedWriter bw) throws IOException {
        bw.write("ADM\n");
        bw.write(this.cpf + "\n");
        bw.write(this.nome + "\n");
        bw.write(this.getSenha() + "\n");
        bw.write(this.email + "\n");
    }
}
