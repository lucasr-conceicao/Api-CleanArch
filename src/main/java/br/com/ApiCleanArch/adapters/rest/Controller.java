package br.com.ApiCleanArch.adapters.rest;

import br.com.ApiCleanArch.usecase.cliente.IRecuperarDadosCliente;
import br.com.ApiCleanArch.usecase.cliente.RecuperarDadosClienteResponse;
import br.com.ApiCleanArch.usecase.documento.IRecuperarConteudoDocumento;
import br.com.ApiCleanArch.usecase.documento.RecuperarConteudoDocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recuperar")
@RequiredArgsConstructor
public class Controller {

    private final IRecuperarConteudoDocumento recuperarConteudoDocumento;
    private final IRecuperarDadosCliente recuperarDadosCliente;

    @GetMapping("/conteudo-documento")
    public ResponseEntity<RecuperarConteudoDocumentoResponse> getConteudoDocumento(){
        var conteudoDocumento
                = recuperarConteudoDocumento.getConteudoDocumento();
        return ResponseEntity.status(HttpStatus.OK).body(conteudoDocumento);
    }

    @GetMapping("/dados-cliente")
    public ResponseEntity<RecuperarDadosClienteResponse> getDadosCliente(){
        var dadosCliente = recuperarDadosCliente.getDadosCliente();
        return ResponseEntity.status(HttpStatus.OK).body(dadosCliente);
    }
}
