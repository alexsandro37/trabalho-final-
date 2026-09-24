package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ProcessosSeletivosPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JComboBox cmbStatus;
    
    private javax.swing.JButton btnAtualizarStatus;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private DefaultTableModel modeloTabela;
    private Integer idSelecionado = null;
    

    public ProcessosSeletivosPanel() {
        initComponents();
        cmbStatus.addItem(br.com.agenciaempregos.model.Candidatura.STATUS_REALIZADA);
        cmbStatus.addItem(br.com.agenciaempregos.model.Candidatura.STATUS_EM_ANALISE);
        cmbStatus.addItem(br.com.agenciaempregos.model.Candidatura.STATUS_EM_PROCESSO);
        cmbStatus.addItem(br.com.agenciaempregos.model.Candidatura.STATUS_APROVADO);
        cmbStatus.addItem(br.com.agenciaempregos.model.Candidatura.STATUS_REPROVADO);
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Processos Seletivos");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblStatus = new javax.swing.JLabel("Novo status:");
        lblStatus.setBounds(20, 80, 150, 18);
        cmbStatus = new javax.swing.JComboBox();
        cmbStatus.setBounds(20, 100, 200, 26);
        add(lblStatus);
        add(cmbStatus);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Candidato", "Vaga", "Empresa", "Status atual"}) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabela = new javax.swing.JTable();
        tabela.setModel(modeloTabela);
        scrollTabela = new javax.swing.JScrollPane(tabela);
        scrollTabela.setBounds(20, 185, 860, 380);
        add(scrollTabela);
        tabela.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                onSelecionarLinha(tabela.getSelectedRow());
            }
        });

        lblPesquisa = new javax.swing.JLabel("Pesquisar:");
        lblPesquisa.setBounds(560, 142, 70, 20);
        add(lblPesquisa);

        txtPesquisa = new javax.swing.JTextField();
        txtPesquisa.setBounds(640, 140, 160, 26);
        add(txtPesquisa);

        btnPesquisar = new javax.swing.JButton("Buscar");
        btnPesquisar.setBounds(810, 140, 90, 30);
        btnPesquisar.addActionListener(evt -> btnPesquisarActionPerformed(evt));
        add(btnPesquisar);

        

        btnAtualizarStatus = new javax.swing.JButton("Atualizar Status");
        btnAtualizarStatus.setBounds(240, 140, 170, 30);
        btnAtualizarStatus.addActionListener(evt -> btnAtualizarStatusActionPerformed(evt));
        add(btnAtualizarStatus);
    }
    // </editor-fold>

    private void btnAtualizarStatusActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma candidatura na tabela para atualizar o status.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.dao.CandidaturaDAO.atualizarStatus(idSelecionado, (String) cmbStatus.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Status atualizado com sucesso.");
        carregarTabela();
    }

    private void onSelecionarLinha(int linha) {
        idSelecionado = (int) modeloTabela.getValueAt(linha, 0);
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        String t = txtPesquisa.getText().trim().toLowerCase();
        for (br.com.agenciaempregos.model.Candidatura c : br.com.agenciaempregos.dao.CandidaturaDAO.listar()) {
            if (c.getCandidatoNome().toLowerCase().contains(t) || c.getVagaTitulo().toLowerCase().contains(t)) {
                modeloTabela.addRow(new Object[]{c.getId(), c.getCandidatoNome(), c.getVagaTitulo(), c.getEmpresaNome(), c.getStatus()});
            }
        }
    }

    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Candidatura c : br.com.agenciaempregos.dao.CandidaturaDAO.listar()) {
            modeloTabela.addRow(new Object[]{c.getId(), c.getCandidatoNome(), c.getVagaTitulo(), c.getEmpresaNome(), c.getStatus()});
        }
    }
}
