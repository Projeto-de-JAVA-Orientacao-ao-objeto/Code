package service;

import database.ListarAulasDatabase;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ListarAulasModel;

public class ListarAulasService {
    private ListarAulasDatabase listarAulasDatabase;

    public ListarAulasService() {
        this.listarAulasDatabase = new ListarAulasDatabase();
    }

    public void preencherTabelaAulas(DefaultTableModel model) {
        List<ListarAulasModel> aulas = listarAulasDatabase.obterTodasAulas();

        for (ListarAulasModel aula : aulas) {
            model.addRow(new Object[]{
                aula.getIdMateria(),
                aula.getMateria(),
                aula.getHorarioInicio(),
                aula.getHorarioFim(),
                aula.getDia(),
                aula.getPeriodo(),
                aula.getLinkSala()
            });
        }
    }
}
