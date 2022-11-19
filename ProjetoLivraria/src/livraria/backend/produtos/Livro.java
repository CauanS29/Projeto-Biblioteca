package livraria.backend.produtos;

import livraria.backend.Autor;

public abstract class Livro implements Cloneable {
    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    private String isbn;
    private Autor autor;
    private boolean impresso;
    private boolean mini;

    public Livro(Autor autor) {
        this.quantidade = 1;
        this.autor = autor;
        this.impresso = true;
        this.mini = false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean isMini(){
        return mini;
    }

    public void setMini(boolean mini){
        this.mini = mini;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getValorString() {
        return String.valueOf(this.getValor());
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getQuantidadeString() {
        return String.valueOf(this.getQuantidade());
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            this.quantidade = 1;
        } else {
            this.quantidade = quantidade;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isImpresso() {
        return impresso;
    }

    public void setImpresso(boolean impresso) {
        this.impresso = impresso;
    }
}
