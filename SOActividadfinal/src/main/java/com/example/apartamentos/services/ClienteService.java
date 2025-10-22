package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.ClienteModel;
import com.example.apartamentos.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel>  getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<ClienteModel> getClienteByTipo(ClienteModel.TipoCliente tipo) {
        return clienteRepository.findAllByTipo(tipo);
    }

    
}