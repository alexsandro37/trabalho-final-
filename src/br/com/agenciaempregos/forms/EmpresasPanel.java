package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class EmpresasPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTelefone;
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
    

    public EmpresasPanel() {
        initComponents();
        
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Empresas");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblNome = new javax.swing.JLabel("Nome:");
        lblNome.setBounds(20, 80, 150, 18);
        txtNome = new javax.swing.JTextField();
        txtNome.setBounds(20, 100, 200, 26);
        lblCnpj = new javax.swing.JLabel("CNPJ:");
        lblCnpj.setBounds(240, 80, 150, 18);
        txtCnpj = new javax.swing.JTextField();
        txtCnpj.setBounds(240, 100, 200, 26);
        lblEmail = new javax.swing.JLabel("Email:");
        lblEmail.setBounds(460, 80, 150, 18);
        txtEmail = new javax.swing.JTextField();
        txtEmail.setBounds(460, 100, 200, 26);
        lblTelefone = new javax.swing.JLabel("Telefone:");
        lblTelefone.setBounds(680, 80, 150, 18);
        txtTelefone = new javax.swing.JTextField();
        txtTelefone.setBounds(680, 100, 200, 26);
        add(lblNome);
        add(txtNome);
        add(lblCnpj);
        add(txtCnpj);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefone);
        add(txtTelefone);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "CNPJ", "Email", "Telefone"}) {
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
        br.com.agenciaempregos.model.Empresa e = br.com.agenciaempregos.dao.EmpresaDAO.buscarPorId(id);
        if (e != null) {
            idSelecionado = e.getId();
            txtNome.setText(e.getNome());
            txtCnpj.setText(e.getCnpj());
            txtEmail.setText(e.getEmail());
            txtTelefone.setText(e.getTelefone());
        }
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Empresa e : br.com.agenciaempregos.dao.EmpresaDAO.pesquisar(txtPesquisa.getText().trim())) {
            modeloTabela.addRow(new Object[]{e.getId(), e.getNome(), e.getCnpj(), e.getEmail(), e.getTelefone()});
        }
    }

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtNome.getText().trim().isEmpty() || txtCnpj.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
<<<<<<< HEAD
        br.com.agenciaempregos.dao.EmpresaDAO.cadastrar(txtNome.getText().trim(), txtCnpj.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim(), "");
=======
        br.com.agenciaempregos.dao.EmpresaDAO.cadastrar(txtNome.getText().trim(), txtCnpj.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim());
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        JOptionPane.showMessageDialog(this, "Empresa cadastrada com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma empresa na tabela para editar.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNome.getText().trim().isEmpty() || txtCnpj.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.dao.EmpresaDAO.editar(idSelecionado, txtNome.getText().trim(), txtCnpj.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim());
        JOptionPane.showMessageDialog(this, "Empresa atualizada com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma empresa na tabela para excluir.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este registro?", "Confirmar exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            br.com.agenciaempregos.dao.EmpresaDAO.excluir(idSelecionado);
            btnLimparActionPerformed(evt);
            carregarTabela();
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        idSelecionado = null;
        txtNome.setText("");
        txtCnpj.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        tabela.clearSelection();
    }
    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Empresa e : br.com.agenciaempregos.dao.EmpresaDAO.listar()) {
            modeloTabela.addRow(new Object[]{e.getId(), e.getNome(), e.getCnpj(), e.getEmail(), e.getTelefone()});
        }
    }
}
