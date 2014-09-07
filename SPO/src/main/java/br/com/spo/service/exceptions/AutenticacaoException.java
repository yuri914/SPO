package br.com.spo.service.exceptions;

public class AutenticacaoException extends Exception {

    private static final long serialVersionUID = -8962320608344630354L;
    
    public AutenticacaoException() {
        super("Usuário ou Senha incorreto.");
    }
}
