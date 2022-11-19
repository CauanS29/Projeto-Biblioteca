package livraria.backend;

import java.util.HashMap;
import java.util.Map;

import livraria.backend.produtos.Livro;

public abstract class EstoqueDeLivro {
    private static Map<String, Livro> livros = new HashMap<>(0);

    public static void adicionaLivro(String nome, Livro livro) {
        livros.put(nome, livro);
    }

    public static void removeLivro(String nome, int quantidade) {
        if (livros.containsKey(nome)) {
            Livro livro = EstoqueDeLivro.achaLivro(nome);
            if (quantidade >= EstoqueDeLivro.achaLivro(nome).getQuantidade()) {
                livros.remove(nome);
            } else {
                livro.setQuantidade(livro.getQuantidade() - quantidade);
                livros.replace(nome, livro);
            }
        }
    }

    public static void adicionaQtdLivros(String nome, int quantidade) {
        Livro livro = achaLivro(nome);
        livro.setQuantidade(livro.getQuantidade() + quantidade);
        livros.replace(nome, livro);
    }

    public static void alteraLivro(String nome, Livro livroNovo) {
        livros.replace(nome, livroNovo);
    }

    public static Livro achaLivro(String nome) {
        return livros.get(nome);
    }
}
