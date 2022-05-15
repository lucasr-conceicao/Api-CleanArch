package br.com.ApiCleanArch.adapters.repositories;

import br.com.ApiCleanArch.adapters.models.TbClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<TbClienteModel, String> {

    boolean existsByCpf(String cpf);
}
