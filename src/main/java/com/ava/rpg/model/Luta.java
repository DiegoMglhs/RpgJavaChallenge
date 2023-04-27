package com.ava.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Luta")
@Entity
@NamedQuery(name = "Luta.consultarTurnos",
        query = "SELECT l FROM Luta l "+"WHERE l.idIniciativa = :idIniciativa")
public class Luta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Column(name = "ID_INICIATIVA",nullable = false)
    private Long idIniciativa;
    @Column(name = "ID_PERSONAGEM",nullable = false)
    private Long idPersonagem;
    @Column(name = "ID_MONSTRO",nullable = false)
    private Long idMonstro;
    @Column(name = "VIDA_PERSONAGEM",nullable = false)
    private Integer vidaPersonagem;
    @Column(name = "VIDA_MONSTRO",nullable = false)
    private Integer vidaMonstro;
    @Column(name = "ID_ATACANTE",nullable = false)
    private Long idAtacante;
    @Column(name = "DADOS_DEFENSOR", nullable = false)
    private Integer dadosDefensor;
    @Column(name = "DADOS_ATACANTE",nullable = false)
    private Integer dadosAtacante;
    @Column(name = "DANO", nullable = false)
    private Integer dano;
    @Column(name = "FINALIZOU", nullable = false)
    private Boolean finalizou;
}
