package br.com.ApiCleanArch.adapters.database.repositories;

import br.com.ApiCleanArch.adapters.database.models.TbClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<TbClienteModel, String> {

    boolean existsByCpf(String cpf);
}
