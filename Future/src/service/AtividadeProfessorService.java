package service;

import database.AtividadeProfessorDatabase;
import model.AtividadeProfessorModel;

public class AtividadeProfessorService {
    private AtividadeProfessorDatabase database;

    public AtividadeProfessorService() {
        this.database = new AtividadeProfessorDatabase();
    }

    public AtividadeProfessorModel obterDadosProfessor(String nomeUsuario) {
        return database.buscarDadosProfessor(nomeUsuario);
    }

    public boolean inserirAtividade(AtividadeProfessorModel atividade) {
        return database.inserirAtividade(atividade);
    }
}
