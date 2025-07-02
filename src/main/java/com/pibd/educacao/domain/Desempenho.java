package com.pibd.educacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "desempenho")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desempenho {

    @EmbeddedId
    private DesempenhoId id;

    @ManyToOne
    @MapsId("turmaId")
    @JoinColumn(name = "turma_id", foreignKey = @ForeignKey(name = "fk_turma_id"))
    private Turma turma;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id", foreignKey = @ForeignKey(name = "fk_aluno_id"))
    private Aluno aluno;

    @Column(name = "nota_final")
    private Double notaFinal;

    @Column
    private Double frequencia;

    @Column
    private Double participacao;

    @Column(length = 250)
    private String observacao;

    @Column
    private Short aprovado;
}

