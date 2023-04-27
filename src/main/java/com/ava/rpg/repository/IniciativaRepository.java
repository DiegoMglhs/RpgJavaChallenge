package com.ava.rpg.repository;

import com.ava.rpg.model.IniciativaLuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IniciativaRepository extends JpaRepository<IniciativaLuta, Long> {
}
