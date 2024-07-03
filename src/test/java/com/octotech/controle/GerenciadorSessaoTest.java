package com.octotech.controle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Empresa;
import org.junit.Before;
import org.junit.Test;

public class GerenciadorSessaoTest {
    private Desenvolvedor desenvolvedor;
    private Empresa empresa;

    @Before
    public void setUp() {
        desenvolvedor = new Desenvolvedor("Fulano", "12345678900", "123456");
        empresa = new Empresa("Empresa", "1234567890001", "123456");
    }

    @Test
    public void singletonInstanciaNaoNula() {
        assertNotNull(GerenciadorSessao.getInstancia());
    }

    @Test
    public void singletonInstanciaUnica() {
        GerenciadorSessao primeiraInstancia = GerenciadorSessao.getInstancia();
        GerenciadorSessao segundaInstancia = GerenciadorSessao.getInstancia();
        assertSame(primeiraInstancia, segundaInstancia);
    }

    @Test
    public void desenvolvedorLogadoCorretamente() {
        GerenciadorSessao gerenciador = GerenciadorSessao.getInstancia();
        gerenciador.setUsuarioLogado(desenvolvedor);
        assertSame(desenvolvedor, gerenciador.getUsuarioLogado());
    }

    @Test
    public void usuarioLogadoIsReset() {
        GerenciadorSessao gerenciador = GerenciadorSessao.getInstancia();
        gerenciador.setUsuarioLogado(desenvolvedor);
        gerenciador.deslogar();
        assertSame(null, gerenciador.getUsuarioLogado());
    }
}
