package br.com.spo.service.exceptions;

public class BusinessException extends Exception {
    
    private static final long serialVersionUID = 2152653587682894694L;

    public BusinessException() {
        super("Excessão de negócio");
    }
}
