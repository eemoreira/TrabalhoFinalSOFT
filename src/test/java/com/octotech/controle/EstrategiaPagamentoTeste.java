package com.octotech.controle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiaPagamentoTeste {
    @Test
    public void testPagamentoCartaoCredito() {
        EstrategiaPagamento pagamento = new PagamentoCartaoCredito();
        pagamento.pagar(100.0);
        // assert para verificar o pagamento com cartão de crédito
    }

    @Test
    public void testPagamentoPayPal() {
        EstrategiaPagamento pagamento = new PagamentoPayPal();
        pagamento.pagar(100.0);
        // assert para verificar o pagamento com PayPal
    }
}
