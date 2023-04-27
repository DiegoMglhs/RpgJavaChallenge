package com.ava.rpg.controller;


import com.ava.rpg.model.Personagem;
import com.ava.rpg.service.PersonagemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rpg/personagem")
@CrossOrigin(value = "*")
public class PersonagemController {
    @Autowired
    private PersonagemService service;
    @GetMapping("/pesquisar")
    @ApiOperation("pesquisa todos os personagens")
    public ResponseEntity<List<Personagem>> listarTodos(){
        return new ResponseEntity<>(service.listarTodos() , HttpStatus.OK);
    }
    @GetMapping("/localizar/{id}")
    @ApiOperation("localiza o personagem pelo Id")
    public ResponseEntity<Personagem> localizarPersonagem(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.localizarPersonagem(id) , HttpStatus.OK);
    }
    @PostMapping("/criar")
    @ApiOperation("Cria um novo personagem")
    public ResponseEntity<Personagem> criar(@RequestBody Personagem personagem) throws Exception {
        return new ResponseEntity<>(service.criar(personagem),HttpStatus.CREATED);
    }
    @PutMapping("/editar")
    @ApiOperation("Edita um personagem existente")
    public ResponseEntity<Personagem> editarPersonagem(@RequestBody Personagem personagem) throws Exception {
        return new ResponseEntity<>(service.editarPersonagem(personagem),HttpStatus.OK);
    }

    @DeleteMapping( "/excluir" )
    @ApiOperation( "Remove o personagem do campo de batalha" )
    public ResponseEntity< HttpStatus > excluir( @RequestHeader Long idPersonagem ) {
        service.excluir( idPersonagem );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
    @GetMapping("/cemiterio")
    @ApiOperation("Historico de personagens abatidos em combate")
    public ResponseEntity<List<Personagem>> cemiterio(){
        return new ResponseEntity<>(service.cemiterio() ,HttpStatus.OK);
    }
}
