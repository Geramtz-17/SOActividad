package com.example.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.apartamentos.models.ReservacionesModel;
import com.example.apartamentos.repositories.ReservacionesRepository;

@Service
public class ReservacionesService {
    
    @Autowired
    private ReservacionesRepository reservacionesRepository;

    public List<ReservacionesModel> getAllReservaciones() {
        return reservacionesRepository.findAll();
    }

    public Optional<ReservacionesModel> getReservacionById(Long id) {
        return reservacionesRepository.findById(id);
    }

    public ReservacionesModel saveReservacion(ReservacionesModel reservacion) {
        return reservacionesRepository.save(reservacion);
    }

    public void deleteReservacion(Long id) {
        reservacionesRepository.deleteById(id);
    }

}
