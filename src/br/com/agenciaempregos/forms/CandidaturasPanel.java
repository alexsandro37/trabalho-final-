package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class CandidaturasPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCandidato;
    private javax.swing.JLabel lblVaga;
    private javax.swing.JComboBox cmbCandidato;
    private javax.swing.JComboBox cmbVaga;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private DefaultTableModel modeloTabela;
    private Integer idSelecionado = null;
    
    private void carregarCombos() {
        cmbCandidato.removeAllItems();
        for (br.com.agenciaempregos.model.Candidato c : br.com.agenciaempregos.dao.CandidatoDAO.listar()) {
            cmbCandidato.addItem(c);
        }
        cmbVaga.removeAllItems();
        for (br.com.agenciaempregos.model.Vaga v : br.com.agenciaempregos.dao.VagaDAO.listar()) {
            cmbVaga.addItem(v);
        }
    }

    public CandidaturasPanel() {
        initComponents();
        carregarCombos();
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Candidaturas");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblCandidato = new javax.swing.JLabel("Candidato:");
        lblCandidato.setBounds(20, 80, 150, 18);
        cmbCandidato = new javax.swing.JComboBox();
        cmbCandidato.setBounds(20, 100, 200, 26);
        lblVaga = new javax.swing.JLabel("Vaga:");
        lblVaga.setBounds(240, 80, 150, 18);
        cmbVaga = new javax.swing.JComboBox();
        cmbVaga.setBounds(240, 100, 200, 26);
        add(lblCandidato);
        add(cmbCandidato);
        add(lblVaga);
        add(cmbVaga);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Candidato", "Vaga", "Empresa", "Status"}) {
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

        
        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(20, 140, 120, 30);
        btnCadastrar.addActionListener(evt -> btnCadastrarActionPerformed(evt));
        add(btnCadastrar);

        btnEditar = new javax.swing.JButton("Editar");
        btnEditar.setBounds(150, 140, 120, 30);
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));
        add(btnEditar);

        btnExcluir = new javax.swing.JButton("Excluir");
        btnExcluir.setBounds(280, 140, 120, 30);
        btnExcluir.addActionListener(evt -> btnExcluirActionPerformed(evt));
        add(btnExcluir);

        btnLimpar = new javax.swing.JButton("Limpar");
        btnLimpar.setBounds(410, 140, 120, 30);
        btnLimpar.addActionListener(evt -> btnLimparActionPerformed(evt));
        add(btnLimpar);
        

        
    }
    // </editor-fold>

    

    private void onSelecionarLinha(int linha) {
        int id = (int) modeloTabela.getValueAt(linha, 0);
        idSelecionado = id;
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        String t = txtPesquisa.getText().trim().toLowerCase();
        for (br.com.agenciaempregos.model.Candidatura c : br.com.agenciaempregos.dao.CandidaturaDAO.listar()) {
            if (c.getCandidatoNome().toLowerCase().contains(t) || c.getVagaTitulo().toLowerCase().contains(t) || c.getEmpresaNome().toLowerCase().contains(t)) {
                modeloTabela.addRow(new Object[]{c.getId(), c.getCandidatoNome(), c.getVagaTitulo(), c.getEmpresaNome(), c.getStatus()});
            }
        }
    }

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        carregarCombos();
        if (cmbCandidato.getSelectedItem() == null || cmbVaga.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Cadastre pelo menos um candidato e uma vaga antes de lancar uma candidatura.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.model.Candidato cand = (br.com.agenciaempregos.model.Candidato) cmbCandidato.getSelectedItem();
        br.com.agenciaempregos.model.Vaga vaga = (br.com.agenciaempregos.model.Vaga) cmbVaga.getSelectedItem();
        br.com.agenciaempregos.dao.CandidaturaDAO.cadastrar(cand.getId(), cand.getNome(), vaga.getId(), vaga.getTitulo(), vaga.getEmpresaNome());
        JOptionPane.showMessageDialog(this, "Candidatura registrada com sucesso.");
        carregarTabela();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Para alterar o status de uma candidatura, use a tela \"Processos Seletivos\".", "Informacao", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma candidatura na tabela para excluir.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este registro?", "Confirmar exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            br.com.agenciaempregos.dao.CandidaturaDAO.excluir(idSelecionado);
            btnLimparActionPerformed(evt);
            carregarTabela();
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        idSelecionado = null;
        if (cmbCandidato.getItemCount() > 0) cmbCandidato.setSelectedIndex(0);
        if (cmbVaga.getItemCount() > 0) cmbVaga.setSelectedIndex(0);
        tabela.clearSelection();
    }
    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Candidatura c : br.com.agenciaempregos.dao.CandidaturaDAO.listar()) {
            modeloTabela.addRow(new Object[]{c.getId(), c.getCandidatoNome(), c.getVagaTitulo(), c.getEmpresaNome(), c.getStatus()});
        }
    }
}
