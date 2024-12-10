package controller;

import model.UsuarioModel;
import factory.InterfaceAlunoFactory;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import command.Command;
import command.VoltarBotaoCommand;

public class AlunoInicialController {
    private InterfaceInicialAluno view;
    private UsuarioModel usuario;

    public AlunoInicialController(InterfaceInicialAluno view, UsuarioModel usuario) {
        this.view = view;
        this.usuario = usuario;

        // Adiciona os listeners dos botões
        this.view.adicionarAcaoAssistirAulas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assistirAulas();
            }
        });

        this.view.adicionarAcaoEnviarAtividades(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarAtividades();
            }
        });

        this.view.adicionarAcaoVisualizarNotas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarNotas();
            }
        });

        this.view.adicionarMembrosSala(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarMembrosSala();
            }
        });

        this.view.adicionarAcaoGradeHorarios(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradeHorarios();
            }
        });

        this.view.adicionarAcaoAvisos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarAvisos();
            }
        });
    }

    private void assistirAulas() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("AssistirAula", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void enviarAtividades() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("AtividadesAluno", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarNotas() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("VisualizarNotas", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarMembrosSala() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("SaladeAula", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void gradeHorarios() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("GradeHorarios", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarAvisos() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceAlunoFactory.criarTela("AvisosAluno", usuario);

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
