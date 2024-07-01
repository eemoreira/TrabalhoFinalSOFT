package com.octotech.modelo;

public class Desenvolvedor extends Usuario {
    private String[] skills;
    private String portfolio;

    public void proporProjeto() {
        System.out.println("Proposta enviada por " + nome);
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }
}

