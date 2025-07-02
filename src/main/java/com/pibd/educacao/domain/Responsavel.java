package com.pibd.educacao.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsavel")
public class Responsavel {
    @EmbeddedId
    private ResponsavelId id;

    @ManyToOne
    @MapsId("respId")
    @JoinColumn(name = "resp_id", foreignKey =@ForeignKey(name = "fk_resp_id"))
    private Pessoa responsavel;

    @ManyToOne
    @MapsId("depId")
    @JoinColumn(name = "dep_id", foreignKey = @ForeignKey(name = "fk_dep_id"))
    private Pessoa dependente;

    @Column(nullable = false, length = 250)
    private String responsabilidade;
    
}
