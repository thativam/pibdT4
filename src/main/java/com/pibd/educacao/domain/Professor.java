package com.pibd.educacao.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    private Long profId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "prof_id", foreignKey = @ForeignKey(name = "fk_pessoa"))
    private Pessoa pessoa;

    @Column
    private BigDecimal salario;
}

