package com.octotech.visualizacao;

import com.octotech.controle.ProjetoDAO;
import com.octotech.controle.UsuarioDAO;
import com.octotech.controle.GerenciadorSessao;
import com.octotech.modelo.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 3) {
            menu();
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> logar();
                case 2 -> cadastrar();
                case 3 -> System.out.println("Até mais!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void menu() {
        System.out.println("Bem vindo a OCTOTECH!");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastro");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void logar() {
        System.out.print("Digite seu CPF/CNPJ: ");
        String cpfCnpj = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        Usuario usuario = UsuarioDAO.getInstancia().logar(cpfCnpj, senha);
        if (usuario != null) {
            GerenciadorSessao.getInstancia().setUsuarioLogado(usuario);
            if (usuario instanceof Desenvolvedor) {
                menuDesenvolvedor();
                GerenciadorSessao.getInstancia().deslogar();
            } else if (usuario instanceof Empresa) {
                menuEmpresa();
                GerenciadorSessao.getInstancia().deslogar();
            }
        } else {
            System.out.println("CPF/CNPJ ou senha inválidos!");
        }
    }

    public static void cadastrar() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF/CNPJ: ");
        String cpfCnpj = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Você é um desenvolvedor ou uma empresa?");
        System.out.println("1 - Desenvolvedor");
        System.out.println("2 - Empresa");
        System.out.print("Escolha uma opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> cadastrarDesenvolvedor(nome, cpfCnpj, senha);
            case 2 -> cadastrarEmpresa(nome, cpfCnpj, senha);
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarDesenvolvedor(String nome, String cpfCnpj, String senha) {
        if (UsuarioDAO.getInstancia().buscarPorCpfCnpj(cpfCnpj) != null) {
            System.out.println("CPF/CNPJ já cadastrado!");
            return;
        }
        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, cpfCnpj, senha);
        UsuarioDAO.getInstancia().cadastrar(desenvolvedor);
        System.out.println("Desenvolvedor cadastrado com sucesso!");
    }

    private static void cadastrarEmpresa(String nome, String cpfCnpj, String senha) {
        if (UsuarioDAO.getInstancia().buscarPorCpfCnpj(cpfCnpj) != null) {
            System.out.println("CPF/CNPJ já cadastrado!");
            return;
        }
        Empresa empresa = new Empresa(nome, cpfCnpj, senha);
        UsuarioDAO.getInstancia().cadastrar(empresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }

    public static void menuDesenvolvedor() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("1 - Listar projetos");
            System.out.println("2 - Listar meus projetos");
            System.out.println("3 - Aplicar para projeto");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            Desenvolvedor desenvolvedor = (Desenvolvedor) GerenciadorSessao.getInstancia().getUsuarioLogado();
            switch (opcao) {
                case 1 -> listarProjetos();
                case 2 -> listarProjetosDesenvolvedor(desenvolvedor);
                case 3 -> aplicarParaProjeto(desenvolvedor);
                case 4 -> System.out.println("Até mais!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void aplicarParaProjeto(Desenvolvedor desenvolvedor) {
        listarProjetos();
        System.out.print("Digite o ID do projeto que deseja aplicar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Projeto projeto = ProjetoDAO.getInstancia().buscarPorId(id);
        if (projeto != null) {
            if (projeto.getStatus() != StatusProjeto.ABERTO) {
                System.out.println("Projeto não está aberto para aplicação!");
                return;
            }
            ProjetoDAO.getInstancia().adicionaCandidato(projeto, desenvolvedor);
            System.out.println("Aplicação enviada com sucesso!");
        } else {
            System.out.println("Projeto não encontrado!");
        }
    }

    private static void listarProjetosDesenvolvedor(Desenvolvedor desenvolvedor) {
        System.out.println("PROJETOS DE " + desenvolvedor.getNome() + ":");
        for (Projeto projeto : ProjetoDAO.getInstancia().listarPorDesenvolvedor(desenvolvedor)) {
            System.out.println(projeto);
        }
    }

    private static void listarProjetos() {
        System.out.println("PROJETOS:");
        for (Projeto projeto : ProjetoDAO.getInstancia().listar()) {
            System.out.println(projeto);
        }
    }

    public static void menuEmpresa() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("1 - Listar meus projetos");
            System.out.println("2 - Postar novo projeto");
            System.out.println("3 - Iniciar projeto");
            System.out.println("4 - Encerrar projeto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            Empresa empresa = (Empresa) GerenciadorSessao.getInstancia().getUsuarioLogado();
            switch (opcao) {
                case 1 -> listarProjetosEmpresa(empresa);
                case 2 -> postarNovoProjeto(empresa);
                case 3 -> iniciarProjeto(empresa);
                case 4 -> encerrarProjeto(empresa);
                case 5 -> System.out.println("Até mais!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void encerrarProjeto(Empresa empresa) {
        listarProjetosEmpresa(empresa);
        System.out.print("Digite o ID do projeto que deseja encerrar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Projeto projeto = ProjetoDAO.getInstancia().buscarPorId(id);
        if (projeto == null) {
            System.out.println("Projeto não encontrado!");
            return;
        }
        if (projeto.getStatus() != StatusProjeto.EM_ANDAMENTO) {
            System.out.println("Projeto não está em andamento!");
            return;
        }
        projeto.setStatus(StatusProjeto.CONCLUIDO);
        System.out.println("Projeto encerrado com sucesso!");
    }

    private static void listarProjetosEmpresa(Empresa empresa) {
        System.out.println("PROJETOS DE " + empresa.getNome() + ":");
        for (Projeto projeto : ProjetoDAO.getInstancia().listarPorEmpresa(empresa)) {
            System.out.println(projeto);
        }
    }

    private static void iniciarProjeto(Empresa empresa) {
        listarProjetosEmpresa(empresa);
        System.out.print("Digite o ID do projeto que deseja iniciar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Projeto projeto = ProjetoDAO.getInstancia().buscarPorId(id);
        if (projeto == null) {
            System.out.println("Projeto não encontrado!");
            return;
        }
        if (projeto.getStatus() != StatusProjeto.ABERTO) {
            System.out.println("Projeto não está aberto para início!");
            return;
        }
        System.out.println("Selecione o desenvolvedor para iniciar o projeto:");
        for (Desenvolvedor desenvolvedor : projeto.getCandidatos()) {
            System.out.println(desenvolvedor);
        }
        System.out.print("Digite o ID do desenvolvedor: ");
        int idDesenvolvedor = Integer.parseInt(scanner.nextLine());
        Desenvolvedor desenvolvedor = UsuarioDAO.getInstancia().buscarDesenvolvedorPorId(idDesenvolvedor);
        if (desenvolvedor == null) {
            System.out.println("Desenvolvedor não encontrado!");
            return;
        } else if (!projeto.getCandidatos().contains(desenvolvedor)) {
            System.out.println("Desenvolvedor não é candidato do projeto!");
            return;
        }
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        System.out.println("Projeto iniciado com sucesso com o desenvolvedor " + desenvolvedor.getNome() + "!");
    }

    private static void postarNovoProjeto(Empresa empresa) {
        System.out.print("Digite o título do projeto: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição do projeto: ");
        String descricao = scanner.nextLine();
        Projeto projeto = new Projeto(titulo, descricao, empresa);
        ProjetoDAO.getInstancia().cadastrar(projeto);
        System.out.println("Projeto postado com sucesso!");
    }

}
