package controller;

import model.UsuarioModel;
import view.InterfaceInicialAdministrador;
import view.InterfaceListarUsuariosAdministrador;
import view.InterfaceListarCursos;
import view.InterfaceListarAulasAdministrador;
import view.InterfaceCadastrarAulasAdministrador;
import view.InterfaceCadastrarCursosAdministrador;
import view.InterfaceCadastrarUsuariosAdministrador;
import factory.InterfaceAdministradorFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AdministradorInicialController {
    private InterfaceInicialAdministrador view;
    private UsuarioModel usuario;

    public AdministradorInicialController(InterfaceInicialAdministrador view, UsuarioModel usuario) {
        this.view = view;
        this.usuario = usuario;

        // Adiciona os listeners dos botões
        this.view.adicionarAcaoCadastrarUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        this.view.adicionarAcaoCadastrarCurso(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCurso();
            }
        });

        this.view.adicionarAcaoCadastrarAulas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAulas();
            }
        });

        this.view.adicionarAcaoVisualizarUsuarios(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarUsuarios();
            }
        });

        this.view.adicionarAcaoVisualizarCursos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarCursos();
            }
        });

        this.view.adicionarAcaoVisualizarAulas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarAulas();
            }
        });
    }

    private void cadastrarUsuario() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAdministradorFactory.criarTela("CadastrarUsuario", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void cadastrarCurso() {
        // Chama a fábrica para criar a tela de cadastro de curso
        JFrame tela = InterfaceAdministradorFactory.criarTela("CadastrarCurso", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void cadastrarAulas() {
        // Chama a fábrica para criar a tela de cadastro de aulas
        JFrame tela = InterfaceAdministradorFactory.criarTela("CadastrarAulas", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarUsuarios() {
        // Chama a fábrica para criar a tela de visualização de usuários
        JFrame tela = InterfaceAdministradorFactory.criarTela("VisualizarUsuarios", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarCursos() {
        // Chama a fábrica para criar a tela de visualização de cursos
        JFrame tela = InterfaceAdministradorFactory.criarTela("VisualizarCursos", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarAulas() {
        // Chama a fábrica para criar a tela de visualização de aulas
        JFrame tela = InterfaceAdministradorFactory.criarTela("VisualizarAulas", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    public void voltar() {
        // Redireciona para a tela inicial do administrador
        //new view.InterfaceInicialAdministrador(nomeUsuario);
        new view.InterfaceLogin();
    }
}
