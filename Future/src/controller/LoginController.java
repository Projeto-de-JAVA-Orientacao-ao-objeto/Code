package controller;

import factory.InterfaceLoginFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.UsuarioModel;
import observer.LoginObserver;
import service.AutenticacaoService;
import view.InterfaceLogin;

public class LoginController {
    private InterfaceLogin view;
    private AutenticacaoService autenticacaoService;
    private List<LoginObserver> observers = new ArrayList<>();  // Lista de observadores

    public LoginController(InterfaceLogin view, AutenticacaoService autenticacaoService) {
        this.view = view;
        this.autenticacaoService = autenticacaoService;
        this.view.getLoginButton().addActionListener(e -> login());
    }

    // Método para adicionar um observador
    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    // Método para notificar sucesso no login
    private void notifyLoginSuccess(String username) {
        for (LoginObserver observer : observers) {
            observer.onLoginSuccess(username);
        }
    }

    // Método para notificar falha no login
    private void notifyLoginFailure() {
        for (LoginObserver observer : observers) {
            observer.onLoginFailure();
        }
    }

    public void login() {
        String username = view.getUsername();
        String password = view.getPassword();
        UsuarioModel user = new UsuarioModel(username, password);
        String role = autenticacaoService.authenticate(user); // Simulação da autenticação

        if (role != null) {
            // Login bem-sucedido
            JFrame interfaceInicial = InterfaceLoginFactory.createInterface(role, username);
            if (interfaceInicial != null) {
                view.getFrame().dispose();
                interfaceInicial.setVisible(true);
            }
            notifyLoginSuccess(username);  // Notifica sucesso
        } else {
            // Falha no login - não exibe mensagem diretamente aqui
            notifyLoginFailure();  // Notifica falha para o observer
        }
    }
}
