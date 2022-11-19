package livraria.backend.teste;

import livraria.backend.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {
    @Test
    public void getPermissao(){
        Usuario usuario = new Usuario(true);
        assertEquals(true, usuario.getPermissao());
    }
}
