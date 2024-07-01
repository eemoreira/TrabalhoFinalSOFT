package com.octotech.util;

public class GerenciadorSessao {
    private static GerenciadorSessao instancia;

    private GerenciadorSessao() {}

    public static synchronized GerenciadorSessao getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorSessao();
        }
        return instancia;
    }
}
