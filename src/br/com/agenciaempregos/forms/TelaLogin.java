package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.dao.UsuarioDAO;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnCriarConta;

    public TelaLogin() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Sistema de Agencia de Empregos");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(400, 320);

        lblCabecalho = new javax.swing.JLabel("Entrar no sistema");
        lblCabecalho.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 18));
        lblCabecalho.setBounds(30, 20, 300, 30);
        getContentPane().add(lblCabecalho);

        lblEmail = new javax.swing.JLabel("Email:");
        lblEmail.setBounds(30, 70, 300, 18);
        getContentPane().add(lblEmail);

        txtEmail = new javax.swing.JTextField();
        txtEmail.setBounds(30, 90, 320, 28);
        getContentPane().add(txtEmail);

        lblSenha = new javax.swing.JLabel("Senha:");
        lblSenha.setBounds(30, 130, 300, 18);
        getContentPane().add(lblSenha);

        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setBounds(30, 150, 320, 28);
        getContentPane().add(txtSenha);

        btnEntrar = new javax.swing.JButton("Entrar");
        btnEntrar.setBounds(30, 200, 320, 32);
        btnEntrar.addActionListener(evt -> btnEntrarActionPerformed(evt));
        getContentPane().add(btnEntrar);

        btnCriarConta = new javax.swing.JButton("Criar conta");
        btnCriarConta.setBounds(30, 240, 320, 30);
        btnCriarConta.addActionListener(evt -> btnCriarContaActionPerformed(evt));
        getContentPane().add(btnCriarConta);

        setLocationRelativeTo(null);
    }
    // </editor-fold>

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha email e senha.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (UsuarioDAO.autenticar(email, senha)) {
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha invalidos.", "Erro no login", JOptionPane.ERROR_MESSAGE);
            txtSenha.setText("");
        }
    }

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroUsuario dialogo = new TelaCadastroUsuario(this, true);
        dialogo.setVisible(true);
    
        if (dialogo.isCadastroRealizado()) {
            txtEmail.setText(dialogo.getEmailCadastrado());
            txtSenha.setText("");
        }
    }
}
