package com.pibd.educacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pibd.educacao.domain.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
    
}
