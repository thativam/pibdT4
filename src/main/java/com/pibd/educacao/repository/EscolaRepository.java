package com.pibd.educacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pibd.educacao.domain.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
    
}
