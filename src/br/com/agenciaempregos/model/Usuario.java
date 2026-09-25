package br.com.agenciaempregos.model;

public class Usuario {

    private String email;
    private String senhaHash;
<<<<<<< HEAD
    private TipoUsuario tipo;

    public Usuario(String email, String senhaHash, TipoUsuario tipo) {
        this.email = email;
        this.senhaHash = senhaHash;
        this.tipo = tipo;
=======

    public Usuario(String email, String senhaHash) {
        this.email = email;
        this.senhaHash = senhaHash;
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
<<<<<<< HEAD

    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
}
