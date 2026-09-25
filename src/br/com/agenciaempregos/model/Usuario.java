package br.com.agenciaempregos.model;

public class Usuario {

    private String email;
    private String senhaHash;
    private TipoUsuario tipo;

    public Usuario(String email, String senhaHash, TipoUsuario tipo) {
        this.email = email;
        this.senhaHash = senhaHash;
        this.tipo = tipo;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }

    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
}
