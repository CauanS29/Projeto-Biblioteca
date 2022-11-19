package livraria.backend.teste;

import livraria.backend.Autor;
import livraria.backend.EstoqueDeLivro;
import livraria.backend.produtos.LivroFisico;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstoqueDeLivroTest {

    @Test
    public void achaLivro(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");
        LivroFisico fisico = new LivroFisico(autor);
        fisico.setNome("Javinha");
        fisico.setValor(36.5);
        fisico.setQuantidade(5);
        EstoqueDeLivro.adicionaLivro("Javinha",fisico);

        assertEquals(fisico, EstoqueDeLivro.achaLivro("Javinha"));
    }

}