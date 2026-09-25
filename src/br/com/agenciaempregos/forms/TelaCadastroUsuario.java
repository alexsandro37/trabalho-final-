package br.com.agenciaempregos.forms;

<<<<<<< HEAD
import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;

public class TelaCadastroUsuario extends javax.swing.JDialog {

=======
import br.com.agenciaempregos.dao.UsuarioDAO;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TelaCadastroUsuario extends javax.swing.JDialog {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JButton btnCadastrar;

>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    private boolean cadastroRealizado = false;
    private String emailCadastrado = "";

    public TelaCadastroUsuario(java.awt.Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

<<<<<<< HEAD
    private void initComponents() {
        setTitle("Criar Conta");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(450, 300);

        javax.swing.JLabel lblCabecalho = new javax.swing.JLabel("Escolha o tipo de perfil:");
        lblCabecalho.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 18));
        lblCabecalho.setBounds(30, 30, 390, 40);
        getContentPane().add(lblCabecalho);

        javax.swing.JButton btnCandidato = new javax.swing.JButton("👤 Criar conta como Candidato");
        btnCandidato.setBounds(30, 100, 390, 60);
        btnCandidato.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
        btnCandidato.addActionListener(evt -> escolherCandidato());
        getContentPane().add(btnCandidato);

        javax.swing.JButton btnEmpresa = new javax.swing.JButton("🏢 Criar conta como Empresa");
        btnEmpresa.setBounds(30, 180, 390, 60);
        btnEmpresa.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
        btnEmpresa.addActionListener(evt -> escolherEmpresa());
        getContentPane().add(btnEmpresa);

        setLocationRelativeTo(getOwner());
    }

    private void escolherCandidato() {
        TelaCadastroCandidato cadastro = new TelaCadastroCandidato((java.awt.Frame) getOwner(), true);
        cadastro.setVisible(true);
        
        if (cadastro.isCadastroRealizado()) {
            cadastroRealizado = true;
            emailCadastrado = cadastro.getEmailCadastrado();
            dispose();
        }
    }

    private void escolherEmpresa() {
        TelaCadastroEmpresa cadastro = new TelaCadastroEmpresa((java.awt.Frame) getOwner(), true);
        cadastro.setVisible(true);
        
        if (cadastro.isCadastroRealizado()) {
            cadastroRealizado = true;
            emailCadastrado = cadastro.getEmailCadastrado();
            dispose();
        }
=======
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setTitle("Criar conta");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(400, 380);

        lblCabecalho = new javax.swing.JLabel("Criar novo perfil");
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

        lblConfirmarSenha = new javax.swing.JLabel("Confirmar senha:");
        lblConfirmarSenha.setBounds(30, 190, 300, 18);
        getContentPane().add(lblConfirmarSenha);

        txtConfirmarSenha = new javax.swing.JPasswordField();
        txtConfirmarSenha.setBounds(30, 210, 320, 28);
        getContentPane().add(txtConfirmarSenha);

        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(30, 260, 320, 32);
        btnCadastrar.addActionListener(evt -> btnCadastrarActionPerformed(evt));
        getContentPane().add(btnCadastrar);

        setLocationRelativeTo(getOwner());
    }
    // </editor-fold>

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword());
        String confirmar = new String(txtConfirmarSenha.getPassword());

        if (email.isEmpty() || senha.isEmpty() || confirmar.isEmpty()) {
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

        UsuarioDAO.cadastrar(email, senha);
        cadastroRealizado = true;
        emailCadastrado = email;
        JOptionPane.showMessageDialog(this, "Perfil criado com sucesso. Faca login para continuar.");
        dispose();
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    }

    public boolean isCadastroRealizado() { return cadastroRealizado; }
    public String getEmailCadastrado() { return emailCadastrado; }
}
