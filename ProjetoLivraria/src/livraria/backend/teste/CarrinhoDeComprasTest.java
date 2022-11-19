package livraria.backend.teste;

import livraria.backend.Autor;
import livraria.backend.CarrinhoDeCompras;
import livraria.backend.produtos.LivroFisico;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarrinhoDeComprasTest {

    @Test
    public void getPrecoTotal(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setValor(36.5);
        CarrinhoDeCompras produtos = new CarrinhoDeCompras();
        produtos.adicionaLivro("Javinha",fisico);


        assertEquals(36.5,produtos.getPrecoTotal(),0);
    }

    @Test
    public void getQtdProdutos(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setValor(36.5);
        fisico.setQuantidade(5);
        CarrinhoDeCompras produtos = new CarrinhoDeCompras();
        produtos.adicionaLivro("Javinha",fisico);

        assertEquals(5,produtos.getQtdProdutos());
    }

}