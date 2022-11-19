package livraria.backend.produtos;

import livraria.backend.Autor;

public class Ebook extends Livro {
    public Ebook(Autor autor) {
        super(autor);
        this.setImpresso(false);
    }
}
