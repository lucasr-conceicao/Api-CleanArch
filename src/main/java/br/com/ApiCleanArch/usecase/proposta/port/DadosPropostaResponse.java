package br.com.ApiCleanArch.usecase.proposta.port;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosPropostaResponse {

    private String numeroProposta;
    private double valorParcela;
    private double taxaMes;
    private double valorContrato;
    private List<ContratoResponse> contratos;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContratoResponse {

        private String numeroContrato;
        private int numeroParcelas;
        private double valorContrato;
        private List<ParcelaResponse> parcelas;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ParcelaResponse {

            private double primeiraParcela;
            private double segundaParcela;
            private double terceiraParcela;
        }
    }
}
