package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.PagosModel;
import com.example.apartamentos.repositories.PagosRepository;

@Service
public class PagosService {
    
    @Autowired
    private PagosRepository pagosRepository;

    public List<PagosModel> getAllPagos() {
        return pagosRepository.findAll();
    }

    public Optional<PagosModel> getPagosById(Long id) {
        return pagosRepository.findById(id);
    }

    public PagosModel savePagos(PagosModel pagos) {
        return pagosRepository.save(pagos);
    }

    public void deletePagos(Long id) {
        pagosRepository.deleteById(id);
    }

    
}