package com.belmonte.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idVehiculo;

    @NotBlank @Column(nullable = false, unique = true) private String patente;

    @NotBlank @Column(nullable = false) private String marca;

    @NotBlank @Column(nullable = false) private String modelo;

    @Column(nullable = false) private int capacidadPasajeros;
}

