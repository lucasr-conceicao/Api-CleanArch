package br.com.ApiCleanArch.adapters.documento;

import br.com.ApiCleanArch.adapters.documento.entities.DocumentoConteudoResponse;
import br.com.ApiCleanArch.adapters.documento.exception.DocumentoConteudoEmptyException;
import br.com.ApiCleanArch.usecase.port.ConteudoDocumentoResponse;
import br.com.ApiCleanArch.usecase.port.IConteudoDocumento;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class ConteudoDocumentoImpl implements IConteudoDocumento {

    private static final String LIST_EMPTY = "A lista não contém conteúdo";

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/5b8eef20-c704-4424-ad79-379c8b548cd3");

    @Override
    public ConteudoDocumentoResponse getConteudo() {
        var conteudoResponse = getDocumentoConteudo();
        var response = convertResponse(conteudoResponse);
        return response;
    }

    private DocumentoConteudoResponse getDocumentoConteudo() {
        var contentResponse = webClient
                .get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DocumentoConteudoResponse.class)
                .block();
        return contentResponse;
    }

    private ConteudoDocumentoResponse convertResponse(DocumentoConteudoResponse convert) {
        return ConteudoDocumentoResponse
                .builder()
                .propostaId(convert.getData().getPropostaId())
                .clienteId(convert.getData().getClienteId())
                .conteudo(
                        Optional.ofNullable(convert.getData().getDocumentos())
                                .filter(list -> !list.isEmpty())
                                .orElseThrow(() -> new DocumentoConteudoEmptyException(LIST_EMPTY))
                                .stream()
                                .map(conteudo -> ConteudoDocumentoResponse.ConteudoDocumentoListResponse
                                        .builder()
                                        .documentoId(conteudo.getDocumentoId())
                                        .descricaoDocumento(conteudo.getDescricaoDocumento())
                                        .build()
                                ).collect(Collectors.toList()))
                .build();
    }
}