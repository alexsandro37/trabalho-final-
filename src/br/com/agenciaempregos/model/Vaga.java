package br.com.agenciaempregos.model;

public class Vaga {

    private int id;
    private String titulo;
    private int empresaId;
    private String empresaNome;
    private String area;
    private String descricao;
<<<<<<< HEAD
    private String status;
=======
    private String status; // "Aberta" ou "Fechada"
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384

    public Vaga(int id, String titulo, int empresaId, String empresaNome, String area, String descricao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.empresaId = empresaId;
        this.empresaNome = empresaNome;
        this.area = area;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getEmpresaId() { return empresaId; }
    public void setEmpresaId(int empresaId) { this.empresaId = empresaId; }

    public String getEmpresaNome() { return empresaNome; }
    public void setEmpresaNome(String empresaNome) { this.empresaNome = empresaNome; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() { return titulo; }
}
