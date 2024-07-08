package com.venilson.clubefutebol.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimeDeFutebol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String estadio;
    private BigDecimal dinheiroemCaixa;
    @OneToMany(mappedBy = "timeDeFutebol", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Jogador> jogadores;

}
