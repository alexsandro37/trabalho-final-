package br.com.agenciaempregos.util;

import br.com.agenciaempregos.dao.VagaDAO;
import br.com.agenciaempregos.model.Candidatura;
import br.com.agenciaempregos.model.Vaga;

public class PermissaoUtil {

    public static boolean podeAcessarCandidatos() {
        return SessaoUsuario.isAdmin();
    }

    public static boolean podeAcessarEmpresas() {
        return SessaoUsuario.isAdmin();
    }

    public static boolean podeAcessarVagas() {
        return SessaoUsuario.isAdmin() || SessaoUsuario.isEmpresa();
    }

    public static boolean podeCriarEditarVagas() {
        return SessaoUsuario.isAdmin() || SessaoUsuario.isEmpresa();
    }

    public static boolean podePesquisarVagas() {
        return SessaoUsuario.isCandidato();
    }

    public static boolean podeCandidatarVaga() {
        return SessaoUsuario.isCandidato()
                && SessaoUsuario.getCandidatoAtual() != null;
    }

    public static boolean podeVerCandidaturas() {
        return SessaoUsuario.isAdmin() || SessaoUsuario.isCandidato() || SessaoUsuario.isEmpresa();
    }

    public static boolean podeAcessarProcessosSeletivos() {
        return SessaoUsuario.isAdmin() || SessaoUsuario.isEmpresa();
    }

    public static boolean podeAcessarConsultaCandidatos() {
        return SessaoUsuario.isAdmin();
    }

    public static boolean podeAcessarConsultaVagas() {
        return SessaoUsuario.isCandidato();
    }

    public static boolean candidatoPodeVer(Candidatura c) {
        return SessaoUsuario.isAdmin()
                || (SessaoUsuario.isCandidato()
                && SessaoUsuario.getCandidatoAtual() != null
                && c.getCandidatoId() == SessaoUsuario.getCandidatoAtual().getId());
    }

    public static boolean empresaPodeVer(Candidatura c) {
        if (SessaoUsuario.isAdmin()) return true;
        if (!SessaoUsuario.isEmpresa() || SessaoUsuario.getEmpresaAtual() == null) return false;

        Vaga vaga = VagaDAO.buscarPorId(c.getVagaId());
        return vaga != null && vaga.getEmpresaId() == SessaoUsuario.getEmpresaAtual().getId();
    }

    public static boolean empresaPodeAlterarVaga(Vaga vaga) {
        return SessaoUsuario.isAdmin()
                || (SessaoUsuario.isEmpresa()
                && SessaoUsuario.getEmpresaAtual() != null
                && vaga != null
                && vaga.getEmpresaId() == SessaoUsuario.getEmpresaAtual().getId());
    }

    public static void validarAcesso(String funcao) throws SecurityException {
        if (!SessaoUsuario.isLogado()) {
            throw new SecurityException("Usuário não autenticado.");
        }
    }
}
