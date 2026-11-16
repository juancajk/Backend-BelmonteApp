package com.belmonte.api.controller;

import com.belmonte.api.model.Traslado;
import com.belmonte.api.service.TrasladoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrasladoController.class)
class TrasladoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrasladoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Traslado viajePrueba;

    @BeforeEach
    void setUp() {
        viajePrueba = new Traslado();
        viajePrueba.setId(1L);
        viajePrueba.setNombrePasajero("Juan Carlos Alvarado");
        viajePrueba.setEstado("Pendiente");

        viajePrueba.setFecha("12/11/2026");
        viajePrueba.setHora("14:30");
        viajePrueba.setDireccionOrigen("Origen A");
        viajePrueba.setDireccionDestino("Destino B");
    }

    @Test
    void listar_DeberiaRetornar200YListaDeViajes() throws Exception {
        when(service.listarTodos()).thenReturn(Arrays.asList(viajePrueba));

        mockMvc.perform(get("/api/traslados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombrePasajero").value("Juan Carlos Alvarado"));
    }

    @Test
    void guardar_DeberiaRetornar200YViajeCreado() throws Exception {
        when(service.guardar(any(Traslado.class))).thenReturn(viajePrueba);

        mockMvc.perform(post("/api/traslados")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(viajePrueba)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.estado").value("Pendiente"));
    }

    @Test
    void actualizarViajeCompleto_DeberiaRetornar200() throws Exception {
        Traslado modificado = new Traslado();
        modificado.setNombrePasajero("Pasajero Editado");
        modificado.setFecha("13/11/2026");
        modificado.setHora("10:00");
        modificado.setDireccionOrigen("A");
        modificado.setDireccionDestino("B");

        when(service.actualizarViaje(eq(1L), any(Traslado.class))).thenReturn(modificado);

        mockMvc.perform(put("/api/traslados/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modificado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombrePasajero").value("Pasajero Editado"));
    }
}

