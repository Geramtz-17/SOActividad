package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.PropiedadesModel;
import com.example.apartamentos.repositories.PropiedadRepository;


@Service
public class PropiedadService {
    
    @Autowired
    private PropiedadRepository propiedadRepository;

    public List<PropiedadesModel> getAllPropiedades() {
        return propiedadRepository.findAll();
    }

    public Optional<PropiedadesModel> getPropiedadById(Long id) {
        return propiedadRepository.findById(id);
    }

    public PropiedadesModel savePropiedad(PropiedadesModel propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public void deletePropiedad(Long id) {
        propiedadRepository.deleteById(id);
    }
    public List<PropiedadesModel> getPropiedadesByTipo(PropiedadesModel.TipoPropiedad tipo) {
    return propiedadRepository.findByTipoPropiedad(tipo); 
    }

    
}