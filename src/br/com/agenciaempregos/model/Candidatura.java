package br.com.agenciaempregos.model;

public class Candidatura {

    public static final String STATUS_REALIZADA = "Candidatura realizada";
    public static final String STATUS_EM_ANALISE = "Em análise";
    public static final String STATUS_EM_PROCESSO = "Em processo seletivo";
    public static final String STATUS_APROVADO = "Resultado: Aprovado";
    public static final String STATUS_REPROVADO = "Resultado: Reprovado";

    private int id;
    private int candidatoId;
    private String candidatoNome;
    private int vagaId;
    private String vagaTitulo;
    private String empresaNome;
    private String status;

    public Candidatura(int id, int candidatoId, String candidatoNome, int vagaId, String vagaTitulo, String empresaNome, String status) {
        this.id = id;
        this.candidatoId = candidatoId;
        this.candidatoNome = candidatoNome;
        this.vagaId = vagaId;
        this.vagaTitulo = vagaTitulo;
        this.empresaNome = empresaNome;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCandidatoId() { return candidatoId; }
    public void setCandidatoId(int candidatoId) { this.candidatoId = candidatoId; }

    public String getCandidatoNome() { return candidatoNome; }
    public void setCandidatoNome(String candidatoNome) { this.candidatoNome = candidatoNome; }

    public int getVagaId() { return vagaId; }
    public void setVagaId(int vagaId) { this.vagaId = vagaId; }

    public String getVagaTitulo() { return vagaTitulo; }
    public void setVagaTitulo(String vagaTitulo) { this.vagaTitulo = vagaTitulo; }

    public String getEmpresaNome() { return empresaNome; }
    public void setEmpresaNome(String empresaNome) { this.empresaNome = empresaNome; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
