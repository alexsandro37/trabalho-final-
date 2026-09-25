package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.dao.UsuarioDAO;
import br.com.agenciaempregos.dao.EmpresaDAO;
import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TelaCadastroEmpresa extends javax.swing.JDialog {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblNomeEmpresa;
    private javax.swing.JTextField txtNomeEmpresa;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JButton btnCadastrar;

    private boolean cadastroRealizado = false;
    private String emailCadastrado = "";

    public TelaCadastroEmpresa(java.awt.Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Empresa");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(450, 600);

        lblCabecalho = new javax.swing.JLabel("Criar Perfil de Empresa");
        lblCabecalho.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 16));
        lblCabecalho.setBounds(30, 20, 390, 30);
        getContentPane().add(lblCabecalho);

        // Nome Empresa
        lblNomeEmpresa = new javax.swing.JLabel("Nome da Empresa:");
        lblNomeEmpresa.setBounds(30, 60, 390, 18);
        getContentPane().add(lblNomeEmpresa);

        txtNomeEmpresa = new javax.swing.JTextField();
        txtNomeEmpresa.setBounds(30, 80, 390, 28);
        getContentPane().add(txtNomeEmpresa);
        lblCNPJ = new javax.swing.JLabel("CNPJ:");
        lblCNPJ.setBounds(30, 115, 390, 18);
        getContentPane().add(lblCNPJ);
        txtCNPJ = new javax.swing.JTextField();
        txtCNPJ.setBounds(30, 135, 390, 28);
        getContentPane().add(txtCNPJ);
        lblEmail = new javax.swing.JLabel("Email da Empresa:");
        lblEmail.setBounds(30, 170, 390, 18);
        getContentPane().add(lblEmail);
        txtEmail = new javax.swing.JTextField();
        txtEmail.setBounds(30, 190, 390, 28);
        getContentPane().add(txtEmail);
        lblTelefone = new javax.swing.JLabel("Telefone:");
        lblTelefone.setBounds(30, 225, 390, 18);
        getContentPane().add(lblTelefone);

        txtTelefone = new javax.swing.JTextField();
        txtTelefone.setBounds(30, 245, 390, 28);
        getContentPane().add(txtTelefone);
        lblSenha = new javax.swing.JLabel("Senha:");
        lblSenha.setBounds(30, 280, 390, 18);
        getContentPane().add(lblSenha);
        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setBounds(30, 300, 390, 28);
        getContentPane().add(txtSenha);
        lblConfirmarSenha = new javax.swing.JLabel("Confirmar Senha:");
        lblConfirmarSenha.setBounds(30, 335, 390, 18);
        getContentPane().add(lblConfirmarSenha);
        txtConfirmarSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha.setBounds(30, 355, 390, 28);
        getContentPane().add(txtConfirmarSenha);
        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(30, 410, 390, 32);
        btnCadastrar.addActionListener(evt -> btnCadastrarActionPerformed(evt));
        getContentPane().add(btnCadastrar);

        setLocationRelativeTo(getOwner());
    }

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeEmpresa = txtNomeEmpresa.getText().trim();
        String cnpj = txtCNPJ.getText().trim();
        String email = txtEmail.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String senha = new String(txtSenha.getPassword());
        String confirmar = new String(txtConfirmarSenha.getPassword());

        if (nomeEmpresa.isEmpty() || cnpj.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Digite um email valido.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (senha.length() < 4) {
            JOptionPane.showMessageDialog(this, "A senha deve ter pelo menos 4 caracteres.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!senha.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "As senhas nao conferem.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (UsuarioDAO.emailJaCadastrado(email)) {
            JOptionPane.showMessageDialog(this, "Ja existe um perfil com esse email.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioDAO.cadastrar(email, senha, TipoUsuario.EMPRESA);
        EmpresaDAO.cadastrar(nomeEmpresa, cnpj, email, telefone, email);

        cadastroRealizado = true;
        emailCadastrado = email;
        JOptionPane.showMessageDialog(this, "Perfil de empresa criado com sucesso. Faca login para continuar.");
        dispose();
    }

    public boolean isCadastroRealizado() { return cadastroRealizado; }
    public String getEmailCadastrado() { return emailCadastrado; }
}
