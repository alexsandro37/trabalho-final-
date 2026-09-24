package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class VagasPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JComboBox cmbEmpresa;
    private javax.swing.JTextField txtArea;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JTextField txtDescricao;
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
    
    private void carregarComboEmpresas() {
        cmbEmpresa.removeAllItems();
        for (br.com.agenciaempregos.model.Empresa e : br.com.agenciaempregos.dao.EmpresaDAO.listar()) {
            cmbEmpresa.addItem(e);
        }
    }

    public VagasPanel() {
        initComponents();
        carregarComboEmpresas();
        cmbStatus.addItem("Aberta");
        cmbStatus.addItem("Fechada");
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Vagas");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblTitulo = new javax.swing.JLabel("Titulo da vaga:");
        lblTitulo.setBounds(20, 80, 150, 18);
        txtTitulo = new javax.swing.JTextField();
        txtTitulo.setBounds(20, 100, 200, 26);
        lblEmpresa = new javax.swing.JLabel("Empresa:");
        lblEmpresa.setBounds(240, 80, 150, 18);
        cmbEmpresa = new javax.swing.JComboBox();
        cmbEmpresa.setBounds(240, 100, 200, 26);
        lblArea = new javax.swing.JLabel("Area:");
        lblArea.setBounds(460, 80, 150, 18);
        txtArea = new javax.swing.JTextField();
        txtArea.setBounds(460, 100, 200, 26);
        lblStatus = new javax.swing.JLabel("Status:");
        lblStatus.setBounds(680, 80, 150, 18);
        cmbStatus = new javax.swing.JComboBox();
        cmbStatus.setBounds(680, 100, 200, 26);
        lblDescricao = new javax.swing.JLabel("Descricao:");
        lblDescricao.setBounds(20, 140, 150, 18);
        txtDescricao = new javax.swing.JTextField();
        txtDescricao.setBounds(20, 160, 200, 26);
        add(lblTitulo);
        add(txtTitulo);
        add(lblEmpresa);
        add(cmbEmpresa);
        add(lblArea);
        add(txtArea);
        add(lblStatus);
        add(cmbStatus);
        add(lblDescricao);
        add(txtDescricao);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Titulo", "Empresa", "Area", "Status"}) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabela = new javax.swing.JTable();
        tabela.setModel(modeloTabela);
        scrollTabela = new javax.swing.JScrollPane(tabela);
        scrollTabela.setBounds(20, 245, 860, 380);
        add(scrollTabela);
        tabela.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                onSelecionarLinha(tabela.getSelectedRow());
            }
        });

        lblPesquisa = new javax.swing.JLabel("Pesquisar:");
        lblPesquisa.setBounds(560, 202, 70, 20);
        add(lblPesquisa);

        txtPesquisa = new javax.swing.JTextField();
        txtPesquisa.setBounds(640, 200, 160, 26);
        add(txtPesquisa);

        btnPesquisar = new javax.swing.JButton("Buscar");
        btnPesquisar.setBounds(810, 200, 90, 30);
        btnPesquisar.addActionListener(evt -> btnPesquisarActionPerformed(evt));
        add(btnPesquisar);

        
        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnCadastrar.setBounds(20, 200, 120, 30);
        btnCadastrar.addActionListener(evt -> btnCadastrarActionPerformed(evt));
        add(btnCadastrar);

        btnEditar = new javax.swing.JButton("Editar");
        btnEditar.setBounds(150, 200, 120, 30);
        btnEditar.addActionListener(evt -> btnEditarActionPerformed(evt));
        add(btnEditar);

        btnExcluir = new javax.swing.JButton("Excluir");
        btnExcluir.setBounds(280, 200, 120, 30);
        btnExcluir.addActionListener(evt -> btnExcluirActionPerformed(evt));
        add(btnExcluir);

        btnLimpar = new javax.swing.JButton("Limpar");
        btnLimpar.setBounds(410, 200, 120, 30);
        btnLimpar.addActionListener(evt -> btnLimparActionPerformed(evt));
        add(btnLimpar);
        

        
    }
   
    private void onSelecionarLinha(int linha) {
        int id = (int) modeloTabela.getValueAt(linha, 0);
        br.com.agenciaempregos.model.Vaga v = br.com.agenciaempregos.dao.VagaDAO.buscarPorId(id);
        if (v != null) {
            idSelecionado = v.getId();
            txtTitulo.setText(v.getTitulo());
            txtArea.setText(v.getArea());
            txtDescricao.setText(v.getDescricao());
            cmbStatus.setSelectedItem(v.getStatus());
            for (int i = 0; i < cmbEmpresa.getItemCount(); i++) {
                br.com.agenciaempregos.model.Empresa emp = (br.com.agenciaempregos.model.Empresa) cmbEmpresa.getItemAt(i);
                if (emp.getId() == v.getEmpresaId()) { cmbEmpresa.setSelectedIndex(i); break; }
            }
        }
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Vaga v : br.com.agenciaempregos.dao.VagaDAO.pesquisar(txtPesquisa.getText().trim())) {
            modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
        }
    }

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtTitulo.getText().trim().isEmpty() || cmbEmpresa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios (a vaga precisa estar ligada a uma empresa).", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.model.Empresa empresa = (br.com.agenciaempregos.model.Empresa) cmbEmpresa.getSelectedItem();
        br.com.agenciaempregos.dao.VagaDAO.cadastrar(txtTitulo.getText().trim(), empresa.getId(), empresa.getNome(), txtArea.getText().trim(), txtDescricao.getText().trim(), (String) cmbStatus.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Vaga cadastrada com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma vaga na tabela para editar.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtTitulo.getText().trim().isEmpty() || cmbEmpresa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.model.Empresa empresa = (br.com.agenciaempregos.model.Empresa) cmbEmpresa.getSelectedItem();
        br.com.agenciaempregos.dao.VagaDAO.editar(idSelecionado, txtTitulo.getText().trim(), empresa.getId(), empresa.getNome(), txtArea.getText().trim(), txtDescricao.getText().trim(), (String) cmbStatus.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Vaga atualizada com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma vaga na tabela para excluir.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este registro?", "Confirmar exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            br.com.agenciaempregos.dao.VagaDAO.excluir(idSelecionado);
            btnLimparActionPerformed(evt);
            carregarTabela();
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        idSelecionado = null;
        txtTitulo.setText("");
        txtArea.setText("");
        txtDescricao.setText("");
        if (cmbEmpresa.getItemCount() > 0) cmbEmpresa.setSelectedIndex(0);
        if (cmbStatus.getItemCount() > 0) cmbStatus.setSelectedIndex(0);
        tabela.clearSelection();
    }
    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Vaga v : br.com.agenciaempregos.dao.VagaDAO.listar()) {
            modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
        }
    }
}
