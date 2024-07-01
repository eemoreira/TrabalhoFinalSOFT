package com.octotech.controle;

import java.util.ArrayList;
import java.util.List;

public class ServicoNotificacao {
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            observador.atualizar(mensagem);
        }
    }
}

interface Observador {
    void atualizar(String mensagem);
}
