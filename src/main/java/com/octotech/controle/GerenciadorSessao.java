package com.octotech.controle;

import com.octotech.modelo.Usuario;

public class GerenciadorSessao {
    private static GerenciadorSessao instancia;
    private Usuario usuarioLogado;

    private GerenciadorSessao() {}

    public static GerenciadorSessao getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorSessao();
        }
        return instancia;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void deslogar() {
        this.usuarioLogado = null;
    }

}
