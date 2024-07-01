package com.octotech.modelo;

import java.util.List;

public class Chat {
    private List<String> mensagens;

    public void enviar(String mensagem) {
        mensagens.add(mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }
}
