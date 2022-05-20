package br.com.ApiCleanArch.adapters.proposta;

import br.com.ApiCleanArch.adapters.proposta.entities.PropostaDadosResponse;
import br.com.ApiCleanArch.usecase.exception.DocumentoConteudoEmptyException;
import br.com.ApiCleanArch.usecase.proposta.port.DadosPropostaResponse;
import br.com.ApiCleanArch.usecase.proposta.port.IDadosProposta;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DadosPropostaImpl implements IDadosProposta {

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/0e920897-f3cc-4d0b-9580-adeafcf4e845");

    @Override
    public DadosPropostaResponse getDadosProposta() {
        var propostaResponse = getDados();
        var response = convertResponse(propostaResponse);
        return response;
    }

    private PropostaDadosResponse getDados() {
        var dataResponse = webClient
                .get()
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(PropostaDadosResponse.class)
                .block();
        return dataResponse;
    }

    // Todo: Criar as exceptions corretas
    private DadosPropostaResponse convertResponse(PropostaDadosResponse response) {
        return DadosPropostaResponse
                .builder()
                .numeroProposta(response.getData().getNumeroProposta())
                .valorContrato(response.getData().getValorContrato())
                .taxaMes(response.getData().getTaxaMes())
                .valorParcela(response.getData().getValorParcela())
                .contratos(
                        Optional.ofNullable(response.getData().getContratos())
                                .filter(list -> !list.isEmpty())
                                .orElseThrow(() -> new DocumentoConteudoEmptyException(""))
                                .stream()
                                .map(contratos -> DadosPropostaResponse.ContratoResponse
                                        .builder()
                                        .numeroContrato(contratos.getNumeroContrato())
                                        .numeroParcelas(contratos.getNumeroParcelas())
                                        .valorContrato(contratos.getValorContrato())
                                        .parcelas(
                                                Optional.ofNullable(contratos.getValorParcelas())
                                                        .filter(list -> !list.isEmpty())
                                                        .orElseThrow(() -> new DocumentoConteudoEmptyException(""))
                                                        .stream()
                                                        .map(parcelas -> DadosPropostaResponse.ContratoResponse.ParcelaResponse
                                                                .builder()
                                                                .primeiraParcela(parcelas.getPrimeiraParcela())
                                                                .segundaParcela(parcelas.getSegundaParcela())
                                                                .terceiraParcela(parcelas.getTerceiraParcela())
                                                                .build()
                                                        ).collect(Collectors.toList()))
                                        .build()
                                ).collect(Collectors.toList()))
                .build();
    }
}
