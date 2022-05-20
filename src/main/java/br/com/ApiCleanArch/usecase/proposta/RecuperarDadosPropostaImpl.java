package br.com.ApiCleanArch.usecase.proposta;

import br.com.ApiCleanArch.usecase.exception.DocumentoConteudoEmptyException;
import br.com.ApiCleanArch.usecase.proposta.port.DadosPropostaResponse;
import br.com.ApiCleanArch.usecase.proposta.port.IDadosProposta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecuperarDadosPropostaImpl implements IRecuperarDadosProposta {

    private final IDadosProposta dadosProposta;

    @Override
    public RecuperarDadosPropostaResponse getDadosProposta() {
        var responseDadosProposta = dadosProposta.getDadosProposta();
        var response = convertResponse(responseDadosProposta);
        return response;
    }

    // Todo: Criar as exceptions corretas
    private RecuperarDadosPropostaResponse convertResponse(DadosPropostaResponse response) {
        return RecuperarDadosPropostaResponse
                .builder()
                .numeroProposta(response.getNumeroProposta())
                .valorParcela(response.getValorParcela())
                .taxaMes(response.getTaxaMes())
                .valorContrato(response.getValorContrato())
                .contratos(
                        Optional.ofNullable(response.getContratos())
                                .filter(list -> !list.isEmpty())
                                .orElseThrow(() -> new DocumentoConteudoEmptyException(""))
                                .stream()
                                .map(contrato -> RecuperarDadosPropostaResponse.Contrato
                                        .builder()
                                        .numeroContrato(contrato.getNumeroContrato())
                                        .numeroParcelas(contrato.getNumeroParcelas())
                                        .valorContrato(contrato.getValorContrato())
                                        .parcelas(
                                                Optional.ofNullable(contrato.getParcelas())
                                                        .filter(list -> !list.isEmpty())
                                                        .orElseThrow(() -> new DocumentoConteudoEmptyException(""))
                                                        .stream()
                                                        .map(parcelas -> RecuperarDadosPropostaResponse.Contrato.Parcela
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
