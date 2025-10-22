package com.example.apartamentos.models;

import java.sql.Date;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
// PropiedadesModel is in the same package; explicit import removed to avoid unused-import warnings

/**
 * Registro de reservación que enlaza un cliente con una propiedad para un rango de fechas.
 *
 * <p>Contiene fechas de entrada/salida, número de huéspedes, precio y estado. Los
 * callbacks de ciclo de vida de JPA establecen por defecto marcas de check-in/check-out;
 * los servicios deberían validar las reglas de negocio (rangos de fechas, consistencia de precios, etc.).
 */
@Entity
@Table(name = "reservaciones")
public class ReservacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_reservacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propiedad", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})  
    private PropiedadesModel propiedad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})  
    private ClienteModel cliente;

    @Column(name = "fecha_entrada", nullable = false)
    private Date fecha_entrada;

    @Column(name = "fecha_salida", nullable = false)
    private Date fecha_salida;

    @Column(name = "numero_huespedes", nullable = false)
    private String numero_huespedes;

    @Column(name = "precio_total", nullable = false)
    private double precio_total;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @Column(name = "fecha_reservacion", nullable = false)
    private LocalDateTime fecha_reservacion;

    @Column(name = "notas", length = 500)
    private String notas;

    @Column(name = "codigo_reserva", nullable = false, length = 5)
    private String codigo_reserva;

    @Column(name = "fecha_checkin", nullable = false)
    private LocalDateTime fecha_checkin;

    @Column(name = "fecha_checkout", nullable = false)
    private LocalDateTime fecha_checkout;

    // Callback JPA: antes de insertar
    @PrePersist
    public void onPrePersist() {
        if (this.fecha_checkin == null) {
            this.fecha_checkin = LocalDateTime.now();
        }
        this.fecha_checkout = LocalDateTime.now();
    }

    // Callback JPA: antes de actualizar
    @PreUpdate
    public void onPreUpdate() {
        this.fecha_checkout = LocalDateTime.now();
    }


    enum Estado {
        Solicitud,
        Confirmada,
        Cancelada
    }

     //Constructor vacio
    public ReservacionesModel() {
    }

    //Constructor completo
    public ReservacionesModel(PropiedadesModel propiedad, ClienteModel cliente, Date fecha_entrada, Date fecha_salida, String numero_huespedes, double precio_total, LocalDateTime fecha_reservacion, String notas, String codigo_reserva,
            LocalDateTime fecha_checkin, LocalDateTime fecha_checkout) {
        this.propiedad = propiedad;
        this.cliente = cliente;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.numero_huespedes = numero_huespedes;
        this.precio_total = precio_total;
        this.fecha_reservacion = fecha_reservacion;
        this.notas = notas;
        this.codigo_reserva = codigo_reserva;
        this.fecha_checkin = fecha_checkin;
        this.fecha_checkout = fecha_checkout;
    }

     // Constuctor con id_reservacion solo
    public ReservacionesModel(Long id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    // Getters and Setters
        public Long getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(Long id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public PropiedadesModel getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(PropiedadesModel propiedad) {
        this.propiedad = propiedad;
    }

     public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Date getFecha_entrada(){
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_etrada) {
        this.fecha_entrada = fecha_etrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getNumero_huespedes(){
        return numero_huespedes;
    }

    public void setNumero_huespedes(String numero_huespedes) {
        this.numero_huespedes = numero_huespedes;
    }

    public double getPrecio_total(){
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(LocalDateTime fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(String codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    public LocalDateTime getFecha_checkin() {
        return fecha_checkin;
    }

    public void setFecha_checkin(LocalDateTime fecha_checkin) {
        this.fecha_checkin = fecha_checkin;
    }

    public LocalDateTime getFecha_checkout() {
        return fecha_checkout;
    }

    public void setFecha_checkout(LocalDateTime fecha_checkout) {
        this.fecha_checkout = fecha_checkout;
    }
    
    
}
