package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Usuario;
<<<<<<< HEAD
import br.com.agenciaempregos.model.TipoUsuario;
=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
import br.com.agenciaempregos.util.SenhaUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO em memoria (some ao fechar o programa). Para persistir entre
 * execucoes, trocar por um banco (ex: SQLite) mantendo as mesmas
 * assinaturas de metodo.
 */
public class UsuarioDAO {

    private static final List<Usuario> lista = new ArrayList<>();

    public static boolean emailJaCadastrado(String email) {
        return buscarPorEmail(email) != null;
    }

    private static Usuario buscarPorEmail(String email) {
        for (Usuario u : lista) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

<<<<<<< HEAD
    public static Usuario cadastrar(String email, String senha, TipoUsuario tipo) {
        Usuario u = new Usuario(email, SenhaUtil.gerarHash(senha), tipo);
=======
    public static Usuario cadastrar(String email, String senha) {
        Usuario u = new Usuario(email, SenhaUtil.gerarHash(senha));
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        lista.add(u);
        return u;
    }

<<<<<<< HEAD
    /** Retorna o usuário se email e senha conferem, null caso contrário. */
    public static Usuario autenticar(String email, String senha) {
        Usuario u = buscarPorEmail(email);
        if (u == null) return null;
        if (u.getSenhaHash().equals(SenhaUtil.gerarHash(senha))) {
            return u;
        }
        return null;
=======
    /** Retorna true se o email existe e a senha confere. */
    public static boolean autenticar(String email, String senha) {
        Usuario u = buscarPorEmail(email);
        if (u == null) return false;
        return u.getSenhaHash().equals(SenhaUtil.gerarHash(senha));
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    }
}
