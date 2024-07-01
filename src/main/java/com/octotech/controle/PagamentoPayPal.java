package com.octotech.controle;

import com.octotech.modelo.Usuario;

public class PagamentoPayPal implements EstrategiaPagamento {
    @Override
    public void pagar(double valor, Usuario pagador, Usuario recebedor) {
        System.out.println("Pagamento com PayPal: " + valor);
    }
}
