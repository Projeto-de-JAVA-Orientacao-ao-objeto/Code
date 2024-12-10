package controller;

import command.Command;
import command.VoltarBotaoCommand;
import model.CadastrarUsuariosModel;
import service.CadastrarUsuariosService;

public class CadastrarUsuariosController {
    private CadastrarUsuariosService cadastrarUsuariosService;

    public CadastrarUsuariosController() {
        this.cadastrarUsuariosService = new CadastrarUsuariosService();
    }

    public void cadastrarUsuario(String idUsuario, String nome, String usuario, String senha, String identificacao, String email, String telefone, String idCurso, String curso, String idMateria, String materia) {

        CadastrarUsuariosModel usuarios = new CadastrarUsuariosModel(idUsuario, nome, usuario, senha,identificacao, email, telefone, idCurso,  curso,  idMateria,  materia);

        // Passa o objeto para o serviço
        cadastrarUsuariosService.cadastrarUsuario(usuarios);

    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
