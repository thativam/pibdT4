package com.pibd.educacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @Column(name = "aluno_id")
    private Long alunoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "aluno_id", foreignKey = @ForeignKey(name = "fk_aluno"))
    private Pessoa pessoa;

    @Column
    private Double media;
}
