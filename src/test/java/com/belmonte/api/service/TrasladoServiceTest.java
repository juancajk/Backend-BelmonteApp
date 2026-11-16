package com.belmonte.api.service;

import com.belmonte.api.model.Traslado;
import com.belmonte.api.repository.TrasladoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrasladoServiceTest {

    @Mock
    private TrasladoRepository repository;

    @InjectMocks
    private TrasladoService service;

    private Traslado viajePrueba;

    @BeforeEach
    void setUp() {
        viajePrueba = new Traslado();
        viajePrueba.setId(1L);
        viajePrueba.setNombrePasajero("Juan Carlos Alvarado");
        viajePrueba.setDireccionOrigen("Aeropuerto SCL");
        viajePrueba.setDireccionDestino("Duoc UC");
        viajePrueba.setEstado("Pendiente");
    }

    @Test
    void guardar_DeberiaAsignarEstadoPendienteYGuardar() {

        Traslado nuevoViaje = new Traslado();
        nuevoViaje.setNombrePasajero("Constanza Cerda");

        when(repository.save(any(Traslado.class))).thenReturn(nuevoViaje);


        Traslado resultado = service.guardar(nuevoViaje);


        assertEquals("Pendiente", nuevoViaje.getEstado(), "El estado inicial debe ser Pendiente");
        verify(repository, times(1)).save(nuevoViaje);
    }

    @Test
    void actualizarViaje_DeberiaModificarTextosPeroNoElEstado() {

        Traslado viajeModificado = new Traslado();
        viajeModificado.setNombrePasajero("Juan Carlos Modificado");
        viajeModificado.setDireccionDestino("Nueva Dirección");
        viajeModificado.setEstado("En Curso");

        when(repository.findById(1L)).thenReturn(Optional.of(viajePrueba));
        when(repository.save(any(Traslado.class))).thenReturn(viajePrueba);


        Traslado resultado = service.actualizarViaje(1L, viajeModificado);


        assertNotNull(resultado);
        assertEquals("Juan Carlos Modificado", resultado.getNombrePasajero());
        assertEquals("Nueva Dirección", resultado.getDireccionDestino());
        assertEquals("Pendiente", resultado.getEstado(), "El estado NO debió cambiar a través de este método");
    }

    @Test
    void actualizarEstado_DeberiaCambiarSoloElEstado() {

        when(repository.findById(1L)).thenReturn(Optional.of(viajePrueba));
        when(repository.save(any(Traslado.class))).thenReturn(viajePrueba);


        Traslado resultado = service.actualizarEstado(1L, "En Curso");


        assertNotNull(resultado);
        assertEquals("En Curso", resultado.getEstado());
        assertEquals("Juan Carlos Alvarado", resultado.getNombrePasajero(), "Los demás datos deben mantenerse intactos");
    }
}