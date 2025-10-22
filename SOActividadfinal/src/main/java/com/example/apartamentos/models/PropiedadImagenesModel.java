package com.example.apartamentos.models;

import java.time.LocalDateTime;

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

/**
 * Metadatos de imagen para una propiedad.
 *
 * <p>Contiene la URL de la imagen, un orden opcional y si la imagen es la
 * principal de la propiedad. La marca de tiempo de subida se captura automáticamente.
 */
@Entity
@Table(name = "propiedad_imagenes")
public class PropiedadImagenesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long id_imagen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_propiedad", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private PropiedadesModel propiedad;

    @Column(name = "url_imagen", nullable = false, length = 300)
    private String url_imagen;

    /** Índice de orden opcional para presentación. */
    @Column(name = "orden")
    private Integer orden;

    /** Marca la imagen como principal para mostrar en listados. */
    @Column(name = "es_principal", nullable = false)
    private Boolean es_principal = Boolean.FALSE;

    /** Marca de tiempo de subida. */
    @Column(name = "fecha_subida", nullable = false)
    private LocalDateTime fecha_subida = LocalDateTime.now();

    // --------- Constructors ---------
    public PropiedadImagenesModel() { 
        
    }

    public PropiedadImagenesModel(PropiedadesModel propiedad,
                                  String url_imagen,
                                  Integer orden,
                                  Boolean es_principal,
                                  LocalDateTime fecha_subida) {
        this.propiedad = propiedad;
        this.url_imagen = url_imagen;
        this.orden = orden;
        this.es_principal = (es_principal != null) ? es_principal : Boolean.FALSE;
        this.fecha_subida = (fecha_subida != null) ? fecha_subida : LocalDateTime.now();
    }

    public PropiedadImagenesModel(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    // --------- Getters & Setters ---------
    public Long getId_imagen() {
        return id_imagen;
    }
    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public PropiedadesModel getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(PropiedadesModel propiedad) {
        this.propiedad = propiedad;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }
    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public Integer getOrden() {
        return orden;
    }
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getEs_principal() {
        return es_principal;
    }
    public void setEs_principal(Boolean es_principal) {
        this.es_principal = es_principal;
    }

    public LocalDateTime getFecha_subida() {
        return fecha_subida;
    }
    public void setFecha_subida(LocalDateTime fecha_subida) {
        this.fecha_subida = fecha_subida;
    }
}