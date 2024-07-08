package com.venilson.clubefutebol.controllers;

import com.venilson.clubefutebol.models.Jogador;
import com.venilson.clubefutebol.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> listarJogador(){
        return jogadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getJogador(@PathVariable Long id){
        Optional<Jogador> jogador = jogadorService.findById(id);
        return jogador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jogador salvarJogador(@RequestBody Jogador jogador) {
        return jogadorService.save(jogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Long id) {
        if(jogadorService.findById(id).isPresent()) {
            jogadorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
