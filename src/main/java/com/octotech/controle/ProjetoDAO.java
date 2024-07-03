package com.octotech.controle;

import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Empresa;
import com.octotech.modelo.Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjetoDAO {
    private static ProjetoDAO instancia;
    HashMap<Integer, Projeto> projetos;

    private ProjetoDAO() {
        projetos = new HashMap<>();
    }

    public static ProjetoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProjetoDAO();
        }
        return instancia;
    }

    public void adicionaCandidato(Projeto projeto, Desenvolvedor desenvolvedor) {
        projeto.addCandidato(desenvolvedor);
    }

    public List<Projeto> listar() {
        ArrayList<Projeto> lista = new ArrayList<>();
        for (Projeto projeto : projetos.values()) {
            lista.add(projeto);
        }
        return lista;
    }

    public List<Projeto> listarPorDesenvolvedor(Desenvolvedor desenvolvedor) {
        ArrayList<Projeto> lista = new ArrayList<>();
        for (Projeto projeto : projetos.values()) {
            if (projeto.getDesenvolvedor() != null && projeto.getDesenvolvedor().equals(desenvolvedor)) {
                lista.add(projeto);
            }
        }
        return lista;
    }

    public Projeto buscarPorId(int id) {
        if (projetos.containsKey(id)) {
            return projetos.get(id);
        }
        return null;
    }

    public List<Projeto> listarPorEmpresa(Empresa empresa) {
        ArrayList<Projeto> lista = new ArrayList<>();
        for (Projeto projeto : projetos.values()) {
            if (projeto.getEmpresa().equals(empresa)) {
                lista.add(projeto);
            }
        }
        return lista;
    }

    public void cadastrar(Projeto projeto) {
        projeto.setId(projetos.size() + 1);
        projetos.put(projeto.getId(), projeto);
    }
}
