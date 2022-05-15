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
public class ClienteNomeResponse {

    @JsonProperty("nome_cliente")
    private String nomeCliente;
    @JsonProperty("nome_cliente_documento")
    private String nomeClienteDocumento;
}
