package com.octotech.modelo;

import java.util.Date;

public class Proposta {
    private int id;
    private double valor;
    private Date prazo;
    private String descricao;

    public void aceitar() {
        System.out.println("Proposta aceita.");
    }

    public void recusar() {
        System.out.println("Proposta recusada.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
