package com.example.apartamentos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apartamentos.models.PropiedadesModel;

@Repository

public interface PropiedadRepository extends JpaRepository<PropiedadesModel, Long> {
    List<PropiedadesModel> findByTipoPropiedad(PropiedadesModel.TipoPropiedad tipoPropiedad);

}

