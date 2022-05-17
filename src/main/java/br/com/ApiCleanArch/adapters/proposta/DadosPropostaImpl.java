package br.com.ApiCleanArch.adapters.proposta;

import br.com.ApiCleanArch.adapters.proposta.entities.PropostaDadosResponse;
import br.com.ApiCleanArch.usecase.proposta.port.DadosPropostaResponse;
import br.com.ApiCleanArch.usecase.proposta.port.IDadosProposta;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DadosPropostaImpl implements IDadosProposta {

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/0e920897-f3cc-4d0b-9580-adeafcf4e845");

    @Override
    public DadosPropostaResponse getDadosProposta() {
        var response = getDados();
        return null;
    }

    // Todo: Fazer a chamada do URI dados proposta
    private PropostaDadosResponse getDados() {
        var dataResponse = webClient
                .get()
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(PropostaDadosResponse.class)
                .block();
        return dataResponse;
    }

    // Todo: Fazer methodo conversão do retorno para DadosPropostaResponse (port)
}
