package br.com.ApiCleanArch.adapters.cliente;

import br.com.ApiCleanArch.adapters.cliente.entities.ClienteDadosResponse;
import br.com.ApiCleanArch.adapters.exception.DadosClienteException;
import br.com.ApiCleanArch.usecase.cliente.port.DadosClienteResponse;
import br.com.ApiCleanArch.usecase.cliente.port.IDadosCliente;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class DadosClienteImpl implements IDadosCliente {

    private static final String CLIENTE_NULL = "Dados do cliente nulo";

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/aba17c40-25e6-453b-960f-45c968c14d88");

    @Override
    public DadosClienteResponse getDadosCliente() {
        var dadosClienteResponse = getDados();
        var response = convertResponse(dadosClienteResponse);
        return Optional.ofNullable(response).orElseThrow(() -> new DadosClienteException(CLIENTE_NULL));
    }

    private ClienteDadosResponse getDados() {
        var dataResponse = webClient
                .get()
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(ClienteDadosResponse.class)
                .block();
        return dataResponse;
    }

    private DadosClienteResponse convertResponse(ClienteDadosResponse convert) {
        return DadosClienteResponse
                .builder()
                .data(DadosClienteResponse.DadosCliente
                        .builder()
                        .nome(convert.getData().getNome().getNome())
                        .dataNascimento(convert.getData().getDataNascimento().getDataNascimento())
                        .cpf(convert.getData().getCpf().getCpf())
                        .orgaoEmissor(convert.getData().getCpf().getOrgaoEmissor())
                        .build())
                .build();
    }
}
