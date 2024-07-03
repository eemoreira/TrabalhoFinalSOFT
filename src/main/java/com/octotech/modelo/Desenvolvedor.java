package com.octotech.modelo;

public class Desenvolvedor extends Usuario {
    private String cpf;

    public Desenvolvedor(String nome, String cpf, String senha) {
        super(nome, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        return "ID: " + super.id + " - Nome: " + super.nome + " - CPF: " + cpf;
    }

}

