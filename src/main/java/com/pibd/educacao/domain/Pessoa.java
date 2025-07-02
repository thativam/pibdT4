package com.pibd.educacao.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@RequiredArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nome;

    @Column(length = 200)
    private String endereco;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(length = 30, nullable = false)
    private String documento;

    @Column(length = 20)
    private String telefone;

    @OneToMany(mappedBy = "dependente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsavel> responsaveis = new ArrayList<>();

}