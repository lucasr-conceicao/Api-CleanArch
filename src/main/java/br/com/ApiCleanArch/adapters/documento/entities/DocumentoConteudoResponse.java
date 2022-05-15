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
public class DocumentoConteudoResponse {

    @JsonProperty("data")
    private DocumentoConteudoResponseData data;
}
