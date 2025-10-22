package com.example.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apartamentos.models.PropiedadImagenModel;

@Repository
public interface PropiedadImagenRepository extends JpaRepository<PropiedadImagenModel, Long> {
    
}
