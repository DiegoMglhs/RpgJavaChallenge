package com.ava.rpg.service;

import com.ava.rpg.exception.InvalidInputException;
import com.ava.rpg.exception.ResourceNotFoundException;
import com.ava.rpg.model.IniciativaLuta;
import com.ava.rpg.model.Luta;
import com.ava.rpg.model.Monstro;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.repository.IniciativaRepository;
import com.ava.rpg.repository.LutaRepository;
import com.ava.rpg.repository.MonstroRepository;
import com.ava.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LutaService {
    @Autowired
    private MonstroRepository monstroRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private IniciativaRepository iniciativaRepository;
    @Autowired
    private LutaRepository repository;

    public IniciativaLuta iniciativaLuta(Long idPersonagem, Long idMonstro){
        IniciativaLuta iniciativa = new IniciativaLuta();
        Monstro monstro = monstroRepository.findById(idMonstro).orElseThrow(()-> new ResourceNotFoundException("Monstro não localizado pelo id: "+ idMonstro));
        Personagem personagem =personagemRepository.findById(idPersonagem).orElseThrow(()-> new ResourceNotFoundException("Monstro não localizado pelo id: "+ idPersonagem));
        Integer iniciativaMonstro = 0;
        Integer iniciativaPersonagem = 0;
        while (iniciativaMonstro == iniciativaPersonagem){
             iniciativaMonstro = (int) (Math.floor((Math.random() * 20) + 1) + monstro.getAgilidade() + monstro.getForca());
             iniciativaPersonagem = (int) (Math.floor((Math.random()* 20) +1)+ personagem.getAgilidade() + personagem.getForca());

            if(iniciativaPersonagem>iniciativaMonstro){
                iniciativa.setIdPersonagem(idPersonagem);
                iniciativa.setIniciativaPersonagem(iniciativaPersonagem);
                iniciativa.setIdMonstro(idMonstro);
                iniciativa.setIniciativaMonstro(iniciativaMonstro);
                iniciativa.setVencedor("Vencedor foi o Personagem: " + personagem.getNome());
                iniciativa.setIdentificadorVencedor(personagem.getIdentificador());
                break;
            }else{
                iniciativa.setIdPersonagem(idPersonagem);
                iniciativa.setIniciativaPersonagem(iniciativaPersonagem);
                iniciativa.setIdMonstro(idMonstro);
                iniciativa.setIniciativaMonstro(iniciativaMonstro);
                iniciativa.setVencedor("Vencedor foi o Monstro: " + monstro.getNome());
                iniciativa.setIdentificadorVencedor(monstro.getIdentificador());
                break;
            }
        }
        return this.iniciativaRepository.save(iniciativa);
    }

    public List<IniciativaLuta> listariniciativas(){

        return iniciativaRepository.findAll();
    }

    public Luta ataque(Long idIniciativa, String identificador){
        Luta turno = new Luta();
        turno.setDano(0);
        turno.setFinalizou(false);
        turno.setDadosDefensor(0);
        IniciativaLuta iniciativa = iniciativaRepository.findById(idIniciativa).orElseThrow(()-> new ResourceNotFoundException("Iniciativa não localizada pelo id: "+ idIniciativa));
        turno.setIdIniciativa(idIniciativa);
        Personagem personagem = personagemRepository.findById(iniciativa.getIdPersonagem()).orElseThrow(() -> new ResourceNotFoundException("Personagem não localizado"));
        Monstro monstro = monstroRepository.findById(iniciativa.getIdMonstro()).orElseThrow(()-> new ResourceNotFoundException("Monstro não localizado"));
        turno.setIdPersonagem(personagem.getId());
        turno.setIdMonstro(monstro.getId());
        turno.setVidaMonstro(monstro.getVida());
        turno.setVidaPersonagem(personagem.getVida());

        switch (identificador.toUpperCase()){
            case "M":
                turno.setDadosAtacante((int)((Math.random() * 12) + 1) +monstro.getForca()+monstro.getAgilidade());
                turno.setIdAtacante(monstro.getId());
                break;

            case "P":
                turno.setDadosAtacante((int)((Math.random()* 12) + 1)+ personagem.getForca()+personagem.getAgilidade());
                turno.setIdAtacante(personagem.getId());
                break;

            default:
                throw new InvalidInputException("Identificador inválido!");
        }

        return this.repository.save(turno);
    }
    public Luta defesa(Long idTurno, String identificador){
        Luta turno = repository.findById(idTurno).orElseThrow(()-> new ResourceNotFoundException("Luta não localizada pelo id: "+ idTurno));
        switch (identificador.toUpperCase()){
            case "M":
                Monstro monstro = monstroRepository.findById(turno.getIdMonstro()).orElseThrow(()-> new ResourceNotFoundException("Monstro não localizado"));
                turno.setDadosDefensor((int)((Math.random() * 12) + 1)+monstro.getDefesa()+monstro.getAgilidade());
                break;

            case "P":
                Personagem personagem = personagemRepository.findById(turno.getIdPersonagem()).orElseThrow(()-> new ResourceNotFoundException("Personagem não localizado"));
                turno.setDadosDefensor((int)((Math.random()* 12) + 1)+ personagem.getDefesa()+personagem.getAgilidade());
                break;

            default:
                throw new InvalidInputException("Identificador inválido!");
        }
        return this.repository.save(turno);
    }
    public Luta calcularDano(Long idTurno, String identificador){
        Luta turno = repository.findById(idTurno).orElseThrow(()-> new ResourceNotFoundException("Luta não localizada pelo id: "+ idTurno));
        Personagem personagem = personagemRepository.findById(turno.getIdPersonagem()).orElseThrow(() -> new ResourceNotFoundException("Personagem não localizado"));
        Monstro monstro = monstroRepository.findById(turno.getIdMonstro()).orElseThrow(()-> new ResourceNotFoundException("Monstro não localizado"));
        Integer dadosDefensor = turno.getDadosDefensor();
        Integer dadosAtacante = turno.getDadosAtacante();
        if(dadosAtacante > dadosDefensor) {
            Integer dano = 0;
            switch (identificador.toUpperCase()){
                case "M":
                    for (int i = 0; i < monstro.getQuantidadeDeDados(); i++) {
                        dano += (int) (Math.random() * monstro.getFacesDoDado() + 1);
                    }
                    turno.setDano(dano);
                    turno.setVidaPersonagem(turno.getVidaPersonagem() - dano);
                    if (turno.getVidaPersonagem() <= 0) {
                        turno.setVidaPersonagem(0);
                        turno.setFinalizou(true);
                    }
                    personagem.setVida(turno.getVidaPersonagem());
                    personagemRepository.save(personagem);
                    break;

                case "P":
                    for (int i = 0; i < personagem.getQuantidadeDeDados(); i++) {
                        dano += (int) (Math.random() * personagem.getFacesDoDado() + 1);
                    }
                    turno.setDano(dano);
                    turno.setVidaMonstro(turno.getVidaMonstro() - dano);
                    if (turno.getVidaMonstro() <= 0) {
                        turno.setVidaMonstro(0);
                        turno.setFinalizou(true);
                    }
                    monstro.setVida(turno.getVidaMonstro());
                    monstroRepository.save(monstro);
                    break;

                default:
                    throw new InvalidInputException("Identificador inválido!");
            }
        }
        return this.repository.save(turno);
    }

    public Luta ataqueAutomatico(Long idIniciativa, String identificador){
        Luta autoAtaque = ataque(idIniciativa,identificador);
        if(identificador.toUpperCase().equals("M")){
            identificador = "P";
        }else {
            identificador = "M";
        }
        autoAtaque = defesa(autoAtaque.getId(),identificador);
        if(identificador.toUpperCase().equals("M")){
            identificador = "P";
        }else {
            identificador = "M";
        }
        autoAtaque = calcularDano(autoAtaque.getId(),identificador);
        return autoAtaque;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }
    public List<Luta> historicoLuta(Long eventoId){
        List<Luta> historico = repository.findByIdIniciativa(eventoId);
        return historico;
    }

}

