package br.com.ApiCleanArch.adapters.database;

import br.com.ApiCleanArch.adapters.database.models.TbClienteModel;
import br.com.ApiCleanArch.adapters.database.repositories.ClienteRepository;
import br.com.ApiCleanArch.usecase.cliente.port.DadosClienteResponse;
import br.com.ApiCleanArch.usecase.cliente.port.ISalvarDadosCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class DadosClienteDatabaseImpl implements ISalvarDadosCliente {

    private final ClienteRepository repository;

    @Override
    public boolean salvarDadosCliente(DadosClienteResponse dadosCliente) {
        if (repository.existsByCpf(dadosCliente.getData().getCpf())) {
            return false;
        } else {

            var model = TbClienteModel
                    .builder()
                    .cpf(dadosCliente.getData().getCpf())
                    .orgaoEmissor(dadosCliente.getData().getOrgaoEmissor())
                    .nome(dadosCliente.getData().getNome())
                    .dataNascimento(dadosCliente.getData().getDataNascimento())
                    .creationDate(LocalDateTime.now(ZoneId.of("UTC")))
                    .build();
            BeanUtils.copyProperties(dadosCliente, model);
            repository.save(model);
            return true;
        }
    }
}
