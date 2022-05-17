package br.com.ApiCleanArch.adapters.proposta.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropostaParcelasResponse {

    @JsonProperty("primeira_parcela")
    private double primeiraParcela;

    @JsonProperty("segunda_parcela")
    private double segundaParcela;

    @JsonProperty("terceira_parcela")
    private double terceiraParcela;
}
