package com.example.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apartamentos.models.ReseñasModel;

@Repository
public interface ReseñasRepository extends JpaRepository<ReseñasModel, Long> {

}


