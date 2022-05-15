package br.com.ApiCleanArch.adapters.rest;

import br.com.ApiCleanArch.usecase.IRecuperarConteudoDocumento;
import br.com.ApiCleanArch.usecase.RecuperarConteudoDocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recuperar/conteudo-documento")
@RequiredArgsConstructor
public class ConteudoDocumentoController {

    private final IRecuperarConteudoDocumento recuperarConteudoDocumento;

    @GetMapping()
    public ResponseEntity<RecuperarConteudoDocumentoResponse> getContent(){
        var conteudoDocumento
                = recuperarConteudoDocumento.getConteudoDocumento();
        return ResponseEntity.status(HttpStatus.OK).body(conteudoDocumento);
    }
}
