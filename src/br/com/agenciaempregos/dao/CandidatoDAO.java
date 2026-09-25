package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Candidato;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {

    private static final List<Candidato> lista = new ArrayList<>();
    private static int proximoId = 1;

    public static List<Candidato> listar() {
        return new ArrayList<>(lista);
    }

    public static List<Candidato> pesquisar(String termo) {
        List<Candidato> resultado = new ArrayList<>();
        String t = termo == null ? "" : termo.toLowerCase();
        for (Candidato c : lista) {
            if (c.getNome().toLowerCase().contains(t) || c.getArea().toLowerCase().contains(t)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public static Candidato buscarPorId(int id) {
        for (Candidato c : lista) {
            if (c.getId() == id) return c;
        }
        return null;
    }

<<<<<<< HEAD
    public static Candidato cadastrar(String nome, String cpf, String email, String telefone, String area, String emailUsuario) {
        Candidato c = new Candidato(proximoId++, nome, cpf, email, telefone, area, emailUsuario);
=======
    public static Candidato cadastrar(String nome, String cpf, String email, String telefone, String area) {
        Candidato c = new Candidato(proximoId++, nome, cpf, email, telefone, area);
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        lista.add(c);
        return c;
    }

<<<<<<< HEAD
    public static Candidato buscarPorEmailUsuario(String emailUsuario) {
        for (Candidato c : lista) {
            if (c.getEmailUsuario() != null && c.getEmailUsuario().equals(emailUsuario)) {
                return c;
            }
        }
        return null;
    }

=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    public static boolean editar(int id, String nome, String cpf, String email, String telefone, String area) {
        Candidato c = buscarPorId(id);
        if (c == null) return false;
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEmail(email);
        c.setTelefone(telefone);
        c.setArea(area);
        return true;
    }

    public static boolean excluir(int id) {
        return lista.removeIf(c -> c.getId() == id);
    }
}
