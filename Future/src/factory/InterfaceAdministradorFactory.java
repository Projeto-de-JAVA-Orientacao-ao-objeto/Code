package factory;

import controller.CadastrarUsuariosController;
import controller.CadastrarCursosController;
import controller.CadastrarAulasController;
import controller.ListarUsuariosController;
import controller.ListarCursosController;
import controller.ListarAulasController;
import model.UsuarioModel;
import view.InterfaceCadastrarUsuariosAdministrador;
import view.InterfaceCadastrarCursosAdministrador;
import view.InterfaceCadastrarAulasAdministrador;
import view.InterfaceListarUsuariosAdministrador;
import view.InterfaceListarCursos;
import view.InterfaceListarAulasAdministrador;

import javax.swing.*;

public class InterfaceAdministradorFactory {

    // Método Factory para criar as interfaces
    public static JFrame criarTela(String tipo, UsuarioModel usuario) {
        switch (tipo) {
            case "CadastrarUsuario":
                return new InterfaceCadastrarUsuariosAdministrador(usuario.getUsername(), new CadastrarUsuariosController());
            case "CadastrarCurso":
                return new InterfaceCadastrarCursosAdministrador(usuario.getUsername(), new CadastrarCursosController());
            case "CadastrarAulas":
                return new InterfaceCadastrarAulasAdministrador(usuario.getUsername(), new CadastrarAulasController());
            case "VisualizarUsuarios":
                return new InterfaceListarUsuariosAdministrador(usuario.getUsername(), new ListarUsuariosController());
            case "VisualizarCursos":
                return new InterfaceListarCursos(usuario.getUsername(), new ListarCursosController());
            case "VisualizarAulas":
                return new InterfaceListarAulasAdministrador(usuario.getUsername(), new ListarAulasController());
            default:
                throw new IllegalArgumentException("Tipo de tela desconhecido");
        }
    }
}
