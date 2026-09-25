package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.dao.UsuarioDAO;
import br.com.agenciaempregos.dao.CandidatoDAO;
import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TelaCadastroCandidato extends javax.swing.JDialog {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel lblArea;
    private javax.swing.JTextField txtArea;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JButton btnCadastrar;

    private boolean cadastroRealizado = false;
    private String emailCadastrado = "";

    public TelaCadastroCandidato(java.awt.Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Candidato");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(450, 650);

        lblCabecalho = new javax.swing.JLabel("Criar Perfil de Candidato");
        lblCabecalho.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 16));
        lblCabecalho.setBounds(30, 20, 390, 30);
        getContentPane().add(lblCabecalho);
        lblNome = new javax.swing.JLabel("Nome Completo:");
        lblNome.setBounds(30, 60, 390, 18);
        getContentPane().add(lblNome);
        txtNome = new javax.swing.JTextField();
        txtNome.setBounds(30, 80, 390, 28);
        getContentPane().add(txtNome);
        lblCPF = new javax.swing.JLabel("CPF:");
        lblCPF.setBounds(30, 115, 390, 18);
        getContentPane().add(lblCPF);
        txtCPF = new javax.swing.JTextField();
        txtCPF.setBounds(30, 135, 390, 28);
        getContentPane().add(txtCPF);
        lblEmail = new javax.swing.JLabel("Email:");
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
        lblArea = new javax.swing.JLabel("Area de Interesse:");
        lblArea.setBounds(30, 280, 390, 18);
        getContentPane().add(lblArea);
        txtArea = new javax.swing.JTextField();
        txtArea.setBounds(30, 300, 390, 28);
        getContentPane().add(txtArea);
        lblSenha = new javax.swing.JLabel("Senha:");
        lblSenha.setBounds(30, 335, 390, 18);
        getContentPane().add(lblSenha);
        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setBounds(30, 355, 390, 28);
        getContentPane().add(txtSenha);
        lblConfirmarSenha = new javax.swing.JLabel("Confirmar Senha:");
        lblConfirmarSenha.setBounds(30, 390, 390, 18);
        getContentPane().add(lblConfirmarSenha);
        txtConfirmarSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha.setBounds(30, 410, 390, 28);
        getContentPane().add(txtConfirmarSenha);
        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(30, 460, 390, 32);
        btnCadastrar.addActionListener(evt -> btnCadastrarActionPerformed(evt));
        getContentPane().add(btnCadastrar);

        setLocationRelativeTo(getOwner());
    }

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtNome.getText().trim();
        String cpf = txtCPF.getText().trim();
        String email = txtEmail.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String area = txtArea.getText().trim();
        String senha = new String(txtSenha.getPassword());
        String confirmar = new String(txtConfirmarSenha.getPassword());

        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || area.isEmpty() || senha.isEmpty() || confirmar.isEmpty()) {
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

        UsuarioDAO.cadastrar(email, senha, TipoUsuario.CANDIDATO);
        CandidatoDAO.cadastrar(nome, cpf, email, telefone, area, email);

        cadastroRealizado = true;
        emailCadastrado = email;
        JOptionPane.showMessageDialog(this, "Perfil de candidato criado com sucesso. Faca login para continuar.");
        dispose();
    }

    public boolean isCadastroRealizado() { return cadastroRealizado; }
    public String getEmailCadastrado() { return emailCadastrado; }
}
