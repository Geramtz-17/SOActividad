package com.example.apartamentos.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// PropiedadesModel is in the same package; explicit import removed to avoid unused-import warnings

/**
 * Modelo que representa una disponibilidad de un apartamento.
 *
 * <p>Contiene información básica como fecha, disponibilidad y precio especial.
 */
@Entity
@Table(name = "disponibilidad")
public class DisponibilidadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disponibilidad;

    // Clave foránea -> propiedades.id_propiedad (LAZY para evitar carga eager)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propiedad", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private PropiedadesModel propiedad;

    /** Date this availability entry applies to. */
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    /** true when the property is available on {@link #fecha}. */
    @Column(name = "disponible", nullable = false)
    private Boolean disponible;

    /** Optional special price for that date. When null the property's base price applies. */
    @Column(name = "precio_especial")
    private Double precio_especial;

    // ---------- Constructors ----------
    public DisponibilidadModel() { 

    }

    public DisponibilidadModel(PropiedadesModel propiedad, Date fecha, Boolean disponible, Double precio_especial) {
        this.propiedad = propiedad;
        this.fecha = fecha;
        this.disponible = disponible;
        this.precio_especial = precio_especial;
    }

    // Constructor with ID (useful for references)
    public DisponibilidadModel(Long id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    // ---------- Getters & Setters ----------
    public Long getId_disponibilidad() {
        return id_disponibilidad;
    }
    public void setId_disponibilidad(Long id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public PropiedadesModel getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(PropiedadesModel propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Double getPrecio_especial() {
        return precio_especial;
    }
    public void setPrecio_especial(Double precio_especial) {
        this.precio_especial = precio_especial;
    }
}
