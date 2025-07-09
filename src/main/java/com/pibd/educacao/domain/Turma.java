package com.pibd.educacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turma")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id")
    private Long turmaId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "escola_id", nullable = false, foreignKey = @ForeignKey(name = "fk_escola_id"))
    private Escola escola;

    @ManyToOne
    @JoinColumn(name = "prof_id", foreignKey = @ForeignKey(name = "fk_prof_id"))
    private Professor professor;

    @Column(nullable = false)
    private Integer vagas;

    @Column(nullable = false)
    private Integer sala;

    @Column(nullable = false)
    private Integer ano;
}
