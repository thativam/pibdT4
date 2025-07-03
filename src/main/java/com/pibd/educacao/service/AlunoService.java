package com.pibd.educacao.service;

import org.springframework.stereotype.Service;

import com.pibd.educacao.domain.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Aluno save(Aluno aluno) {
        em.persist(aluno);
        return aluno;
    }
}
