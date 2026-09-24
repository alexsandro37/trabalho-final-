package br.com.agenciaempregos.dao;

import br.com.agenciaempregos.model.Vaga;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {

    private static final List<Vaga> lista = new ArrayList<>();
    private static int proximoId = 1;

    public static List<Vaga> listar() {
        return new ArrayList<>(lista);
    }

    public static List<Vaga> pesquisar(String termo) {
        List<Vaga> resultado = new ArrayList<>();
        String t = termo == null ? "" : termo.toLowerCase();
        for (Vaga v : lista) {
            if (v.getTitulo().toLowerCase().contains(t)
                    || v.getArea().toLowerCase().contains(t)
                    || v.getEmpresaNome().toLowerCase().contains(t)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public static List<Vaga> pesquisarPorArea(String area) {
        List<Vaga> resultado = new ArrayList<>();
        if (area == null || area.isEmpty() || area.equals("Todas")) return listar();
        for (Vaga v : lista) {
            if (v.getArea().equalsIgnoreCase(area)) resultado.add(v);
        }
        return resultado;
    }

    public static Vaga buscarPorId(int id) {
        for (Vaga v : lista) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public static Vaga cadastrar(String titulo, int empresaId, String empresaNome, String area, String descricao, String status) {
        Vaga v = new Vaga(proximoId++, titulo, empresaId, empresaNome, area, descricao, status);
        lista.add(v);
        return v;
    }

    public static boolean editar(int id, String titulo, int empresaId, String empresaNome, String area, String descricao, String status) {
        Vaga v = buscarPorId(id);
        if (v == null) return false;
        v.setTitulo(titulo);
        v.setEmpresaId(empresaId);
        v.setEmpresaNome(empresaNome);
        v.setArea(area);
        v.setDescricao(descricao);
        v.setStatus(status);
        return true;
    }

    public static boolean excluir(int id) {
        return lista.removeIf(v -> v.getId() == id);
    }
}
