package service;

import database.AvisosAlunoDatabase;
import model.AvisosAlunoModel;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AvisosAlunoService {
    private AvisosAlunoDatabase avisosAlunoDatabase;

    public AvisosAlunoService() {
        this.avisosAlunoDatabase = new AvisosAlunoDatabase();
    }

    public void preencherTabelaAvisos(String nomeUsuario, DefaultTableModel model) {
        List<AvisosAlunoModel> avisos = avisosAlunoDatabase.obterAvisosPorUsuario(nomeUsuario);

        for (AvisosAlunoModel aviso : avisos) {
            model.addRow(new Object[]{aviso.getTitulo(), aviso.getAviso()});
        }
    }

    public String obterDetalhesAviso(String tituloAviso) {
        return avisosAlunoDatabase.obterDetalhesAviso(tituloAviso);
    }
}
