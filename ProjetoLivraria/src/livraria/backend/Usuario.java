package livraria.backend;

public class Usuario {
    private Boolean permissao;
    private CarrinhoDeCompras carrinho;

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public Usuario(Boolean permissao) {
        this.permissao = permissao;
        this.carrinho = new CarrinhoDeCompras();
    }

    public Boolean getPermissao() {
        return this.permissao;
    }
}