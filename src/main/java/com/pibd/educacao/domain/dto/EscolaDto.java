package com.pibd.educacao.domain.dto;

import java.time.LocalDate;


public record EscolaDto( String nome, 
                         String endereco, 
                         LocalDate dtNascimento, 
                         String documento, 
                         String telefone, 
                         String periodo, 
                         boolean inclusao, 
                         boolean particular) {
    
    public EscolaDto(String nome, String endereco, LocalDate dtNascimento, String documento, String telefone) {
        this(nome, endereco, dtNascimento, documento, telefone, null, false, false);
    }
} 
