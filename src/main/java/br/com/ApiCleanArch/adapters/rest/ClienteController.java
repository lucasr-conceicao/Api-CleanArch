package br.com.ApiCleanArch.adapters.rest;

import br.com.ApiCleanArch.usecase.cliente.IRecuperarDadosCliente;
import br.com.ApiCleanArch.usecase.cliente.RecuperarDadosClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recuperar/dados-cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final IRecuperarDadosCliente recuperarDadosCliente;

    @GetMapping()
    public ResponseEntity<RecuperarDadosClienteResponse> getDadosCliente(){
        var dadosCliente = recuperarDadosCliente.getDadosCliente();
        return ResponseEntity.status(HttpStatus.OK).body(dadosCliente);
    }
}
