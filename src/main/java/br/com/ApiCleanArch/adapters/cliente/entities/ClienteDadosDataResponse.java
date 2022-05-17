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
public class ClienteDadosDataResponse {

    @JsonProperty("nome")
    private ClienteNomeResponse nome;

    @JsonProperty("data_nascimento")
    private ClienteDataNascimentoResponse dataNascimento;

    @JsonProperty("cpf")
    private ClienteCpfResponse cpf;
}
