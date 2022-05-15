package br.com.ApiCleanArch.usecase.cliente.port;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosClienteResponse {

    private DadosCliente data;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DadosCliente {

        private String nome;
        private String dataNascimento;
        private String cpf;
    }
}
