package br.com.agenciaempregos.util;

import br.com.agenciaempregos.dao.CandidatoDAO;
import br.com.agenciaempregos.dao.EmpresaDAO;
import br.com.agenciaempregos.model.TipoUsuario;
import br.com.agenciaempregos.model.Candidato;
import br.com.agenciaempregos.model.Empresa;

public class SessaoUsuario {

    private static String emailLogado;
    private static TipoUsuario tipoUsuario;
    private static Candidato candidatoAtual;
    private static Empresa empresaAtual;

    public static void iniciar(String email, TipoUsuario tipo) {
        emailLogado = email;
        tipoUsuario = tipo;
        candidatoAtual = null;
        empresaAtual = null;

        // Carrega o perfil vinculado ao usuário autenticado.
        if (tipo == TipoUsuario.CANDIDATO) {
            candidatoAtual = CandidatoDAO.buscarPorEmailUsuario(email);
        } else if (tipo == TipoUsuario.EMPRESA) {
            empresaAtual = EmpresaDAO.buscarPorEmailUsuario(email);
        }
    }

    public static void encerrar() {
        emailLogado = null;
        tipoUsuario = null;
        candidatoAtual = null;
        empresaAtual = null;
    }

    public static boolean isLogado() { return emailLogado != null; }
    public static String getEmailLogado() { return emailLogado; }
    public static TipoUsuario getTipoUsuario() { return tipoUsuario; }

    public static boolean isAdmin() { return tipoUsuario == TipoUsuario.ADMIN; }
    public static boolean isCandidato() { return tipoUsuario == TipoUsuario.CANDIDATO; }
    public static boolean isEmpresa() { return tipoUsuario == TipoUsuario.EMPRESA; }

    public static Candidato getCandidatoAtual() { return candidatoAtual; }
    public static void setCandidatoAtual(Candidato candidato) { candidatoAtual = candidato; }

    public static Empresa getEmpresaAtual() { return empresaAtual; }
    public static void setEmpresaAtual(Empresa empresa) { empresaAtual = empresa; }
}
