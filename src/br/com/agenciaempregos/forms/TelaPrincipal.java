package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TelaPrincipal extends javax.swing.JFrame {

    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JLabel lblLogo;

    private DashboardPanel dashboardPanel;

    public TelaPrincipal() {
        initComponents();
        montarMenu();
        abrirDashboard();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Agencia de Empregos");
        setMinimumSize(new java.awt.Dimension(1100, 650));
        getContentPane().setLayout(null);

        painelMenu = new javax.swing.JPanel();
        painelMenu.setLayout(null);
        painelMenu.setBackground(EstiloUtil.COR_MENU);
        painelMenu.setBounds(0, 0, 220, 650);
        getContentPane().add(painelMenu);

        lblLogo = new javax.swing.JLabel("Agencia de Empregos");
        lblLogo.setForeground(EstiloUtil.COR_TEXTO_CLARO);
        lblLogo.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 16));
        lblLogo.setBounds(15, 20, 190, 40);
        painelMenu.add(lblLogo);

        painelConteudo = new javax.swing.JPanel();
        painelConteudo.setLayout(new java.awt.BorderLayout());
        painelConteudo.setBackground(EstiloUtil.COR_FUNDO);
        painelConteudo.setBounds(220, 0, 880, 650);
        getContentPane().add(painelConteudo);

        pack();
        setLocationRelativeTo(null);
    }

    private void montarMenu() {
        String[] itens = {
            "Painel", "Empresas", "Candidatos", "Vagas",
            "Consulta de Vagas", "Consulta de Candidatos",
            "Candidaturas", "Processos Seletivos"
        };
        int y = 80;
        for (String item : itens) {
            JButton botao = criarBotaoMenu(item);
            botao.setBounds(0, y, 220, 45);
            botao.addActionListener(evt -> navegar(item));
            painelMenu.add(botao);
            y += 45;
        }
    }

    private JButton criarBotaoMenu(String texto) {
        JButton botao = new JButton(texto);
        botao.setHorizontalAlignment(JButton.LEFT);
        botao.setBorder(new EmptyBorder(0, 20, 0, 0));
        botao.setBackground(EstiloUtil.COR_MENU);
        botao.setForeground(EstiloUtil.COR_TEXTO_CLARO);
        botao.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.addChangeListener(e -> {
            if (botao.getModel().isRollover()) {
                botao.setBackground(EstiloUtil.COR_MENU_HOVER);
            } else {
                botao.setBackground(EstiloUtil.COR_MENU);
            }
        });
        return botao;
    }

    /** Troca a tela exibida em painelConteudo, sem abrir novas janelas. */
    private void navegar(String tela) {
        JPanel novoPainel;
        switch (tela) {
            case "Dashboard":
                abrirDashboard();
                return;
            case "Empresas":
                novoPainel = new EmpresasPanel();
                break;
            case "Candidatos":
                novoPainel = new CandidatosPanel();
                break;
            case "Vagas":
                novoPainel = new VagasPanel();
                break;
            case "Consulta de Vagas":
                novoPainel = new ConsultaVagasPanel();
                break;
            case "Consulta de Candidatos":
                novoPainel = new ConsultaCandidatosPanel();
                break;
            case "Candidaturas":
                novoPainel = new CandidaturasPanel();
                break;
            case "Processos Seletivos":
                novoPainel = new ProcessosSeletivosPanel();
                break;
            default:
                return;
        }
        trocarPainel(novoPainel);
    }

    private void abrirDashboard() {
        dashboardPanel = new DashboardPanel();
        trocarPainel(dashboardPanel);
    }

    private void trocarPainel(JPanel painel) {
        painelConteudo.removeAll();
        painelConteudo.add(painel, java.awt.BorderLayout.CENTER);
        painelConteudo.revalidate();
        painelConteudo.repaint();
    }
}
