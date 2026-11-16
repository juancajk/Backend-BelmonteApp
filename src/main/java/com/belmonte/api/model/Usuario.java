package com.belmonte.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @NotBlank @Email @Column(nullable = false, unique = true) private String correo;

    @NotBlank @Column(nullable = false) private String password;

    @Column(nullable = false) private String rol = "CONDUCTOR";
}
