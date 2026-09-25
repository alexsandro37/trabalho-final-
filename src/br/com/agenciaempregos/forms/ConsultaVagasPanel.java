package br.com.agenciaempregos.forms;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import br.com.agenciaempregos.util.SessaoUsuario;
import br.com.agenciaempregos.util.PermissaoUtil;
public class ConsultaVagasPanel extends javax.swing.JPanel {

    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblArea;
    private javax.swing.JComboBox cmbArea;
    
    
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnCandidatar;
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

        btnCandidatar = new javax.swing.JButton("Candidatar-se");
        btnCandidatar.setBounds(20, 140, 140, 30);
        btnCandidatar.addActionListener(evt -> btnCandidatarActionPerformed(evt));
        add(btnCandidatar);

        

        
    }
    // </editor-fold>

    

    private void onSelecionarLinha(int linha) {
        idSelecionado = (int) modeloTabela.getValueAt(linha, 0);
    }

    private void btnCandidatarActionPerformed(java.awt.event.ActionEvent evt) {
        if (!PermissaoUtil.podeCandidatarVaga()) {
            JOptionPane.showMessageDialog(this, "Somente candidatos podem se candidatar a vagas.", "Acesso negado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (idSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma vaga.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        br.com.agenciaempregos.model.Vaga vaga =
                br.com.agenciaempregos.dao.VagaDAO.buscarPorId(idSelecionado);

        if (vaga == null || !"Aberta".equalsIgnoreCase(vaga.getStatus())) {
            JOptionPane.showMessageDialog(this, "Esta vaga não está aberta para candidatura.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        br.com.agenciaempregos.model.Candidato candidato = SessaoUsuario.getCandidatoAtual();
        if (candidato == null) {
            JOptionPane.showMessageDialog(this, "Perfil de candidato não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (br.com.agenciaempregos.model.Candidatura c :
                br.com.agenciaempregos.dao.CandidaturaDAO.listar()) {
            if (c.getCandidatoId() == candidato.getId() && c.getVagaId() == vaga.getId()) {
                JOptionPane.showMessageDialog(this, "Você já se candidatou a esta vaga.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        br.com.agenciaempregos.dao.CandidaturaDAO.cadastrar(
                candidato.getId(), candidato.getNome(),
                vaga.getId(), vaga.getTitulo(), vaga.getEmpresaNome());

        JOptionPane.showMessageDialog(this, "Candidatura realizada com sucesso.");
    }

    private boolean vagaVisivelParaCandidato(br.com.agenciaempregos.model.Vaga vaga) {
        return SessaoUsuario.isCandidato()
                && "Aberta".equalsIgnoreCase(vaga.getStatus());
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
            if (vagaVisivelParaCandidato(v)) {
                modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
            }
        }
    }

    

    private void carregarTabela() {
        modeloTabela.setRowCount(0);
        for (br.com.agenciaempregos.model.Vaga v : br.com.agenciaempregos.dao.VagaDAO.listar()) {
            if (vagaVisivelParaCandidato(v)) {
                modeloTabela.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresaNome(), v.getArea(), v.getStatus()});
            }
        }
    }
}
