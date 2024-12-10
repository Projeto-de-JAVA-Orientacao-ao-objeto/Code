package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import factory.InterfaceProfessorFactory;
import model.AulaModel;
import model.UsuarioModel;
import view.InterfaceAssistirAulaProfessor;
import view.InterfaceAtividadeProfessor;
import view.InterfaceAvisosProfessor;
import view.InterfaceDistribuirNotasProfessor;
import view.InterfaceInicialProfessor;
import view.InterfaceMembrosMateriaProfessor;
import view.InterfaceVisualizarAtividadesProfessor;

public class ProfessorInicialController {
    private InterfaceInicialProfessor view;
    private UsuarioModel usuario;

    public ProfessorInicialController(InterfaceInicialProfessor view, UsuarioModel usuario) {
        this.view = view;
        this.usuario = usuario;

        // Adiciona ação ao botão "Sala de Aula"
        this.view.adicionarAcaoSalaDeAula(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSalaDeAula();
            }
        });

        // Adiciona ação ao botão "Atividades"
        this.view.adicionarAcaoAtividades(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passarAtividades();
            }
        });

        // Adiciona ação ao botão "Distribuir Notas"
        this.view.adicionarAcaoDistribuirNotas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuirNotas();
            }
        });

        // Adiciona ação ao botão "Encaminhar Avisos"
        this.view.adicionarAcaoEncaminharAvisos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encaminharAvisos();
            }
        });

        // Adiciona ação ao botão "Membros Materia"
        this.view.adicionarAcaoMembrosMateria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMembrosMateria();
            }
        });

        // Adiciona ação ao botão "Visualizar Atividades"
        this.view.adicionarAcaoVisualizarAtividades(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarAtividades();
            }
        });
    }

    private void abrirSalaDeAula() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("AssistirAula", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
        
    }

    private void passarAtividades() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("AtividadesProfessor", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void distribuirNotas() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("DistribuirNotas", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void encaminharAvisos() {

        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("AvisosProfessor", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void abrirMembrosMateria() {

        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("MembrosMateria", usuario);

        // Fecha a tela inicial do administrador
        view.getFrame().dispose();
        tela.setVisible(true);
    }

    private void visualizarAtividades() {
        // Chama a fábrica para criar a tela de cadastro de usuário
        JFrame tela = InterfaceProfessorFactory.criarTela("VisualizarAtividades", usuario);

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
