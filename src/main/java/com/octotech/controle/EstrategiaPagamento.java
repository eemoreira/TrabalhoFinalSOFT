package com.octotech.controle;

import com.octotech.modelo.Usuario;

public interface EstrategiaPagamento {
    void pagar(double valor, Usuario pagador, Usuario recebedor);
}
