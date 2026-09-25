package br.com.agenciaempregos.main;

import br.com.agenciaempregos.forms.TelaLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Se o Look and Feel do sistema nao estiver disponivel, usa o padrao do Swing.
        }
        // E obrigatorio ter um perfil (email + senha) para entrar no sistema.
        SwingUtilities.invokeLater(() -> {
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
        });
    }
}
