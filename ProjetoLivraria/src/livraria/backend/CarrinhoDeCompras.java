package livraria.backend;

import java.util.HashMap;
import java.util.Map;

import livraria.backend.produtos.Livro;

public class CarrinhoDeCompras {
    private double precoTotal;
    private int qtdTotal;
    private Map<String, Livro> produtos;

    public CarrinhoDeCompras() {
        this.produtos = new HashMap<>(0);
    }

    public void adicionaQtdLivros(String nome, int quantidade) {
        Livro livro = achaLivro(nome);
        livro.setQuantidade(livro.getQuantidade() + quantidade);
        produtos.replace(nome, livro);
    }

    public void adicionaLivro(String nome, Livro livro) {
        produtos.put(nome, livro);
    }

    public Livro achaLivro(String nome) {
        return produtos.get(nome);
    }

    public void removeLivro(String nome, int quantidade) {
        Livro livro = achaLivro(nome);
        if (quantidade >= achaLivro(nome).getQuantidade()) {
            produtos.remove(nome);
        } else {
            livro.setQuantidade(livro.getQuantidade() - quantidade);
            produtos.replace(nome, livro);
        }
    }

    public double getPrecoTotal() {
        this.precoTotal = 0;
        produtos.forEach((nome, livro) -> {
            this.precoTotal += livro.getQuantidade() * livro.getValor();
        });
        return this.precoTotal;
    }

    public int getQtdProdutos() {
        this.qtdTotal = 0;
        produtos.forEach((nome, livro) -> {
            this.qtdTotal += livro.getQuantidade();
        });
        return this.qtdTotal;
    }

    public void finalizarCompra(){
        this.produtos.clear();
    }
}
