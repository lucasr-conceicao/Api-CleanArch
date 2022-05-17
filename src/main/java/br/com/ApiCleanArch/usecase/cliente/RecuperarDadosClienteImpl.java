package br.com.ApiCleanArch.usecase.cliente;

import br.com.ApiCleanArch.usecase.cliente.port.DadosClienteResponse;
import br.com.ApiCleanArch.usecase.cliente.port.IDadosCliente;
import br.com.ApiCleanArch.usecase.cliente.port.ISalvarDadosCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecuperarDadosClienteImpl implements IRecuperarDadosCliente{

    private final IDadosCliente dadosCliente;
    private final ISalvarDadosCliente salvarDadosCliente;

    @Override
    public RecuperarDadosClienteResponse getDadosCliente() {
        var dadosClienteResponse = dadosCliente.getDadosCliente();
        var response = convertResponse(dadosClienteResponse);
        salvarDadosCliente.salvarDadosCliente(dadosClienteResponse);
        return response;
    }

    private RecuperarDadosClienteResponse convertResponse(DadosClienteResponse convert) {
        return RecuperarDadosClienteResponse
                .builder()
                .data(RecuperarDadosClienteResponse.RecuperarDadosCliente
                        .builder()
                        .nome(convert.getData().getNome())
                        .dataNascimento(convert.getData().getDataNascimento())
                        .cpf(convert.getData().getCpf())
                        .orgaoEmissor(convert.getData().getOrgaoEmissor())
                        .build())
                .build();
    }
}
