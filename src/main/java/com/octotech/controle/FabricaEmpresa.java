package com.octotech.controle;

import com.octotech.modelo.Empresa;
import com.octotech.modelo.Usuario;

public class FabricaEmpresa extends FabricaUsuario {
    @Override
    public Usuario criarUsuario() {
        return new Empresa();
    }
}
