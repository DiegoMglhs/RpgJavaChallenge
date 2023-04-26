package com.ava.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Personagem")
@Entity
public class Personagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CLASSE", nullable = false)
    private String classe;
    @Column(name = "VIDA", nullable = false)
    private Integer vida;
    @Column(name = "FORCA", nullable = false)
    private Integer forca;
    @Column(name = "DEFESA", nullable = false)
    private Integer defesa;
    @Column(name = "AGILIDADE", nullable = false)
    private Integer agilidade;
    @Column(name = "QUANTIDADE_DE_DADOS", nullable = false)
    private Integer quantidadeDeDados;
    @Column(name = "FACES_DO_DADO", nullable = false)
    private Integer facesDoDado;

}
