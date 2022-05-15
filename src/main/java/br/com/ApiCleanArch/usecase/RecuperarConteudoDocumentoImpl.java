package br.com.ApiCleanArch.usecase;

import br.com.ApiCleanArch.adapters.documento.exception.DocumentoConteudoEmptyException;
import br.com.ApiCleanArch.usecase.port.ConteudoDocumentoResponse;
import br.com.ApiCleanArch.usecase.port.IConteudoDocumento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecuperarConteudoDocumentoImpl implements IRecuperarConteudoDocumento {

    private static final String LIST_EMPTY = "A lista não contém conteúdo";
    private final IConteudoDocumento conteudoDocumento;

    @Override
    public RecuperarConteudoDocumentoResponse getConteudoDocumento() {
        var conteudoResponse = conteudoDocumento.getConteudo();
        var response = convertResponse(conteudoResponse);
        return response;
    }

    private RecuperarConteudoDocumentoResponse convertResponse(ConteudoDocumentoResponse convert) {
        List<RecuperarConteudoDocumentoResponse.RecuperarConteudoDocumentoResponseList> result = new ArrayList<>();
        for (ConteudoDocumentoResponse.ConteudoDocumentoListResponse conteudo : Optional.ofNullable(convert.getConteudo())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new DocumentoConteudoEmptyException(LIST_EMPTY))) {
            var build = RecuperarConteudoDocumentoResponse
                    .RecuperarConteudoDocumentoResponseList
                    .builder()
                    .documentoId(conteudo.getDocumentoId())
                    .descricaoDocumento(conteudo.getDescricaoDocumento())
                    .build();
            result.add(build);
        }
        return RecuperarConteudoDocumentoResponse
                .builder()
                .propostaId(convert.getPropostaId())
                .clienteId(convert.getClienteId())
                .conteudoDcoumento(result)
                .build();
    }
}
