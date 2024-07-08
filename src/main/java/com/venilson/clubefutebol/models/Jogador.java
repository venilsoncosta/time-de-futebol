package com.venilson.clubefutebol.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "jogador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    @ManyToOne
    @JoinColumn(name = "time_id")
    @JsonBackReference
    private TimeDeFutebol timeDeFutebol;
}
