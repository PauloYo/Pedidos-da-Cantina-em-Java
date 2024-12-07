public class Sala {
    private String numero, bloco, andar, id;

    public Sala(String n, String b, String a) {
        this.numero = n;
        this.bloco = b;
        this.andar = a;
        this.id = b + n + a;
    }

    public String getBloco() {
        return this.bloco;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getAndar() {
        return this.andar;
    }

    public String getID() {
        return this.id;
    }

    public String toString() {
        return this.id;
    }

}
