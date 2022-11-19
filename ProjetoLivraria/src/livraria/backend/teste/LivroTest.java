package livraria.backend.teste;

import livraria.backend.Autor;
import livraria.backend.produtos.LivroFisico;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivroTest {

    @Test
    public void getNome(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals("Javinha",fisico.getNome());
    }

    @Test
    public void getDescricao(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals("Fala sobre javinha",fisico.getDescricao());
    }

    @Test
    public void getValor(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals(36.5,fisico.getValor(),0);
    }

    @Test
    public void getValorString(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals("36.5",fisico.getValorString());
    }

    @Test
    public void getQuantidade(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals(1,fisico.getQuantidade());
    }

    @Test
    public void getQuantidadeString(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals("1",fisico.getQuantidadeString());
    }

    @Test
    public void isMini(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals(false,fisico.isMini());
    }

    @Test
    public void isImpresso(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals(true,fisico.isImpresso());
    }

    @Test
    public void getIsbn(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setIsbn("000-000-000");
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals("000-000-000",fisico.getIsbn());
    }

    @Test
    public void getAutor(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setIsbn("000-000-000");
        fisico.setNome("Javinha");
        fisico.setDescricao("Fala sobre javinha");
        fisico.setValor(36.5);

        assertEquals(autor,fisico.getAutor());
    }




}