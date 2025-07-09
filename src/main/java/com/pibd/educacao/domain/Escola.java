package com.pibd.educacao.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "escola")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Escola {

    @Id
    @Column(name = "escola_id")
    private Long escolaId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "escola_id", foreignKey = @ForeignKey(name = "fk_pessoa_id"))
    private Pessoa pessoa;

    @Column(length = 15, nullable = false)
    private String periodo;

    @Column(nullable = false)
    private Boolean inclusao;

    @Column(nullable = false)
    private Boolean particular;
}

