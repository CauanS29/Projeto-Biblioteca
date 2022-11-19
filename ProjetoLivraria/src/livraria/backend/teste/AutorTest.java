package livraria.backend.teste;

import livraria.backend.Autor;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutorTest {

    @Test
    public void getNome(){
        Autor autor = new Autor();
        autor.setNome("Mauricio Aniche");

        assertEquals("Mauricio Aniche", autor.getNome());
    }

}