package observer;

import javax.swing.*;

public class LoginStatusObserver implements LoginObserver {

    @Override
    public void onLoginSuccess(String username) {
        // Ação quando o login for bem-sucedido

        JOptionPane.showMessageDialog(null, "Login bem-sucedido para o usuário: " + username);
    }

    @Override
    public void onLoginFailure() {
     
        JOptionPane.showMessageDialog(null, "Falha no login. Tente novamente.");
    }
}
