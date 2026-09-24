package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Candidatura;
import java.util.ArrayList;
import java.util.List;

public class CandidaturaDAO {

    private static final List<Candidatura> lista = new ArrayList<>();
    private static int proximoId = 1;

    public static List<Candidatura> listar() {
        return new ArrayList<>(lista);
    }

    public static Candidatura buscarPorId(int id) {
        for (Candidatura c : lista) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public static Candidatura cadastrar(int candidatoId, String candidatoNome, int vagaId, String vagaTitulo, String empresaNome) {
        Candidatura c = new Candidatura(proximoId++, candidatoId, candidatoNome, vagaId, vagaTitulo, empresaNome, Candidatura.STATUS_REALIZADA);
        lista.add(c);
        return c;
    }

    public static boolean atualizarStatus(int id, String novoStatus) {
        Candidatura c = buscarPorId(id);
        if (c == null) return false;
        c.setStatus(novoStatus);
        return true;
    }

    public static boolean excluir(int id) {
        return lista.removeIf(c -> c.getId() == id);
    }
}
