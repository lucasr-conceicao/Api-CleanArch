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
public class ClienteDataNascimentoResponse {

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("ano_nascimento")
    private String anoNascimento;

    @JsonProperty("mes_nascimento")
    private String mesNascimento;

    @JsonProperty("dia_nascimento")
    private String diaNascimento;
}
