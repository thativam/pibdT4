package com.pibd.educacao.domain.dto;


import java.math.BigDecimal;
import java.time.LocalDate;


public record ProfessorDto( 
    String nome, 
    String endereco, 
    LocalDate dtNascimento, 
    String documento, 
    String telefone, 
    BigDecimal salario) {
    public ProfessorDto(String nome, String endereco, LocalDate dtNascimento, String documento, String telefone) {
        this(nome, endereco, dtNascimento, documento, telefone, new BigDecimal(0));
    }
} 

