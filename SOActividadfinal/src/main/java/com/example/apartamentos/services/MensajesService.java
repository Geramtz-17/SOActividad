package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.MensajesModel;
import com.example.apartamentos.repositories.MensajesRepository;

@Service
public class MensajesService {
    
    @Autowired
    private MensajesRepository mensajesRepository;

    public List<MensajesModel> getAllMensajes() {
        return mensajesRepository.findAll();
    }

    public Optional<MensajesModel> getMensajeById(Long id) {
        return mensajesRepository.findById(id);
    }

    public MensajesModel saveMensaje(MensajesModel mensaje) {
        return mensajesRepository.save(mensaje);
    }

    public void deleteMensaje(Long id) {
        mensajesRepository.deleteById(id);
    }

    
}