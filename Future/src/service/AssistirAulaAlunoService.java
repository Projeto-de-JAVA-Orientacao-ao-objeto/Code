package service;

import database.AssistirAulaAlunoDatabase;

public class AssistirAulaAlunoService {
    private AssistirAulaAlunoDatabase database;

    public AssistirAulaAlunoService() {
        this.database = new AssistirAulaAlunoDatabase();
    }

    public String[][] buscarDadosAulas(String nomeUsuario) {
        return database.buscarDadosAulas(nomeUsuario);
    }
}
