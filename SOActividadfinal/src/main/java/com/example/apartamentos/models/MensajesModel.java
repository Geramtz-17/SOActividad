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
 * Entidad de mensajería simple usada para comunicación entre clientes (remitente/destinatario).
 *
 * <p>Los mensajes pueden opcionalmente asociarse a una reservación; almacenan asunto,
 * contenido, bandera de leído y una marca de tiempo de envío.
 */
@Entity
@Table(name = "mensajes")
public class MensajesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Long id_mensaje;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_remitente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ClienteModel remitente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_destinatario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ClienteModel destinatario;

    // Enlace opcional a una reservación (para contexto)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ReservacionesModel reservacion;

    @Column(name = "asunto", length = 150)
    private String asunto;

    @Column(name = "contenido", columnDefinition = "text")
    private String contenido;

    /** Indica si el destinatario ha leído el mensaje. Por defecto false. */
    @Column(name = "leido", nullable = false)
    private Boolean leido = Boolean.FALSE;

    /** Marca de tiempo cuando se envió el mensaje. */
    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fecha_envio = LocalDateTime.now();

    // ---------- Constructors ----------
    public MensajesModel() { 

    }

    public MensajesModel(ClienteModel remitente,
                         ClienteModel destinatario,
                         ReservacionesModel reservacion,
                         String asunto,
                         String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.reservacion = reservacion;
        this.asunto = asunto;
        this.contenido = contenido;
        this.leido = Boolean.FALSE;
        this.fecha_envio = LocalDateTime.now();
    }

    public MensajesModel(Long id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    // ---------- Getters & Setters ----------
    public Long getId_mensaje() {
        return id_mensaje;
    }
    public void setId_mensaje(Long id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public ClienteModel getRemitente() {
        return remitente;
    }
    public void setRemitente(ClienteModel remitente) {
        this.remitente = remitente;
    }

    public ClienteModel getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(ClienteModel destinatario) {
        this.destinatario = destinatario;
    }

    public ReservacionesModel getReservacion() {
        return reservacion;
    }
    public void setReservacion(ReservacionesModel reservacion) {
        this.reservacion = reservacion;
    }

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getLeido() {
        return leido;
    }
    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public LocalDateTime getFecha_envio() {
        return fecha_envio;
    }
    public void setFecha_envio(LocalDateTime fecha_envio) {
        this.fecha_envio = fecha_envio;
    }
}
