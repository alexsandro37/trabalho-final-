package br.com.agenciaempregos.model;

public class Candidato {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String area;
<<<<<<< HEAD
    private String emailUsuario;

    public Candidato(int id, String nome, String cpf, String email, String telefone, String area, String emailUsuario) {
=======

    public Candidato(int id, String nome, String cpf, String email, String telefone, String area) {
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.area = area;
<<<<<<< HEAD
        this.emailUsuario = emailUsuario;
=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

<<<<<<< HEAD
    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    @Override
    public String toString() { return nome; }
}
