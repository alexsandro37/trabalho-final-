package br.com.agenciaempregos.model;

public class Empresa {

    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String emailUsuario;

    public Empresa(int id, String nome, String cnpj, String email, String telefone, String emailUsuario) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.emailUsuario = emailUsuario;
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

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    @Override
    public String toString() { return nome; }
}
