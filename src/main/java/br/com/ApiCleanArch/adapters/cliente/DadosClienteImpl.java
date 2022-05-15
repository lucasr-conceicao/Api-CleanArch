package br.com.ApiCleanArch.adapters.cliente;

import br.com.ApiCleanArch.adapters.cliente.entities.ClienteDadosResponse;
import br.com.ApiCleanArch.usecase.cliente.port.DadosClienteResponse;
import br.com.ApiCleanArch.usecase.cliente.port.IDadosCliente;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DadosClienteImpl implements IDadosCliente {

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/1869d7cd-d20b-410a-89cf-b92300f41e58");

    @Override
    public DadosClienteResponse getDadosCliente() {
        var dadosClienteResponse = getDados();
        var response = convertResponse(dadosClienteResponse);
        return response;
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
                        .nome(convert.getData().getNome().getNomeCliente())
                        .dataNascimento(convert.getData().getDataNascimento().getDataNascimento())
                        .cpf(convert.getData().getCpf().getCpf())
                        .build())
                .build();
    }
}
