package com.octotech.modelo;

public class Avaliacao {
    private int id;
    private int nota;
    private String comentario;

    public void avaliar() {
        System.out.println("Avaliação realizada.");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
