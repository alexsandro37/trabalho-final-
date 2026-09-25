package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO em memoria. Nao ha banco de dados definido ainda (nao inventado).
 * Para trocar por JDBC/MySQL, troque a implementacao dos metodos mantendo
 * as mesmas assinaturas, assim os Panels nao precisam mudar.
 */
public class EmpresaDAO {

    private static final List<Empresa> lista = new ArrayList<>();
    private static int proximoId = 1;

    public static List<Empresa> listar() {
        return new ArrayList<>(lista);
    }

    public static List<Empresa> pesquisar(String termo) {
        List<Empresa> resultado = new ArrayList<>();
        String t = termo == null ? "" : termo.toLowerCase();
        for (Empresa e : lista) {
            if (e.getNome().toLowerCase().contains(t) || e.getCnpj().toLowerCase().contains(t)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public static Empresa buscarPorId(int id) {
        for (Empresa e : lista) {
            if (e.getId() == id) return e;
        }
        return null;
    }

<<<<<<< HEAD
    public static Empresa cadastrar(String nome, String cnpj, String email, String telefone, String emailUsuario) {
        Empresa e = new Empresa(proximoId++, nome, cnpj, email, telefone, emailUsuario);
=======
    public static Empresa cadastrar(String nome, String cnpj, String email, String telefone) {
        Empresa e = new Empresa(proximoId++, nome, cnpj, email, telefone);
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
        lista.add(e);
        return e;
    }

<<<<<<< HEAD
    public static Empresa buscarPorEmailUsuario(String emailUsuario) {
        for (Empresa e : lista) {
            if (e.getEmailUsuario() != null && e.getEmailUsuario().equals(emailUsuario)) {
                return e;
            }
        }
        return null;
    }

=======
>>>>>>> 359f2641e5ed2ef98d55c2a42e743dff5a2db384
    public static boolean editar(int id, String nome, String cnpj, String email, String telefone) {
        Empresa e = buscarPorId(id);
        if (e == null) return false;
        e.setNome(nome);
        e.setCnpj(cnpj);
        e.setEmail(email);
        e.setTelefone(telefone);
        return true;
    }

    public static boolean excluir(int id) {
        return lista.removeIf(e -> e.getId() == id);
    }
}
