package service;

import database.SaladeaulaAlunoDatabase;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.SaladeaulaAlunoModel;

public class SaladeaulaAlunoService {
    private SaladeaulaAlunoDatabase database;

    public SaladeaulaAlunoService() {
        this.database = new SaladeaulaAlunoDatabase();
    }


    public void carregarMembros(String nomeUsuario, DefaultTableModel model) {
    
        List<SaladeaulaAlunoModel> membros = database.carregarMembros(nomeUsuario);
        // Preencher a tabela com a lista de membros
        for (SaladeaulaAlunoModel membro : membros) {
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
