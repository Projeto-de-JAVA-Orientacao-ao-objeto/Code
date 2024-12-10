package service;

import database.VisualizarAtividadesProfessorDatabase;
import model.VisualizarAtividadesProfessorModel;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisualizarAtividadesProfessorService {
    private VisualizarAtividadesProfessorDatabase database;

    public VisualizarAtividadesProfessorService() {
        database = new VisualizarAtividadesProfessorDatabase();
    }

    public void preencherTabelaAtividades(DefaultTableModel tableModel) {
        List<VisualizarAtividadesProfessorModel> atividades = database.obterAtividades();

        for (VisualizarAtividadesProfessorModel atividade : atividades) {
            tableModel.addRow(new Object[]{
                atividade.getIdMateria(),
                atividade.getMateria(),
                atividade.getNomeAtividade(),
                atividade.getPergunta(),
                atividade.getDataEntrega(),
                atividade.getNota()
            });
        }
    }
}
