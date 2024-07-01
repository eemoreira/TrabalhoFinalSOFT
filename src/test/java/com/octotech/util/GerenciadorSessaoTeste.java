package com.octotech.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorSessaoTeste {
    @Test
    public void testSingleton() {
        GerenciadorSessao instancia1 = GerenciadorSessao.getInstancia();
        GerenciadorSessao instancia2 = GerenciadorSessao.getInstancia();
        assertSame(instancia1, instancia2);
    }
}