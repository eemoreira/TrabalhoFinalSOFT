package com.octotech.controle;

import com.octotech.modelo.Desenvolvedor;
import com.octotech.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class UsuarioDAO {
    private static UsuarioDAO instance;
    HashMap<Integer, Usuario> usuarios;

    private UsuarioDAO() {
        usuarios = new HashMap<>();
    }

    public static UsuarioDAO getInstancia() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public Usuario logar(String cpfCnpj, String senha) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getCpfCnpj().equals(cpfCnpj) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario getUsuario(int id) {
        return usuarios.get(id);
    }

    public void cadastrar(Usuario usuario) {
        usuario.setId(usuarios.size() + 1);
        usuarios.put(usuario.getId(), usuario);
    }

    public List<Desenvolvedor> listarDesenvolvedores() {
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();
        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Desenvolvedor) {
                desenvolvedores.add((Desenvolvedor) usuario);
            }
        }
        return desenvolvedores;
    }

    public Desenvolvedor buscarDesenvolvedorPorId(int id) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Desenvolvedor && usuario.getId() == id) {
                return (Desenvolvedor) usuario;
            }
        }
        return null;
    }

    public Usuario buscarPorCpfCnpj(String cpfCnpj) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getCpfCnpj().equals(cpfCnpj)) {
                return usuario;
            }
        }
        return null;
    }
}
