package com.example.apartamentos.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Modelo que representa una propiedad disponible para renta.
 *
 * <p>Contiene información básica como título, descripción, ubicación,
 * precio base por noche, y características de la propiedad.
 */
@Entity
@Table(name = "propiedades")
public class PropiedadesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Long id_propiedad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propietario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ClienteModel propietario;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "codigo_postal", length = 10)
    private String codigo_postal;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "precio_base", nullable = false)
    private Double precio_base;

    @Column(name = "capacidad_maxima")
    private Integer capacidad_maxima;

    @Column(name = "num_habitaciones")
    private Integer num_habitaciones;

    @Column(name = "num_banos")
    private Integer num_banos;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_propiedad")
    private TipoPropiedad tipoPropiedad;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fecha_registro = LocalDateTime.now();

    public enum TipoPropiedad {
        CASA,
        DEPARTAMENTO,
        HABITACION,
        CABAÑA,
        VILLA
    }

    // Constructores
    public PropiedadesModel() {
    }

    public PropiedadesModel(ClienteModel propietario, String titulo, String descripcion,
        String direccion, String ciudad, String estado, String codigo_postal,
        String pais, Double precio_base, Integer capacidad_maxima,
        Integer num_habitaciones, Integer num_banos, TipoPropiedad tipoPropiedad) {
        this.propietario = propietario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.precio_base = precio_base;
        this.capacidad_maxima = capacidad_maxima;
        this.num_habitaciones = num_habitaciones;
        this.num_banos = num_banos;
    this.tipoPropiedad = tipoPropiedad;
        this.fecha_registro = LocalDateTime.now();
    }

    // Constructor con ID
    public PropiedadesModel(Long id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    // Getters y Setters
    public Long getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(Long id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public ClienteModel getPropietario() {
        return propietario;
    }

    public void setPropietario(ClienteModel propietario) {
        this.propietario = propietario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(Double precio_base) {
        this.precio_base = precio_base;
    }

    public Integer getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(Integer capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public Integer getNum_habitaciones() {
        return num_habitaciones;
    }

    public void setNum_habitaciones(Integer num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    public Integer getNum_banos() {
        return num_banos;
    }

    public void setNum_banos(Integer num_banos) {
        this.num_banos = num_banos;
    }

    public TipoPropiedad getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
