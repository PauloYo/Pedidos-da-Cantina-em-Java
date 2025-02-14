public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException() {
        super("\nErro: Produto não encontrado.\n");
    }
}
