package com.belmonte.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "alertas")
public class Alerta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idAlerta;

    @NotBlank @Column(nullable = false) private String tipoAlerta;

    @NotBlank @Column(nullable = false) private String descripcion;

    @NotBlank @Column(nullable = false) private String fechaHora;
}

