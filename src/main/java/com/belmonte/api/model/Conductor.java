package com.belmonte.api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "conductores")
public class Conductor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idConductor;

    @NotBlank @Column(nullable = false) private String nombreCompleto;

    @NotBlank @Column(nullable = false, unique = true) private String rut;

    @NotBlank @Column(nullable = false) private String licencia;
}

