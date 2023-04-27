package com.ava.rpg.service;

import com.ava.rpg.exception.InvalidInputException;
import com.ava.rpg.model.Monstro;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.repository.MonstroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
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
                monstro.setIdentificador("M");
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
                monstro.setIdentificador("M");
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
                monstro.setIdentificador("M");
                break;
        }
        return this.repository.save(monstro);
    }
    public Monstro criar(Monstro monstro) throws Exception {
        monstro.setIdentificador("M");
        switch (monstro.getClasse().toUpperCase()){

            case "ORC":
                monstro.setClasse("Orc");
                monstro.setVida(42);
                monstro.setForca(7);
                monstro.setDefesa(1);
                monstro.setAgilidade(2);
                monstro.setQuantidadeDeDados(3);
                monstro.setFacesDoDado(4);
                break;

            case "GIGANTE":
                monstro.setClasse("Gigante");
                monstro.setVida(34);
                monstro.setForca(10);
                monstro.setDefesa(4);
                monstro.setAgilidade(4);
                monstro.setQuantidadeDeDados(2);
                monstro.setFacesDoDado(6);
                break;

            case "LOBISOMEN":
                monstro.setClasse("Lobisomen");
                monstro.setVida(34);
                monstro.setForca(7);
                monstro.setDefesa(4);
                monstro.setAgilidade(7);
                monstro.setQuantidadeDeDados(2);
                monstro.setFacesDoDado(4);
                break;

            default:

                Exception message = new Exception("Casse: "+monstro.getClasse()+" não permitida, Escolha pelas classes Possiveis: Orc, Gigante, Lobisomen");
                throw (message);
        }
        return this.repository.save(monstro);
    }
    public List<Monstro> listarMonstros(){
        return repository.findAll();
    }
    public Monstro localizarMonstro(Long id){
        return repository.findById(id).orElseThrow(()-> new ResolutionException("Monstro não localizado pelo id: "+ id));
    }

    public Monstro editarPersonagem (Monstro monstro){
        Monstro monstroinicio = localizarMonstro(monstro.getId());
        if (monstroinicio.getClasse().toUpperCase().intern() != monstro.getClasse().toUpperCase().intern()){
            throw new InvalidInputException("Não é possivel mudar a classe do Monstro.");
        }

        if(monstro.getIdentificador().toUpperCase().intern() != "M"){
            throw new InvalidInputException("Não é possivel transformar em Personagem o Monstro.");
        }
        return repository.save(monstro);
    }

    public void excluir (Long id){
        localizarMonstro(id);
        repository.deleteById(id);

    }
    public List<Monstro> cemiterio(){
        List<Monstro> cemiterio = repository.findByVida(0);
        return cemiterio;
    }

}
