package br.com.ApiCleanArch.adapters.documento.entities;

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
public class DocumentoConteudoResponseData {

    @JsonProperty("cliente_id")
    private String clienteId;

    @JsonProperty("proposta_id")
    private String propostaId;

    @JsonProperty("contrato_cliente")
    private String contratoCliente;

    @JsonProperty("documentos")
    private List<DocumentoConteudoResponseList> documentos;
}
