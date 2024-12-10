package service;

import database.GradeHorariosAlunoDatabase;
import javax.swing.table.DefaultTableModel;
import model.GradeHorariosAlunoModel;
import java.util.List;

public class GradeHorariosAlunoService {
    private GradeHorariosAlunoDatabase gradeHorariosAlunoDatabase;

    public GradeHorariosAlunoService() {
        this.gradeHorariosAlunoDatabase = new GradeHorariosAlunoDatabase();
    }

    public void preencherTabelaGradeHorarios(DefaultTableModel model, String usuario) {
        List<GradeHorariosAlunoModel> horarios = gradeHorariosAlunoDatabase.obterGradeHorarios(usuario);

        for (GradeHorariosAlunoModel horario : horarios) {
            model.addRow(new Object[]{
                horario.getDia(),
                horario.getMateria(),
                horario.getHorarioInicio(),
                horario.getHorarioFim()
            });
        }
    }
}
