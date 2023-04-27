package com.ava.rpg.controller;

import com.ava.rpg.model.IniciativaLuta;
import com.ava.rpg.model.Luta;
import com.ava.rpg.model.Personagem;
import com.ava.rpg.service.LutaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rpg/luta")
@CrossOrigin(value = "*")
public class LutaController {

    @Autowired
    private LutaService service;



    @GetMapping("/iniciativa/{idPersonagem}/{idMonstro}")
    @ApiOperation("Iniciativa para determianr quem começa atacando entre o personagem e o monstro")
    public ResponseEntity<IniciativaLuta> iniciativaLuta(@PathVariable(value = "idPersonagem") Long idPersonagem, @PathVariable(value = "idMonstro") Long idMonstro){
        return new ResponseEntity<>(service.iniciativaLuta(idPersonagem,idMonstro) , HttpStatus.CREATED);
    }

    @GetMapping("/iniciativa/pesquisar")
    @ApiOperation("pesquisa todos as iniciativas")
    public ResponseEntity<List<IniciativaLuta>> listariniciativas(){
        return new ResponseEntity<>(service.listariniciativas() , HttpStatus.OK);
    }

    @PostMapping("/turno/automatico/{idIniciativa}/{identificador}")
    @ApiOperation("Gera um turno completo automaticamente.")
    public ResponseEntity<Luta> ataqueAutomatico(@PathVariable(value = "idIniciativa") Long idIniciativa, @PathVariable(value = "identificador") String identificador){
        return new ResponseEntity<>(service.ataqueAutomatico(idIniciativa,identificador),HttpStatus.CREATED);
    }

    @PostMapping("/turno/ataque/{idIniciativa}/{identificador}")
    @ApiOperation("Inicia o turno com um ataque")
    public ResponseEntity<Luta> ataque(@PathVariable(value = "idIniciativa") Long idIniciativa, @PathVariable(value = "identificador") String identificador){
        return new ResponseEntity<>(service.ataque(idIniciativa,identificador),HttpStatus.CREATED);
    }
    @PutMapping("/turno/defesa/{idTurno}/{identificador}")
    @ApiOperation("Continua o turno com a defesa")
    public ResponseEntity<Luta> defesa(@PathVariable(value = "idTurno") Long idTurno, @PathVariable(value = "identificador") String identificador){
        return new ResponseEntity<>(service.defesa(idTurno,identificador),HttpStatus.OK);
    }
    @PutMapping("/turno/dano/{idTurno}/{identificador}")
    @ApiOperation("Finaliza o turno com o calculo e aplicação do dano")
    public ResponseEntity<Luta> calcularDano(@PathVariable(value = "idTurno") Long idTurno, @PathVariable(value = "identificador") String identificador){
        return new ResponseEntity<>(service.calcularDano(idTurno,identificador),HttpStatus.OK);
    }

    @GetMapping("/historico/{idIniciativa}")
    @ApiOperation("Historico do combate entre o personagem e o monstro")
    public ResponseEntity<List<Luta>> historico(@PathVariable(value = "idIniciativa") Long idIniciativa){
        return new ResponseEntity<>(service.historicoLuta(idIniciativa) ,HttpStatus.OK);
    }
}
