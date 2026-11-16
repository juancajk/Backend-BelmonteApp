package com.belmonte.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "escaner_registros")
public class EscanerRegistro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idRegistro;

    @NotBlank @Column(nullable = false) private String codigoQrEscaneado;

    @NotBlank @Column(nullable = false) private String fechaHora;

    @Column(nullable = false) private Long idViajeAsociado;
}

