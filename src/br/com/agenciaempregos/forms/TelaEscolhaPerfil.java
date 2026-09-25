package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.util.EstiloUtil;
import br.com.agenciaempregos.util.SessaoUsuario;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TelaEscolhaPerfil extends javax.swing.JFrame {

    private String emailLogado;
    private TipoUsuario tipoUsuario;

    public TelaEscolhaPerfil(String email, TipoUsuario tipo) {
        this.emailLogado = email;
        this.tipoUsuario = tipo;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escolher Perfil - Sistema de Agencia de Empregos");
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(500, 350);

        javax.swing.JLabel lblCabecalho = new javax.swing.JLabel("Bem-vindo!");
        lblCabecalho.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 20));
        lblCabecalho.setBounds(50, 30, 400, 40);
        getContentPane().add(lblCabecalho);

        javax.swing.JLabel lblDescricao = new javax.swing.JLabel("Escolha como deseja entrar no sistema:");
        lblDescricao.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
        lblDescricao.setBounds(50, 80, 400, 25);
        getContentPane().add(lblDescricao);

        if (tipoUsuario == TipoUsuario.ADMIN) {
            abrirMenuAdmin();
        } else {
            javax.swing.JButton btnCandidato = new javax.swing.JButton("👤 Entrar como Candidato");
            btnCandidato.setBounds(50, 140, 400, 50);
            btnCandidato.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
            btnCandidato.addActionListener(evt -> escolherCandidato());
            getContentPane().add(btnCandidato);

            javax.swing.JButton btnEmpresa = new javax.swing.JButton("🏢 Entrar como Empresa");
            btnEmpresa.setBounds(50, 210, 400, 50);
            btnEmpresa.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
            btnEmpresa.addActionListener(evt -> escolherEmpresa());
            getContentPane().add(btnEmpresa);
        }

        setLocationRelativeTo(null);
    }

    private void escolherCandidato() {
        SessaoUsuario.iniciar(emailLogado, TipoUsuario.CANDIDATO);
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }

    private void escolherEmpresa() {
        SessaoUsuario.iniciar(emailLogado, TipoUsuario.EMPRESA);
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }

    private void abrirMenuAdmin() {
        SessaoUsuario.iniciar(emailLogado, TipoUsuario.ADMIN);
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }
}
