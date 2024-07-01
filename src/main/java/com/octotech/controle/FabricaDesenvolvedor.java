package com.octotech.controle;

import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Usuario;

public class FabricaDesenvolvedor extends FabricaUsuario {
    @Override
    public Usuario criarUsuario() {
        return new Desenvolvedor();
    }
}
