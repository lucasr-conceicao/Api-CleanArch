package br.com.ApiCleanArch.usecase.proposta;

import br.com.ApiCleanArch.usecase.proposta.port.IDadosProposta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecuperarDadosPropostaImpl implements IRecuperarDadosProposta{

    private final IDadosProposta dadosProposta;

    @Override
    public RecuperarDadosPropostaResponse getDadosProposta() {
        var responseDadosProposta = dadosProposta.getDadosProposta();
        return null;
    }
}
