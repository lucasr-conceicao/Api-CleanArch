package br.com.ApiCleanArch.adapters.rest;

import br.com.ApiCleanArch.usecase.cliente.IRecuperarDadosCliente;
import br.com.ApiCleanArch.usecase.cliente.RecuperarDadosClienteResponse;
import br.com.ApiCleanArch.usecase.documento.IRecuperarConteudoDocumento;
import br.com.ApiCleanArch.usecase.documento.RecuperarConteudoDocumentoResponse;
import br.com.ApiCleanArch.usecase.proposta.IRecuperarDadosProposta;
import br.com.ApiCleanArch.usecase.proposta.RecuperarDadosPropostaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recuperar")
@RequiredArgsConstructor
public class Controller {

    private final IRecuperarConteudoDocumento recuperarConteudoDocumento;
    private final IRecuperarDadosCliente recuperarDadosCliente;
    private final IRecuperarDadosProposta recuperarDadosProposta;

    @GetMapping("/conteudo-documento")
    public ResponseEntity<RecuperarConteudoDocumentoResponse> getConteudoDocumento(
            @RequestHeader(name = "correlationID") String correlationID
    ){
        var conteudoDocumento
                = recuperarConteudoDocumento.getConteudoDocumento();
        return ResponseEntity.status(HttpStatus.OK).body(conteudoDocumento);
    }

    @GetMapping("/dados-cliente")
    public ResponseEntity<RecuperarDadosClienteResponse> getDadosCliente(){
        var dadosCliente = recuperarDadosCliente.getDadosCliente();
        return ResponseEntity.status(HttpStatus.OK).body(dadosCliente);
    }

    @GetMapping("/dados-proposta")
    public ResponseEntity<RecuperarDadosPropostaResponse> getDadosProposta(){
        var dadosProposta = recuperarDadosProposta.getDadosProposta();
        return ResponseEntity.status(HttpStatus.OK).body(dadosProposta);
    }
}
