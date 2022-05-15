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
public class ClienteCpfResponse {

    @JsonProperty("cpf_cliente")
    private String cpf;
    @JsonProperty("ano_atualizacao")
    private String anoAtualizacao;
}
