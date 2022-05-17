package br.com.ApiCleanArch.usecase.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecuperarDadosClienteResponse {

    @JsonProperty("data")
    private RecuperarDadosCliente data;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecuperarDadosCliente {

        @JsonProperty("nome")
        private String nome;
        @JsonProperty("data_nascimento")
        private String dataNascimento;
        @JsonProperty("cpf")
        private String cpf;
        @JsonProperty("orgao_emissor")
        private String orgaoEmissor;
    }
}
