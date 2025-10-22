package com.example.apartamentos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.example.apartamentos.models.PagosModel;
import com.example.apartamentos.services.PagosService;


@RestController
@RequestMapping("/api/pagos")
public class PagosController {
    
    @Autowired
    private PagosService pagosService;

    // Aquí irán los métodos para manejar las solicitudes HTTP relacionadas con los pagos
    // Obtener todas las propiedades, obtener por ID, crear, actualizar, eliminar, etc.
    
    //Recuperar todos los pagos
    @GetMapping
    public List<PagosModel> getAllPagos() {
        return pagosService.getAllPagos();
    }

    //Pago por ID
    //... Similar a ClienteController
    @GetMapping("/{id}")
    public ResponseEntity<PagosModel> getPagosById(@PathVariable Long id) {
        Optional<PagosModel> pago = pagosService.getPagosById(id);
        return pago.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo pago
    @PostMapping
    public PagosModel createPago(@RequestBody PagosModel pago) {
        return pagosService.savePagos(pago);
    }

    // Actualizar pago existente
    @PutMapping("/{id}")
    public ResponseEntity<PagosModel> updatePago(@PathVariable Long id, @RequestBody PagosModel pagoDetails) {
        Optional<PagosModel> pagoOptional = pagosService.getPagosById(id);
        if (pagoOptional.isPresent()) {
            PagosModel pagoToUpdate = pagoOptional.get();
            pagoToUpdate.setReservacion(pagoDetails.getReservacion());
            pagoToUpdate.setMonto(pagoDetails.getMonto());
                pagoToUpdate.setMetodo_pago(pagoDetails.getMetodo_pago());
            pagoToUpdate.setEstado(pagoDetails.getEstado());
                pagoToUpdate.setFecha_pago(pagoDetails.getFecha_pago());
                pagoToUpdate.setReferencia_pago(pagoDetails.getReferencia_pago());
                pagoToUpdate.setDatos_pago(pagoDetails.getDatos_pago());
                pagoToUpdate.setFecha_creacion(pagoDetails.getFecha_creacion());
            // Actualizar otros campos según sea necesario

            PagosModel updatedPago = pagosService.savePagos(pagoToUpdate);
            return ResponseEntity.ok(updatedPago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una propiedad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        Optional<PagosModel> pago = pagosService.getPagosById(id);
        if (pago.isPresent()) {
            pagosService.deletePagos(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
    
    
    // ACTIVIDAD: Crea un metodo para Recuperar propiedades por tipo

    // ACTIVIDAD: Crea un metodo para Recuoperar todas propiedades de un Propietario

    

