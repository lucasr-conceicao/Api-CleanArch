package br.com.ApiCleanArch.usecase.port;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDocumentoResponse {

    private String clienteId;
    private String propostaId;
    private List<ConteudoDocumentoListResponse> conteudo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ConteudoDocumentoListResponse {

        private String documentoId;
        private String descricaoDocumento;
    }
}
