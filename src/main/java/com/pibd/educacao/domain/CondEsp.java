package com.pibd.educacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cond_esp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CondEsp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cond_id")
    private Long condId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id", nullable = false, foreignKey = @ForeignKey(name = "fk_aluno_id"))
    private Aluno aluno;

    @Column(name = "condicao", nullable = false, length = 250)
    private String condicao;
}
