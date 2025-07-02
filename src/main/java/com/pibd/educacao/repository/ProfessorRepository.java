package com.pibd.educacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pibd.educacao.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {    
}
