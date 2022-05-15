package br.com.ApiCleanArch.adapters.documento.exception;

public class DocumentoConteudoEmptyException extends RuntimeException {
    public DocumentoConteudoEmptyException(String msg) {
        super(msg);
    }
}
