package br.com.agenciaempregos.forms;

import br.com.agenciaempregos.dao.CandidaturaDAO;
import br.com.agenciaempregos.dao.CandidatoDAO;
import br.com.agenciaempregos.dao.EmpresaDAO;
import br.com.agenciaempregos.dao.VagaDAO;
import br.com.agenciaempregos.util.EstiloUtil;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DashboardPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblTitulo;
    private JPanel painelCards;

    public DashboardPanel() {
        initComponents();
        atualizarCards();
    }

    private void initComponents() {
        setLayout(null);
        setBackground(EstiloUtil.COR_FUNDO);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblTitulo = new javax.swing.JLabel("Exibiçao de dados");
        lblTitulo.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 22));
        lblTitulo.setBounds(20, 15, 400, 35);
        add(lblTitulo);

        painelCards = new JPanel(new java.awt.GridLayout(1, 5, 15, 0));
        painelCards.setBounds(20, 70, 860, 130);
        painelCards.setOpaque(false);
        add(painelCards);
    }

    private JPanel criarCard(String titulo, int valor, Color cor) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblValor = new JLabel(String.valueOf(valor));
        lblValor.setFont(new Font(EstiloUtil.FONTE, Font.BOLD, 30));
        lblValor.setForeground(cor);
        lblValor.setBounds(15, 15, 140, 40);
        card.add(lblValor);

        JLabel lblNome = new JLabel(titulo);
        lblNome.setFont(new Font(EstiloUtil.FONTE, Font.PLAIN, 13));
        lblNome.setBounds(15, 60, 160, 40);
        card.add(lblNome);

        return card;
    }

   
    public void atualizarCards() {
        painelCards.removeAll();
        painelCards.add(criarCard("Empresas", EmpresaDAO.listar().size(), EstiloUtil.COR_PRIMARIA));
        painelCards.add(criarCard("Candidatos", CandidatoDAO.listar().size(), new Color(0, 150, 136)));
        painelCards.add(criarCard("Vagas", VagaDAO.listar().size(), new Color(255, 152, 0)));
        painelCards.add(criarCard("Candidaturas", CandidaturaDAO.listar().size(), new Color(156, 39, 176)));
        painelCards.add(criarCard("Processos ativos", CandidaturaDAO.listar().size(), new Color(233, 30, 99)));
        painelCards.revalidate();
        painelCards.repaint();
    }
}
