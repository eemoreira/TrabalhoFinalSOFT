package com.octotech.modelo;

import com.octotech.controle.EstrategiaPagamento;

import java.util.Date;

public class Pagamento {
    private int id;
    private double valor;
    private Date data;
    private Usuario pagador;
    private Usuario recebedor;
    private EstrategiaPagamento ep;

    public boolean processar() {
        if (pagador.saldo < valor) return false;
        pagador.saldo -= valor;
        recebedor.saldo += valor;
        return true;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
