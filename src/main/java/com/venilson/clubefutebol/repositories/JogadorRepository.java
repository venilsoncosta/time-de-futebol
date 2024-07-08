package com.venilson.clubefutebol.repositories;

import com.venilson.clubefutebol.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
