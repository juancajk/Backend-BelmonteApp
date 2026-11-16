package com.belmonte.api.repository;
import com.belmonte.api.model.EscanerRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscanerRegistroRepository extends JpaRepository<EscanerRegistro, Long> {
}