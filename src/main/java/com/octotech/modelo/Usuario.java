package com.octotech.modelo;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected double saldo;

    public void login() {
        System.out.println("Usuário logado: " + email);
    }

    public void logout() {
        System.out.println("Usuário deslogado: " + email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
