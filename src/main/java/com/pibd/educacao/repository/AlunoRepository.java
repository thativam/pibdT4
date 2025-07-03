package com.pibd.educacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pibd.educacao.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
