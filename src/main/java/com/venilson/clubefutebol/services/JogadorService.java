package com.venilson.clubefutebol.services;

import com.venilson.clubefutebol.models.Jogador;
import com.venilson.clubefutebol.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> findAll(){
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> findById(Long id){
        return jogadorRepository.findById(id);
    }

    public Jogador save(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public void deleteById(Long id){
        jogadorRepository.deleteById(id);
    }
}
