package com.octotech.controle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.octotech.controle.ProjetoDAO;
import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Empresa;
import com.octotech.modelo.Projeto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProjetoDAOTest {

    private ProjetoDAO projetoDAO;
    private Desenvolvedor desenvolvedor;
    private Empresa empresa;
    private Projeto projeto;

    @Before
    public void setUp() {
        projetoDAO = ProjetoDAO.getInstancia();
        desenvolvedor = new Desenvolvedor("Desenvolvedor Teste", "99999999999", "senha123");
        empresa = new Empresa("Empresa Teste", "1234567890001", "senhaEmpresa");
        projeto = new Projeto("Projeto Teste", "Descricao do projeto teste", empresa);
        projeto.setDesenvolvedor(desenvolvedor);
        projeto.setEmpresa(empresa);
        projetoDAO.cadastrar(projeto);
    }

    @Test
    public void singletonInstanceIsNotNull() {
        assertNotNull(ProjetoDAO.getInstancia());
    }

    @Test
    public void adicionaCandidatoAoProjeto() {
        Desenvolvedor novoDesenvolvedor = new Desenvolvedor("Novo Dev", "88888888888", "senhaNova");
        projetoDAO.adicionaCandidato(projeto, novoDesenvolvedor);
        assertTrue(projeto.getCandidatos().contains(novoDesenvolvedor));
    }

    @Test
    public void listarProjetosRetornaListaNaoVazia() {
        List<Projeto> projetos = projetoDAO.listar();
        assertNotNull(projetos);
        assertFalse(projetos.isEmpty());
    }

    @Test
    public void listarProjetosPorDesenvolvedorRetornaListaCorreta() {
        List<Projeto> projetos = projetoDAO.listarPorDesenvolvedor(desenvolvedor);
        assertNotNull(projetos);
        assertTrue(projetos.stream().allMatch(projeto -> projeto.getDesenvolvedor().equals(desenvolvedor)));
    }

    @Test
    public void buscarProjetoPorIdComIdValidoRetornaProjeto() {
        Projeto encontrado = projetoDAO.buscarPorId(projeto.getId());
        assertNotNull(encontrado);
        assertEquals(projeto.getId(), encontrado.getId());
    }

    @Test
    public void buscarProjetoPorIdComIdInvalidoRetornaNull() {
        Projeto naoEncontrado = projetoDAO.buscarPorId(999);
        assertNull(naoEncontrado);
    }

    @Test
    public void listarProjetosPorEmpresaRetornaListaCorreta() {
        List<Projeto> projetos = projetoDAO.listarPorEmpresa(empresa);
        assertNotNull(projetos);
        assertTrue(projetos.stream().allMatch(projeto -> projeto.getEmpresa().equals(empresa)));
    }

    @Test
    public void cadastrarProjetoIncrementaIdEAdicionaProjeto() {
        Projeto novoProjeto = new Projeto("Outro Projeto", "Descricao do outro projeto", empresa);
        novoProjeto.setDesenvolvedor(new Desenvolvedor("Outro Dev", "77777777777", "senhaOutro"));
        novoProjeto.setEmpresa(new Empresa("Outra Empresa", "1234567890002", "senhaOutraEmpresa"));
        projetoDAO.cadastrar(novoProjeto);
        assertNotNull(projetoDAO.buscarPorId(novoProjeto.getId()));
    }
}