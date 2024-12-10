package service;

import database.ListarCursosDatabase;
import javax.swing.table.DefaultTableModel;
import model.ListarCursosModel;
import java.util.List;

public class ListarCursosService {
    private ListarCursosDatabase listarCursosDatabase;

    public ListarCursosService() {
        this.listarCursosDatabase = new ListarCursosDatabase();
    }

    public void preencherTabelaCursos(DefaultTableModel model) {
        List<ListarCursosModel> cursos = listarCursosDatabase.obterTodosCursos();

        for (ListarCursosModel curso : cursos) {
            model.addRow(new Object[]{
                curso.getIdCurso(),
                curso.getIdMateria(),
                curso.getCurso(),
                curso.getMateria(),
                curso.getModulo()
            });
        }
    }
}
