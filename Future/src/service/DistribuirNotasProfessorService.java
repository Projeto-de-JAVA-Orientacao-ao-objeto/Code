package service;

import database.DistribuirNotasProfessorDatabase;
import model.DistribuirNotasProfessorModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DistribuirNotasProfessorService {
    private DistribuirNotasProfessorDatabase database;

    public DistribuirNotasProfessorService() {
        this.database = new DistribuirNotasProfessorDatabase();
    }

    public void carregarAtividades(String nomeUsuario, DefaultTableModel tableModel) {
        List<DistribuirNotasProfessorModel> atividades = database.obterAtividades(nomeUsuario);

        for (DistribuirNotasProfessorModel atividade : atividades) {
            tableModel.addRow(new Object[] {
                atividade.getIdMateria(),
                atividade.getMateria(),
                atividade.getNomeAtividade(),
                atividade.getDataEntrega(),
                atividade.getNota()
            });
        }
    }

    public void mostrarAlunos(String nomeUsuario, String nomeAtividade, DefaultTableModel tableModel) {
        List<DistribuirNotasProfessorModel> alunos = database.obterAlunosPorAtividade(nomeUsuario, nomeAtividade);
        tableModel.setRowCount(0);  // Limpar tabela
        for (DistribuirNotasProfessorModel aluno : alunos) {
            tableModel.addRow(new Object[] {
                aluno.getNomeAluno(),  // Nome do aluno
                aluno.getNota()        // Nota atribuída ao aluno
            });
        }
    }

    public void atribuirNota(String nomeUsuario, String nomeAtividade, String nomeAluno, double nota) {
        database.atualizarNota(nomeUsuario, nomeAtividade, nomeAluno, nota);
    }
}
