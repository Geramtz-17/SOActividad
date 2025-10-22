package com.example.apartamentos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apartamentos.models.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    List<ClienteModel> findAllByTipo(ClienteModel.TipoCliente tipo);

}
