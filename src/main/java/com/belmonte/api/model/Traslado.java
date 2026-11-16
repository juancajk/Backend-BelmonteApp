package com.belmonte.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "traslados")
public class Traslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable = false) private String nombrePasajero;

    @NotBlank @Column(nullable = false) private String fecha;

    @NotBlank @Column(nullable = false) private String hora;

    @NotBlank @Column(nullable = false) private String direccionOrigen;

    @NotBlank @Column(nullable = false) private String direccionDestino;

    private Double latitudOrigen = 0.0;
    private Double longitudOrigen = 0.0;
    private Double latitudDestino = 0.0;
    private Double longitudDestino = 0.0;

    private String numeroVuelo;

    @Column(length = 1000)
    private String fotoRefUri;

    @Column(nullable = false)
    private String estado = "Pendiente";
}