package controller;

import command.Command;
import command.VoltarBotaoCommand;
import model.CadastrarCursosModel;
import service.CadastrarCursosService;

public class CadastrarCursosController {
    private CadastrarCursosService cadastrarCursosService;

    public CadastrarCursosController() {
        this.cadastrarCursosService = new CadastrarCursosService();
    }

    public void cadastrarCurso(String idCurso, String idMateria, String curso, String materia, String modulo) {
        //cadastrarCursosService.cadastrarCurso(idCurso, idMateria, curso, materia, modulo);

        // Cria o objeto CadastrarAulasModel
        CadastrarCursosModel cursos = new CadastrarCursosModel(idCurso, idMateria, curso, materia, modulo);

        // Passa o objeto para o serviço
        cadastrarCursosService.cadastrarCurso(cursos);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
