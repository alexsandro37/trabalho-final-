package br.com.agenciaempregos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Gera hash SHA-256 da senha, para nunca guardar a senha em texto puro
 * (mesmo em memoria).
 */
public class SenhaUtil {

    public static String gerarHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(senha.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException ex) {
            throw new RuntimeException("Erro ao gerar hash da senha.", ex);
        }
    }
}
