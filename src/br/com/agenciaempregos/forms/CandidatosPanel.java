package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class CandidatosPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblArea;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtArea;
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
    

    public CandidatosPanel() {
        initComponents();
        
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Candidatos");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblNome = new javax.swing.JLabel("Nome:");
        lblNome.setBounds(20, 80, 150, 18);
        txtNome = new javax.swing.JTextField();
        txtNome.setBounds(20, 100, 200, 26);
        lblCpf = new javax.swing.JLabel("CPF:");
        lblCpf.setBounds(240, 80, 150, 18);
        txtCpf = new javax.swing.JTextField();
        txtCpf.setBounds(240, 100, 200, 26);
        lblEmail = new javax.swing.JLabel("Email:");
        lblEmail.setBounds(460, 80, 150, 18);
        txtEmail = new javax.swing.JTextField();
        txtEmail.setBounds(460, 100, 200, 26);
        lblTelefone = new javax.swing.JLabel("Telefone:");
        lblTelefone.setBounds(680, 80, 150, 18);
        txtTelefone = new javax.swing.JTextField();
        txtTelefone.setBounds(680, 100, 200, 26);
        lblArea = new javax.swing.JLabel("Area de interesse:");
        lblArea.setBounds(20, 140, 150, 18);
        txtArea = new javax.swing.JTextField();
        txtArea.setBounds(20, 160, 200, 26);
        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefone);
        add(txtTelefone);
        add(lblArea);
        add(txtArea);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "CPF", "Email", "Telefone", "Area"}) {
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
    // </editor-fold>

    

    private void onSelecionarLinha(int linha) {
        int id = (int) modeloTabela.getValueAt(linha, 0);
        br.com.agenciaempregos.model.Candidato c = br.com.agenciaempregos.dao.CandidatoDAO.buscarPorId(id);
        if (c != null) {
            idSelecionado = c.getId();
            txtNome.setText(c.getNome());
            txtCpf.setText(c.getCpf());
            txtEmail.setText(c.getEmail());
            txtTelefone.setText(c.getTelefone());
            txtArea.setText(c.getArea());
        }
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Candidato c : br.com.agenciaempregos.dao.CandidatoDAO.pesquisar(txtPesquisa.getText().trim())) {
            modeloTabela.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getTelefone(), c.getArea()});
        }
    }

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtNome.getText().trim().isEmpty() || txtCpf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.dao.CandidatoDAO.cadastrar(txtNome.getText().trim(), txtCpf.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim(), txtArea.getText().trim(), "");
        JOptionPane.showMessageDialog(this, "Candidato cadastrado com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um candidato na tabela para editar.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNome.getText().trim().isEmpty() || txtCpf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        br.com.agenciaempregos.dao.CandidatoDAO.editar(idSelecionado, txtNome.getText().trim(), txtCpf.getText().trim(), txtEmail.getText().trim(), txtTelefone.getText().trim(), txtArea.getText().trim());
        JOptionPane.showMessageDialog(this, "Candidato atualizado com sucesso.");
        btnLimparActionPerformed(evt);
        carregarTabela();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um candidato na tabela para excluir.", "Atencao", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este registro?", "Confirmar exclusao", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            br.com.agenciaempregos.dao.CandidatoDAO.excluir(idSelecionado);
            btnLimparActionPerformed(evt);
            carregarTabela();
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        idSelecionado = null;
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtArea.setText("");
        tabela.clearSelection();
    }
    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Candidato c : br.com.agenciaempregos.dao.CandidatoDAO.listar()) {
            modeloTabela.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getTelefone(), c.getArea()});
        }
    }
}
