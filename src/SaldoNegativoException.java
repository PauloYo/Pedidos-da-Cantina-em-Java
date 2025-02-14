public class SaldoNegativoException extends Exception {
    public SaldoNegativoException() {
        super("\nErro: Valor do saldo não pode ser negativo.\n");
    }
}
