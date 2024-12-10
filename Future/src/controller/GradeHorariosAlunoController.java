package controller;

import service.GradeHorariosAlunoService;
import javax.swing.table.DefaultTableModel;

import command.Command;
import command.VoltarBotaoCommand;

public class GradeHorariosAlunoController {
    private GradeHorariosAlunoService gradeHorariosAlunoService;

    public GradeHorariosAlunoController() {
        this.gradeHorariosAlunoService = new GradeHorariosAlunoService();
    }

    public void listarGradeHorarios(DefaultTableModel model, String usuario) {
        gradeHorariosAlunoService.preencherTabelaGradeHorarios(model, usuario);
    }

    public void voltar(String nomeAluno) {
        Command voltarCommand = new VoltarBotaoCommand(nomeAluno);
        voltarCommand.execute();
    }
}
