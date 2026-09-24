package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Usuario;
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

    public static Usuario cadastrar(String email, String senha) {
        Usuario u = new Usuario(email, SenhaUtil.gerarHash(senha));
        lista.add(u);
        return u;
    }

    /** Retorna true se o email existe e a senha confere. */
    public static boolean autenticar(String email, String senha) {
        Usuario u = buscarPorEmail(email);
        if (u == null) return false;
        return u.getSenhaHash().equals(SenhaUtil.gerarHash(senha));
    }
}
