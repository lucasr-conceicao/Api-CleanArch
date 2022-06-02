package br.com.ApiCleanArch.adapters.documento;

import br.com.ApiCleanArch.adapters.documento.entities.DocumentoConteudoResponse;
import br.com.ApiCleanArch.usecase.exception.DocumentoConteudoEmptyException;
import br.com.ApiCleanArch.usecase.documento.port.ConteudoDocumentoResponse;
import br.com.ApiCleanArch.usecase.documento.port.IConteudoDocumento;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class ConteudoDocumentoImpl implements IConteudoDocumento {

    WebClient webClient = WebClient.create("https://run.mocky.io/v3/aec726a6-7dd1-4637-ab1f-64bcb9e2a5ad");

    @Override
    public ConteudoDocumentoResponse getConteudo() {
        var documentoConteudoResponse = getDocumentoConteudo();
        var conteudoResponse = convertResponse(documentoConteudoResponse);
        return conteudoResponse;
    }

    private DocumentoConteudoResponse getDocumentoConteudo() {
        var response = webClient
                .get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DocumentoConteudoResponse.class)
                .block();
        return response;
    }

    private ConteudoDocumentoResponse convertResponse(DocumentoConteudoResponse convert) {
        var conteudo = Optional.ofNullable(convert.getData().getDocumentos())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new DocumentoConteudoEmptyException("Exception caso venha NULL"));
        return ConteudoDocumentoResponse
                .builder()
                .propostaId(convert.getData().getPropostaId())
                .clienteId(convert.getData().getClienteId())
                .conteudo(conteudo.stream().map(documento -> ConteudoDocumentoResponse.ConteudoDocumentoListResponse
                        .builder()
                        .documentoId(documento.getDocumentoId())
                        .descricaoDocumento(documento.getDescricaoDocumento())
                        .build()
                ).collect(Collectors.toList()))
                .build();
    }
}