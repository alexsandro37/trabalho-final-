package br.com.agenciaempregos.model;

public class Empresa {

    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
<<<<<<< HEAD
    private String emailUsuario;

    public Empresa(int id, String nome, String cnpj, String email, String telefone, String emailUsuario) {
=======

    public Empresa(int id, String nome, String cnpj, String email, String telefone) {
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
<<<<<<< HEAD
        this.emailUsuario = emailUsuario;
=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

<<<<<<< HEAD
    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    @Override
    public String toString() { return nome; }
}
