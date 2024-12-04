public class Sala {
    private String id, bloco, andar, sala;
    private int capacidade;

    public Sala(String i, String b, String a, String s, int c) {
        this.id = i;
        this.bloco = b;
        this.andar = a;
        this.sala = s;
        this.capacidade = c;
    }

    public String getID() {
        return this.id;
    }

    public String getBloco() {
        return this.bloco;
    }

    public String getSala() {
        return this.sala;
    }

    public String getAndar() {
        return this.andar;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

}
