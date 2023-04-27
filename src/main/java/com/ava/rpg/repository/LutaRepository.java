package com.ava.rpg.repository;

import com.ava.rpg.model.Luta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LutaRepository extends JpaRepository<Luta, Long> {
    List<Luta> findByIdIniciativa(Long eventoId);
}
