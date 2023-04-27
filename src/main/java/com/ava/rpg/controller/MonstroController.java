package com.ava.rpg.controller;

import com.ava.rpg.model.Luta;
import com.ava.rpg.model.Monstro;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.service.MonstroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rpg/monstro")
@CrossOrigin(value = "*")
public class MonstroController {
    @Autowired
    private MonstroService service;
    @GetMapping("/pesquisar")
    @ApiOperation("Pesquisa todos os monstros já encontrados")
    public ResponseEntity<List<Monstro>> listarMonstros(){
        return new ResponseEntity<>(service.listarMonstros() , HttpStatus.OK);
    }

    @GetMapping("/localizar/{idmonstro}")
    @ApiOperation("localiza um monstro específico que já conhecido")
    public ResponseEntity<Monstro> localizarMonstro(@PathVariable(value = "idmonstro") Long id){
        return new ResponseEntity<>(service.localizarMonstro(id), HttpStatus.OK);
    }

    @PostMapping("/criar/aleatorio")
    @ApiOperation("Encontra um monstro novo de classe aleatória")
    public ResponseEntity<Monstro> criarAleatorio(){
        return new ResponseEntity<>(service.criarAleatorio(),HttpStatus.CREATED);
    }
    @PostMapping("/criar")
    @ApiOperation("Encontra um monstro específico")
    public ResponseEntity<Monstro> criar(@RequestBody Monstro monstro) throws Exception {
        return new ResponseEntity<>(service.criar(monstro),HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    @ApiOperation("Edita um monstro existente")
    public ResponseEntity<Monstro> editarPersonagem(@RequestBody Monstro monstro) throws Exception {
        return new ResponseEntity<>(service.editarPersonagem(monstro),HttpStatus.OK);
    }

    @DeleteMapping( "/excluir" )
    @ApiOperation( "Remove o monstro do campo de batalha" )
    public ResponseEntity< HttpStatus > excluir( @RequestHeader Long idMonstro ) {
        service.excluir( idMonstro );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
    @GetMapping("/cemiterio")
    @ApiOperation("Historico de monstros abatidos em combate")
    public ResponseEntity<List<Monstro>> cemiterio(){
        return new ResponseEntity<>(service.cemiterio() ,HttpStatus.OK);
    }
}
