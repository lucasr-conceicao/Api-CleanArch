package br.com.ApiCleanArch.usecase.exception;

public class DocumentoConteudoEmptyException extends RuntimeException {
    public DocumentoConteudoEmptyException(String msg) {
        super(msg);
    }
}
