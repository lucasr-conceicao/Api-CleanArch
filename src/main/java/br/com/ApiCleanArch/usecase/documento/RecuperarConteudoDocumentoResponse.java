package br.com.ApiCleanArch.usecase.documento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecuperarConteudoDocumentoResponse {

    @JsonProperty("cliente_id")
    private String clienteId;
    @JsonProperty("proposta_id")
    private String propostaId;
    @JsonProperty("documentos")
    private List<RecuperarConteudoDocumentoResponseList> conteudoDcoumento;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecuperarConteudoDocumentoResponseList {

        @JsonProperty("documento_id")
        private String documentoId;
        @JsonProperty("descricao_documento")
        private String descricaoDocumento;

    }
}