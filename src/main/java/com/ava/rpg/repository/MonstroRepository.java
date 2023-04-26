package com.ava.rpg.repository;

import com.ava.rpg.model.Monstro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonstroRepository extends JpaRepository<Monstro, Long> {
}
