package com.ava.rpg.controller;

import com.ava.rpg.model.Monstro;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.service.MonstroService;
import com.ava.rpg.service.PersonagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rpg")
@CrossOrigin(value = "*")
public class Controller {

    @Autowired
    private PersonagemService personagemService;
    @Autowired
    private MonstroService monstroService;

    @GetMapping("/personagens")
    @ApiOperation("localiza todos os personagens")
    public ResponseEntity<List<Personagem>> listarTodos(){
        return new ResponseEntity<>(personagemService.listarTodos() ,HttpStatus.OK);
    }

    @PostMapping("/personagens")
    @ApiOperation("Cria um novo personagem")
    public ResponseEntity<Personagem> criar(@RequestBody Personagem personagem) throws Exception {
        return new ResponseEntity<>(personagemService.criar(personagem),HttpStatus.CREATED);
    }

    @PostMapping("/monstros/random")
    @ApiOperation("Inicia uma Caçada a um monstro de classe aleatória")
    public ResponseEntity<Monstro> criarAleatorio(){
        return new ResponseEntity<>(monstroService.criarAleatorio(),HttpStatus.CREATED);
    }

    @GetMapping("/monstros")
    @ApiOperation("localiza todos os monstros ao redor")
    public ResponseEntity<List<Monstro>> listarMonstros(){
        return new ResponseEntity<>(monstroService.listarMonstros() ,HttpStatus.OK);
    }

}
