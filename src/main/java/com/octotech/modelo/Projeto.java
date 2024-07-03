package com.octotech.modelo;

import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Date;


public class Projeto {
    private int id;
    private String titulo;
    private StatusProjeto status;
    private String descricao;
    private Empresa empresa;
    private Desenvolvedor desenvolvedor;
    private ArrayList<Desenvolvedor> candidatos;

    public Projeto(String titulo, String descricao, Empresa empresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.empresa = empresa;
        this.status = StatusProjeto.ABERTO;
        this.desenvolvedor = null;
        this.candidatos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String toString() {
        return "ID: " + id + " - Título: " + titulo + " - Status: " + status;
    }

    public void addCandidato(Desenvolvedor desenvolvedor) {
        candidatos.add(desenvolvedor);
    }

    public ArrayList<Desenvolvedor> getCandidatos() {
        return candidatos;
    }
}
