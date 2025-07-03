package com.pibd.educacao.domain.dto;

import java.time.LocalDate;

public record AlunoDto(
    String nome, 
    String endereco, 
    LocalDate dtNascimento, 
    String documento, 
    String telefone,
    Double media
  ) {
    public AlunoDto(String nome, String endereco, LocalDate dtNascimento, String documento, String telefone){
        this(nome, endereco, dtNascimento, documento, telefone,0.0);
    }
}
