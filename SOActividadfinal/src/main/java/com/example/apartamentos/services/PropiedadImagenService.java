package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.PropiedadImagenModel;
import com.example.apartamentos.repositories.PropiedadImagenRepository;

@Service
public class PropiedadImagenService {
    
    @Autowired
    private PropiedadImagenRepository propiedadImagenRepository;

    public List<PropiedadImagenModel> getAllPropiedadesImagen() {
        return propiedadImagenRepository.findAll();
    }

    public Optional<PropiedadImagenModel> getPropiedadImagenById(Long id) {
        return propiedadImagenRepository.findById(id);
    }

    public PropiedadImagenModel savePropiedadImagen(PropiedadImagenModel propiedadImagen) {
        return propiedadImagenRepository.save(propiedadImagen);
    }

    public void deletePropiedadImagen(Long id) {
        propiedadImagenRepository.deleteById(id);
    }

    
}