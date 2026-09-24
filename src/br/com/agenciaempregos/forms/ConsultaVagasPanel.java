package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class ConsultaVagasPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblArea;
    private javax.swing.JComboBox cmbArea;
    
    
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabela;
    private DefaultTableModel modeloTabela;
    private Integer idSelecionado = null;
    
    private static final String[] AREAS_PADRAO = {"Informatica", "Administrativo", "Comercial", "Financeiro", "Recursos Humanos", "Engenharia", "Saude", "Outra"};

    public ConsultaVagasPanel() {
        initComponents();
        cmbArea.addItem("Todas");
        for (String a : AREAS_PADRAO) cmbArea.addItem(a);
        carregarTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(900, 550));

        lblCabecalho = new javax.swing.JLabel();
        lblCabecalho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCabecalho.setText("Consulta de Vagas");
        lblCabecalho.setBounds(20, 15, 400, 30);
        add(lblCabecalho);

        lblArea = new javax.swing.JLabel("Filtrar por area:");
        lblArea.setBounds(20, 80, 150, 18);
        cmbArea = new javax.swing.JComboBox();
        cmbArea.setBounds(20, 100, 200, 26);
        add(lblArea);
        add(cmbArea);

        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Titulo", "Empresa", "Area", "Status"}) {
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

        

        
    }
    // </editor-fold>

    

    private void onSelecionarLinha(int linha) {
      
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        modeloTabela.setRowCount(0);
        java.util.List<br.com.agenciaempregos.model.Vaga> resultado;
        String texto = txtPesquisa.getText().trim();
        if (!texto.isEmpty()) {
            resultado = br.com.agenciaempregos.dao.VagaDAO.pesquisar(texto);
        } else {
            resultado = br.com.agenciaempregos.dao.VagaDAO.pesquisarPorArea((String) cmbArea.getSelectedItem());
        }
        for (br.com.agenciaempregos.model.Vaga v : resultado) {
            modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
        }
    }

    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Vaga v : br.com.agenciaempregos.dao.VagaDAO.listar()) {
            modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
        }
    }
}
