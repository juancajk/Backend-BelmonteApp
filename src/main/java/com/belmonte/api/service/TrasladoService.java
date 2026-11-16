package com.belmonte.api.service;

import com.belmonte.api.model.Traslado;
import com.belmonte.api.repository.TrasladoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrasladoService {
    private final TrasladoRepository repo;

    public Traslado guardar(Traslado t) {

        t.setEstado("Pendiente");
        return repo.save(t);
    }

    public List<Traslado> listarTodos() {
        return repo.findAll();
    }

    public List<Traslado> listarPorEstado(String estado) {
        return repo.findByEstado(estado);
    }

    public Traslado actualizarEstado(Long id, String estado) {
        Optional<Traslado> op = repo.findById(id);
        if (op.isPresent()) {
            Traslado t = op.get();
            t.setEstado(estado);
            return repo.save(t);
        }
        return null;
    }


    public Traslado actualizarViaje(Long id, Traslado viajeModificado) {
        Optional<Traslado> op = repo.findById(id);
        if (op.isPresent()) {
            Traslado viajeExistente = op.get();


            viajeExistente.setNombrePasajero(viajeModificado.getNombrePasajero());
            viajeExistente.setFecha(viajeModificado.getFecha());
            viajeExistente.setHora(viajeModificado.getHora());
            viajeExistente.setDireccionOrigen(viajeModificado.getDireccionOrigen());
            viajeExistente.setDireccionDestino(viajeModificado.getDireccionDestino());
            viajeExistente.setNumeroVuelo(viajeModificado.getNumeroVuelo());
            viajeExistente.setFotoRefUri(viajeModificado.getFotoRefUri());


            viajeExistente.setLatitudOrigen(viajeModificado.getLatitudOrigen());
            viajeExistente.setLongitudOrigen(viajeModificado.getLongitudOrigen());
            viajeExistente.setLatitudDestino(viajeModificado.getLatitudDestino());
            viajeExistente.setLongitudDestino(viajeModificado.getLongitudDestino());



            return repo.save(viajeExistente);
        }
        return null;
    }
}

