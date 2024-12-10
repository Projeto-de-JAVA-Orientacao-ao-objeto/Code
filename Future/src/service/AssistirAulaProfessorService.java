package service;

import database.AssistirAulaProfessorDatabase;

public class AssistirAulaProfessorService {
    private AssistirAulaProfessorDatabase database;

    public AssistirAulaProfessorService() {
        this.database = new AssistirAulaProfessorDatabase();
    }

    public String[][] buscarDadosAulas(String nomeUsuario) {
        return database.buscarDadosAulas(nomeUsuario);
    }
}
