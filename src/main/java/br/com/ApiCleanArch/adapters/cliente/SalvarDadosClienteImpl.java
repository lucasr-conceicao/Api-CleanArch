package br.com.ApiCleanArch.adapters.cliente;

import br.com.ApiCleanArch.adapters.models.TbClienteModel;
import br.com.ApiCleanArch.adapters.repositories.ClienteRepository;
import br.com.ApiCleanArch.usecase.cliente.port.DadosClienteResponse;
import br.com.ApiCleanArch.usecase.cliente.port.ISalvarDadosCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class SalvarDadosClienteImpl implements ISalvarDadosCliente {

    private final ClienteRepository repository;

    @Override
    public boolean salvarDadosCliente(DadosClienteResponse dadosCliente) {
        if (repository.existsByCpf(dadosCliente.getData().getCpf())) {
            return false;
        } else {
            var model = new TbClienteModel();
            BeanUtils.copyProperties(dadosCliente, model);
            model.setNome(dadosCliente.getData().getNome());
            model.setCpf(dadosCliente.getData().getCpf());
            model.setDataNascimento(dadosCliente.getData().getDataNascimento());
            model.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
            repository.save(model);
            return true;
        }
    }
}
