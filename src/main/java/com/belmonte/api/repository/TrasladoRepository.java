package com.belmonte.api.repository;
import com.belmonte.api.model.Traslado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrasladoRepository extends JpaRepository<Traslado, Long> {
    List<Traslado> findByEstado(String estado);
}