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
public class PropostaContratosResponse {

    @JsonProperty("numero_contrato")
    private String numeroContrato;

    @JsonProperty("numero_parcelas")
    private int numeroParcelas;

    @JsonProperty("valor_contrato")
    private double valorContrato;

    @JsonProperty("valor_parcelas")
    private List<PropostaParcelasResponse> valorParcelas;
}
