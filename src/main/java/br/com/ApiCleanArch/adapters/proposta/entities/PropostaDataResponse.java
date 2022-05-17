package br.com.ApiCleanArch.adapters.proposta.entities;

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
public class PropostaDataResponse {

    @JsonProperty("numero_proposta")
    private String numeroProposta;

    @JsonProperty("valor_parcela")
    private double valorParcela;

    @JsonProperty("taxa_mes")
    private double taxaMes;

    @JsonProperty("valor_contratado")
    private double valorContratado;

    @JsonProperty("contratos")
    private List<PropostaContratosResponse> contratos;
}
