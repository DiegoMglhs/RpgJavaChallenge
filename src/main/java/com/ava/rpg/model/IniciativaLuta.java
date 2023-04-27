package com.ava.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IniciativaLuta")
@Entity
public class IniciativaLuta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Column(name = "ID_PERSONAGEM",nullable = false)
    private Long idPersonagem;
    @Column(name = "INICIATIVA_PERSONAGEM", nullable = false)
    private Integer iniciativaPersonagem;
    @Column(name = "ID_MONSTRO",nullable = false)
    private Long idMonstro;
    @Column(name = "INICIATIVA_MONSTRO", nullable = false)
    private Integer iniciativaMonstro;
    @Column(name = "VENCEDOR", nullable = false)
    private String vencedor;
    @Column(name = "IDENTIFICADOR_VENCEDOR", nullable = false)
    private String identificadorVencedor;
}
