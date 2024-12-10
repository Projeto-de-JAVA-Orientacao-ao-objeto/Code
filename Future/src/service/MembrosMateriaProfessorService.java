package service;

import database.MembrosMateriaProfessorDatabase;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.MembrosMateriaProfessorModel;

public class MembrosMateriaProfessorService {
    private MembrosMateriaProfessorDatabase database;

    public MembrosMateriaProfessorService() {
        this.database = new MembrosMateriaProfessorDatabase();
    }

    public List<MembrosMateriaProfessorModel> carregarMembros(String nomeUsuario) {
        return database.carregarMembros(nomeUsuario);
    }

    public void carregarMembros(String nomeUsuario, DefaultTableModel model) {
        //List<MembrosMateriaProfessorModel> membros = MembrosMateriaProfessorDatabase.carregarMembros(nomeUsuario);

        List<MembrosMateriaProfessorModel> membros = database.carregarMembros(nomeUsuario);
        // Preencher a tabela com a lista de membros
        for (MembrosMateriaProfessorModel membro : membros) {
            Object[] row = {
                membro.getIdUsuario(),
                membro.getNome(),
                membro.getIdentificacao(),
                membro.getCurso(),
                membro.getEmail()
            };
            model.addRow(row);
        }
    
    }
}
