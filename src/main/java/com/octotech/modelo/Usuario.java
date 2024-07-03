package com.octotech.modelo;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfCnpj() {
        if (this instanceof Desenvolvedor) {
            return ((Desenvolvedor) this).getCpf();
        } else {
            return ((Empresa) this).getCnpj();
        }
    }
}
