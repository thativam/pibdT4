package com.pibd.educacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pibd.educacao.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
