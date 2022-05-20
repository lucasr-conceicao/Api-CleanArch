package br.com.ApiCleanArch.usecase.proposta;

import br.com.ApiCleanArch.usecase.proposta.port.DadosPropostaResponse;
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
public class RecuperarDadosPropostaResponse {

    @JsonProperty("numero_proposta")
    private String numeroProposta;
    @JsonProperty("valor_parcela")
    private double valorParcela;
    @JsonProperty("taxa_mes")
    private double taxaMes;
    @JsonProperty("valor_contrato")
    private double valorContrato;
    @JsonProperty("contratos")
    private List<Contrato> contratos;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Contrato {

        @JsonProperty("numero_contrato")
        private String numeroContrato;
        @JsonProperty("numero_parcela")
        private int numeroParcelas;
        @JsonProperty("valor_contrato")
        private double valorContrato;
        @JsonProperty("parcelas")
        private List<Parcela> parcelas;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Parcela {

            @JsonProperty("primeira_parcela")
            private double primeiraParcela;
            @JsonProperty("segunda_parcela")
            private double segundaParcela;
            @JsonProperty("terceira_parcela")
            private double terceiraParcela;
        }
    }
}
