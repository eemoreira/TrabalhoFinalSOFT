package com.octotech.controle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.octotech.controle.UsuarioDAO;
import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDAOTest {

    private Desenvolvedor desenvolvedor;

    @Before
    public void setUp() {
        desenvolvedor = new Desenvolvedor("Desenvolvedor Teste", "99999999999", "senha123");
        UsuarioDAO.getInstancia().cadastrar(desenvolvedor);
    }

    @Test
    public void singletonInstanciaNaoNula() {
        assertNotNull(UsuarioDAO.getInstancia());
    }

    @Test
    public void logarComCredenciaisCorretasRetornaUsuario() {
        Usuario usuarioLogado = UsuarioDAO.getInstancia().logar("99999999999", "senha123");
        assertNotNull(usuarioLogado);
        assertEquals("Desenvolvedor Teste", usuarioLogado.getNome());
    }

    @Test
    public void logarComCredenciaisIncorretasRetornaNull() {
        Usuario usuarioLogado = UsuarioDAO.getInstancia().logar("99999999999", "senhaIncorreta");
        assertNull(usuarioLogado);
    }

    @Test
    public void cadastrarIncrementaIdEAdicionaUsuario() {
        Desenvolvedor novoDesenvolvedor = new Desenvolvedor("Novo Dev", "88888888888", "senhaNova");
        UsuarioDAO.getInstancia().cadastrar(novoDesenvolvedor);
        assertNotNull(novoDesenvolvedor.getId());
        assertEquals("Novo Dev", UsuarioDAO.getInstancia().getUsuario(novoDesenvolvedor.getId()).getNome());
    }

    @Test
    public void listarDesenvolvedoresRetornaListaCorreta() {
        Desenvolvedor outroDesenvolvedor = new Desenvolvedor("Outro Dev", "77777777777", "senhaOutro");
        UsuarioDAO.getInstancia().cadastrar(outroDesenvolvedor);
        assertTrue(UsuarioDAO.getInstancia().listarDesenvolvedores().contains(desenvolvedor));
        assertTrue(UsuarioDAO.getInstancia().listarDesenvolvedores().size() >= 2);
    }

    @Test
    public void buscarDesenvolvedorPorIdComIdValidoRetornaDesenvolvedor() {
        Desenvolvedor encontrado = UsuarioDAO.getInstancia().buscarDesenvolvedorPorId(desenvolvedor.getId());
        assertNotNull(encontrado);
        assertEquals("Desenvolvedor Teste", encontrado.getNome());
    }

    @Test
    public void buscarDesenvolvedorPorIdComIdInvalidoRetornaNull() {
        Desenvolvedor naoEncontrado = UsuarioDAO.getInstancia().buscarDesenvolvedorPorId(0);
        assertNull(naoEncontrado);
    }
}