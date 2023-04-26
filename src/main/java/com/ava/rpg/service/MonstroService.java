package com.ava.rpg.service;

import com.ava.rpg.model.Monstro;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.repository.MonstroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonstroService {
    @Autowired
    private MonstroRepository repository;

    public Monstro criarAleatorio(){
        Monstro monstro = new Monstro();
        int aleatorio = (int )(Math.random() * 3 + 1);
        switch (aleatorio){
            case 1:
                monstro.setNome("Orc");
                monstro.setClasse("Orc");
                monstro.setVida(42);
                monstro.setForca(7);
                monstro.setDefesa(1);
                monstro.setAgilidade(2);
                monstro.setQuantidadeDeDados(3);
                monstro.setFacesDoDado(4);
                break;

            case 2:
                monstro.setNome("Gigante");
                monstro.setClasse("Gigante");
                monstro.setVida(34);
                monstro.setForca(10);
                monstro.setDefesa(4);
                monstro.setAgilidade(4);
                monstro.setQuantidadeDeDados(2);
                monstro.setFacesDoDado(6);
                break;

            case 3:
                monstro.setNome("Lobisomen");
                monstro.setClasse("Lobisomen");
                monstro.setVida(34);
                monstro.setForca(7);
                monstro.setDefesa(4);
                monstro.setAgilidade(7);
                monstro.setQuantidadeDeDados(2);
                monstro.setFacesDoDado(4);
                break;
        }
        return this.repository.save(monstro);
    }
    public List<Monstro> listarMonstros(){
        return repository.findAll();
    }
}
