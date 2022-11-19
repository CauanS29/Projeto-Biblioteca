package livraria.backend.produtos;

import livraria.backend.Autor;

public class MiniLivro extends Livro {
    public MiniLivro(Autor autor) {
        super(autor);
        this.setMini(true);
    }
}
