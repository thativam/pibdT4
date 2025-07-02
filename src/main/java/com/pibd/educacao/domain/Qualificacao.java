package com.pibd.educacao.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "qualificacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualif_id")
    private Long qualifId;

    @Column(name = "qualif", nullable = false, length = 250)
    private String qualif;

    @ManyToOne
    @JoinColumn(name = "prof_id", nullable = false, foreignKey = @ForeignKey(name = "fk_prof_id"))
    private Professor professor;
}

