public class Sala {
    private String numero, bloco, andar;

    public Sala(String n, String b, String a) {
        this.numero = n;
        this.bloco = b;
        this.andar = a;
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

    public String toString() {
        return this.bloco + this.numero + this.andar;
    }
}
