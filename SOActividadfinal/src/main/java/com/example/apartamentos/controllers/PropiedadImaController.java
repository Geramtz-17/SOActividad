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

import com.example.apartamentos.models.PropiedadImagenModel;
import com.example.apartamentos.services.PropiedadImagenService;

@RestController
@RequestMapping("/api/propiedadima")
public class PropiedadImaController {

    @Autowired
    private PropiedadImagenService propiedadImagenService;

    // Obtener todas las imágenes de propiedad
    @GetMapping
    public List<PropiedadImagenModel> getAllPropiedadesIma() {
        return propiedadImagenService.getAllPropiedadesImagen();
    }

    // Obtener una imagen de propiedad por ID
    @GetMapping("/{id}")
    public ResponseEntity<PropiedadImagenModel> getPropiedadImaById(@PathVariable Long id) {
        Optional<PropiedadImagenModel> propiedadIma = propiedadImagenService.getPropiedadImagenById(id);
        return propiedadIma.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo mensaje
    @PostMapping
    public PropiedadImagenModel createPropiedadIma(@RequestBody PropiedadImagenModel propiedadIma) {
        return propiedadImagenService.savePropiedadImagen(propiedadIma);
    }

    // Actualizar una imagen de propiedad existente
    @PutMapping("/{id}")
    public ResponseEntity<PropiedadImagenModel> updatePropiedadIma(@PathVariable Long id, @RequestBody PropiedadImagenModel propiedadImaDetails) {
        Optional<PropiedadImagenModel> propiedadImaOptional = propiedadImagenService.getPropiedadImagenById(id);
        if (propiedadImaOptional.isPresent()) {
            PropiedadImagenModel propiedadImaToUpdate = propiedadImaOptional.get();
            propiedadImaToUpdate.setPropiedad(propiedadImaDetails.getPropiedad());
            propiedadImaToUpdate.setUrlImagen(propiedadImaDetails.getUrlImagen());
            propiedadImaToUpdate.setOrden(propiedadImaDetails.getOrden());
            propiedadImaToUpdate.setEsPrincipal(propiedadImaDetails.getEsPrincipal());
            propiedadImaToUpdate.setFechaSubida(propiedadImaDetails.getFechaSubida());
            // Actualizar otros campos según sea necesario

            PropiedadImagenModel updatedPropiedadIma = propiedadImagenService.savePropiedadImagen(propiedadImaToUpdate);
            return ResponseEntity.ok(updatedPropiedadIma);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropiedadIma(@PathVariable Long id) {
        Optional<PropiedadImagenModel> propiedadIma = propiedadImagenService.getPropiedadImagenById(id);
        if (propiedadIma.isPresent()) {
            propiedadImagenService.deletePropiedadImagen(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}