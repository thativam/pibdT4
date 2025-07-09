package com.pibd.educacao.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class DesempenhoId implements Serializable {

    @Column(name = "turma_id")
    private Long turmaId;

    @Column(name = "aluno_id")
    private Long alunoId;
}
