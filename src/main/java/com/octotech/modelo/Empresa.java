package com.octotech.modelo;

import java.util.List;

public class Empresa extends Usuario {
    private String cnpj;
    private List<Projeto> projetos;

    public Empresa(String nome, String cnpj, String senha) {
        super(nome, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
