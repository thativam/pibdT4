package com.pibd.educacao.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Escola;
import com.pibd.educacao.domain.Professor;
import com.pibd.educacao.repository.ProfessorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProfessorService {
    @Autowired
    private  ProfessorRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Professor save(Professor prof) {
        em.persist(prof);
        return prof;
    }

    public List<Professor> findAll(){
        return repository.findAll();
    }

    public Optional<Professor> getById(Long id){
        return repository.findById(id);
    }

}
