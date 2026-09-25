package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Font;

public class TelaCadastroUsuario extends javax.swing.JDialog {

    private boolean cadastroRealizado = false;
    private String emailCadastrado = "";

    public TelaCadastroUsuario(java.awt.Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

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
    }

    public boolean isCadastroRealizado() { return cadastroRealizado; }
    public String getEmailCadastrado() { return emailCadastrado; }
}
