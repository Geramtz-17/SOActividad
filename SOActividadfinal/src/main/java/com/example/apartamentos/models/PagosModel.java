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
 * Registro de pago para una reservación.
 *
 * <p>Contiene monto, método de pago, estado y metadatos opcionales específicos
 * del proveedor (referencia, detalles). La marca de creación se captura automáticamente.
 */
@Entity
@Table(name = "pagos")
public class PagosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id_pago;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reservacion", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ReservacionesModel reservacion;

    /** Monto pagado (el manejo de moneda se realiza en la capa de servicio). */
    @Column(name = "monto", nullable = false)
    private Double monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false, length = 20)
    private MetodoPago metodo_pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoPago estado;

    /** Marca de tiempo de cuando se efectuó el pago (puede ser null si está pendiente). */
    @Column(name = "fecha_pago")
    private LocalDateTime fecha_pago;

    /** Referencia del proveedor (id de transacción del gateway, etc.). */
    @Column(name = "referencia_pago", length = 80)
    private String referencia_pago;

    /** Detalles específicos del proveedor (texto libre o JSON cuando sea necesario). */
    @Column(name = "datos_pago", columnDefinition = "text")
    private String datos_pago;

    /** Marca de tiempo de creación del registro. */
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fecha_creacion = LocalDateTime.now();


    enum MetodoPago { TARJETA, 
        TRANSFERENCIA, 
        EFECTIVO, 
        PAYPAL 
    }
    enum EstadoPago { PENDIENTE, 
        PROCESADO, 
        FALLIDO, 
        REEMBOLSADO 
    }

    // --------- Constructors ---------
    public PagosModel() { }

    public PagosModel(ReservacionesModel reservacion,
                      Double monto,
                      MetodoPago metodo_pago,
                      EstadoPago estado,
                      LocalDateTime fecha_pago,
                      String referencia_pago,
                      String datos_pago) {
        this.reservacion = reservacion;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.estado = estado;
        this.fecha_pago = fecha_pago;
        this.referencia_pago = referencia_pago;
        this.datos_pago = datos_pago;
        this.fecha_creacion = LocalDateTime.now();
    }

    public PagosModel(Long id_pago) {
        this.id_pago = id_pago;
    }

    // --------- Getters & Setters ---------
    public Long getId_pago() {
        return id_pago;
    }
    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public ReservacionesModel getReservacion() {
        return reservacion;
    }
    public void setReservacion(ReservacionesModel reservacion) {
        this.reservacion = reservacion;
    }

    public Double getMonto() {
        return monto;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public EstadoPago getEstado() {
        return estado;
    }
    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getReferencia_pago() {
        return referencia_pago;
    }
    public void setReferencia_pago(String referencia_pago) {
        this.referencia_pago = referencia_pago;
    }

    public String getDatos_pago() {
        return datos_pago;
    }
    public void setDatos_pago(String datos_pago) {
        this.datos_pago = datos_pago;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
