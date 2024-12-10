package service;

import database.VisualizarNotasAlunoDatabase;
import javax.swing.table.DefaultTableModel;

public class VisualizarNotasAlunoService {
    private VisualizarNotasAlunoDatabase database;

    public VisualizarNotasAlunoService() {
        this.database = new VisualizarNotasAlunoDatabase();
    }

    public void preencherTabelaNotas(String nomeUsuario, DefaultTableModel model) {
        database.carregarNotasAluno(nomeUsuario, model);
    }
}
