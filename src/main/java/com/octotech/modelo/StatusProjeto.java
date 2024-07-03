package com.octotech.modelo;

public enum StatusProjeto {
    ABERTO {
        public String toString() {
            return "Pendente";
        }
    },
    EM_ANDAMENTO {
        public String toString() {
            return "Em andamento";
        }
    },
    CONCLUIDO {
        public String toString() {
            return "Concluído";
        }
    }
}
