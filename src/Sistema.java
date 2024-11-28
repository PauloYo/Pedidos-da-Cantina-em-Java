import java.util.ArrayList;

public class Sistema {
    ArrayList<Aluno> alunos;
    ArrayList<Admin> adms;

    public Sistema() {
        this.alunos = new ArrayList<>();
        this.adms = new ArrayList<>();
    }

    public void addAdmin(Admin a) {
        this.adms.add(a);
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

}
