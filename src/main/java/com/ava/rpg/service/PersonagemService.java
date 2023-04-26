package com.ava.rpg.service;

import com.ava.rpg.model.Personagem;
import com.ava.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    public Personagem criar(Personagem personagem) throws Exception {
        switch (personagem.getClasse().toUpperCase()){
            case "GUERREIRO":
                personagem.setVida(20);
                personagem.setForca(7);
                personagem.setDefesa(5);
                personagem.setAgilidade(6);
                personagem.setQuantidadeDeDados(1);
                personagem.setFacesDoDado(12);
                break;

            case "BARBARO":
                personagem.setVida(21);
                personagem.setForca(10);
                personagem.setDefesa(2);
                personagem.setAgilidade(5);
                personagem.setQuantidadeDeDados(2);
                personagem.setFacesDoDado(8);
                break;

            case "CAVALEIRO":
                personagem.setVida(26);
                personagem.setForca(6);
                personagem.setDefesa(8);
                personagem.setAgilidade(3);
                personagem.setQuantidadeDeDados(2);
                personagem.setFacesDoDado(6);
                break;

            case "ORC":
                personagem.setVida(42);
                personagem.setForca(7);
                personagem.setDefesa(1);
                personagem.setAgilidade(2);
                personagem.setQuantidadeDeDados(3);
                personagem.setFacesDoDado(4);
                break;

            case "GIGANTE":
                personagem.setVida(34);
                personagem.setForca(10);
                personagem.setDefesa(4);
                personagem.setAgilidade(4);
                personagem.setQuantidadeDeDados(2);
                personagem.setFacesDoDado(6);
                break;

            case "LOBISOMEN":
                personagem.setVida(34);
                personagem.setForca(7);
                personagem.setDefesa(4);
                personagem.setAgilidade(7);
                personagem.setQuantidadeDeDados(2);
                personagem.setFacesDoDado(4);
                break;

            default:

                Exception message = new Exception("Casse: "+personagem.getClasse()+" não permitida, Escolha pelas classes Possiveis: Guerreiro, Barbaro, Cavaleiro, Orc, Gigante, Lobisomen");
                throw (message);
        }
        return this.repository.save(personagem);
    }

    public List<Personagem> listarTodos(){
        return repository.findAll();
    }

    public Personagem localizarPersonagem(Long id){
        return new Personagem();
    }

    public void excluir (Long id){

    }
    public Personagem editar (Personagem personagem){
        return new Personagem();
    }
}
