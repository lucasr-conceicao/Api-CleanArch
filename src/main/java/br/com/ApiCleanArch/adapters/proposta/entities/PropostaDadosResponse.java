package br.com.ApiCleanArch.adapters.proposta.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropostaDadosResponse {

    @JsonProperty("data")
    private PropostaDataResponse data;
}
