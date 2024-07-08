package com.venilson.clubefutebol.controllers;

import com.venilson.clubefutebol.models.Jogador;
import com.venilson.clubefutebol.models.TimeDeFutebol;
import com.venilson.clubefutebol.services.TimeDeFutebolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeDeFutebolController {
    private final TimeDeFutebolService service;

    @Autowired
    public TimeDeFutebolController(TimeDeFutebolService service) {
        this.service = service;
    }

    @GetMapping
    public List<TimeDeFutebol> listarTimes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDeFutebol> getTime(@PathVariable Long id) {
        Optional<TimeDeFutebol> time = service.findById(id);
        return time.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TimeDeFutebol saveTime(@RequestBody TimeDeFutebol time) {
        for (Jogador jogador : time.getJogadores()) {
            jogador.setTimeDeFutebol(time);
        }
        return service.save(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
