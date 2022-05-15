package br.com.ApiCleanArch.adapters.documento.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoConteudoResponseList {

    @JsonProperty("documento_id")
    private String documentoId;

    @JsonProperty("descricao_documento")
    private String descricaoDocumento;

    @JsonProperty("ano_vencimento_documento")
    private String anoVencimentoDocumento;
}
