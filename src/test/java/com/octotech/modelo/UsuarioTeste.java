package com.octotech.modelo;

import org.junit.jupiter.api.Test;

public class UsuarioTeste {
    @Test
    public void testLogin() {
        Usuario usuario = new Desenvolvedor();
        usuario.login();
        // assert para verificar o login
    }

    @Test
    public void testLogout() {
        Usuario usuario = new Desenvolvedor();
        usuario.logout();
        // assert para verificar o logout
    }
}
