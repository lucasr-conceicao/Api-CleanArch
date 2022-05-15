package br.com.ApiCleanArch.adapters.cliente.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDadosResponse {

    @JsonProperty("data")
    private ClienteDadosDataResponse data;
}
